package com.cagdassalur.payday.service.orderstock.impl;

import com.cagdassalur.payday.domain.Orderstock;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.exception.DataIntegrityViolationDbException;
import com.cagdassalur.payday.model.OrderstockDto;
import com.cagdassalur.payday.repository.AccountRepository;
import com.cagdassalur.payday.repository.OrderstockRepository;
import com.cagdassalur.payday.service.account.impl.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class OrderstockServiceImplTest {
    private static final BigDecimal EXPECTED_CASH = new BigDecimal(120);
    private static final long EXPECTED_ORDERSTOCK_ID = 30;
    private static final long EXPECTED_USER_ID = 1;
    private static final long EXPECTED_STOCK_LOT = 10;
    private static final String EXPECTED_STOCK_SYMBOL = "ACSEL";
    private static final String EXPECTED_ORDER_TYPE_BUY = "BUY";
    private static final String EXPECTED_ORDER_TYPE_SELL = "SELL";

    @InjectMocks
    OrderstockServiceImpl orderstockServiceImpl;

    @Mock
    private OrderstockRepository orderstockRepository;

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @Mock
    AccountRepository accountRepository;

    @Test
    void buyStock() {
        Orderstock orderstock = new Orderstock();
        orderstock.setStockSymbol(EXPECTED_STOCK_SYMBOL);

        Mockito.when(orderstockServiceImpl.buyStock(EXPECTED_STOCK_SYMBOL, EXPECTED_ORDER_TYPE_BUY, EXPECTED_CASH)).thenReturn(Collections.singletonList(orderstock));
        List<Orderstock> orderstockListTest = orderstockServiceImpl.buyStock(EXPECTED_STOCK_SYMBOL, EXPECTED_ORDER_TYPE_BUY, EXPECTED_CASH);

        Assertions.assertEquals(orderstockListTest.size(), 1);
    }

    @Test
    void sellStock() {
        Orderstock orderstock = new Orderstock();
        orderstock.setStockSymbol(EXPECTED_STOCK_SYMBOL);

        Mockito.when(orderstockServiceImpl.sellStock(EXPECTED_STOCK_SYMBOL, EXPECTED_ORDER_TYPE_SELL, EXPECTED_CASH)).thenReturn(Collections.singletonList(orderstock));
        List<Orderstock> orderstockListTest = orderstockServiceImpl.sellStock(EXPECTED_STOCK_SYMBOL, EXPECTED_ORDER_TYPE_SELL, EXPECTED_CASH);

        Assertions.assertEquals(orderstockListTest.size(), 1);
    }

    @Test
    void updateOrderstock() {
        Orderstock orderstock = new Orderstock();
        orderstock.setOrderstockId(EXPECTED_ORDERSTOCK_ID);
        orderstock.setStockSymbol(EXPECTED_STOCK_SYMBOL);

        Mockito.when(orderstockServiceImpl.updateOrderstock(orderstock)).thenReturn(orderstock);
        Orderstock orderstockTest = orderstockServiceImpl.updateOrderstock(orderstock);

        Assertions.assertEquals(orderstockTest, orderstock);
    }

    @Test
    void orderstock() throws DataIntegrityViolationDbException {
        accountServiceImpl = new AccountServiceImpl(accountRepository);
        orderstockServiceImpl = new OrderstockServiceImpl(orderstockRepository,accountServiceImpl);
        OrderstockDto orderstockDto = new OrderstockDto();
        orderstockDto.setCash(EXPECTED_CASH);
        orderstockDto.setOrderType(EXPECTED_ORDER_TYPE_BUY);
        orderstockDto.setStockLot(EXPECTED_STOCK_LOT);
        orderstockDto.setStockSymbol(EXPECTED_STOCK_SYMBOL);
        orderstockDto.setUserId(EXPECTED_USER_ID);

        User user = new User();
        user.setUserId(EXPECTED_USER_ID);

        Orderstock orderstock = new Orderstock();
        orderstock.setUser(user);
        try {
            Mockito.when(orderstockServiceImpl.orderstock(orderstockDto, user)).thenThrow(new DataIntegrityViolationDbException("There is not enough money on your account. It is not allowed to buy stock"));
        } catch (DataIntegrityViolationDbException ex){

        }

        try {
            Mockito.lenient().when(orderstockRepository.save(orderstock)).thenThrow(new DataIntegrityViolationDbException("Could not register in db"));
        } catch (DataIntegrityViolationDbException ex){

        }

    }
}