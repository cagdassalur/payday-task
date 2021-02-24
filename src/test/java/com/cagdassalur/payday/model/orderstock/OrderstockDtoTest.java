package com.cagdassalur.payday.model.orderstock;

import com.cagdassalur.payday.model.OrderstockDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OrderstockDtoTest {
    private static final BigDecimal EXPECTED_CASH = new BigDecimal(120);
    private static final long EXPECTED_USER_ID = 30;
    private static final long EXPECTED_STOCK_LOT = 10;
    private static final String EXPECTED_STOCK_SYMBOL = "ACSEL";
    private static final String EXPECTED_ORDER_TYPE = "BUY";
    private OrderstockDto orderstockDto;

    @Test
    void getCash() {
        orderstockDto = new OrderstockDto();
        orderstockDto.setCash(EXPECTED_CASH);
        Assertions.assertEquals(EXPECTED_CASH, orderstockDto.getCash());
    }

    @Test
    void getStockSymbol() {
        orderstockDto = new OrderstockDto();
        orderstockDto.setStockSymbol(EXPECTED_STOCK_SYMBOL);
        Assertions.assertEquals(EXPECTED_STOCK_SYMBOL, orderstockDto.getStockSymbol());
    }

    @Test
    void getStockLot() {
        orderstockDto = new OrderstockDto();
        orderstockDto.setStockLot(EXPECTED_STOCK_LOT);
        Assertions.assertEquals(EXPECTED_STOCK_LOT, orderstockDto.getStockLot());
    }

    @Test
    void getOrderType() {
        orderstockDto = new OrderstockDto();
        orderstockDto.setOrderType(EXPECTED_ORDER_TYPE);
        Assertions.assertEquals(EXPECTED_ORDER_TYPE, orderstockDto.getOrderType());
    }

    @Test
    void getUserId() {
        orderstockDto = new OrderstockDto();
        orderstockDto.setUserId(30);
        Assertions.assertEquals(EXPECTED_USER_ID, orderstockDto.getUserId());
    }
}