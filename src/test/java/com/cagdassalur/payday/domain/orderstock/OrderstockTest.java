package com.cagdassalur.payday.domain.orderstock;

import com.cagdassalur.payday.domain.Orderstock;
import com.cagdassalur.payday.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OrderstockTest {
    private static final BigDecimal EXPECTED_CASH = new BigDecimal(120);
    private static final long EXPECTED_ORDERSTOCK_ID = 30;
    private static final long EXPECTED_STOCK_LOT = 10;
    private static final String EXPECTED_STOCK_SYMBOL = "ACSEL";
    private static final String EXPECTED_ORDER_TYPE = "BUY";
    private static final boolean EXPECTED_ACTIVE = true;
    private Orderstock orderstock;

    @Test
    void getOrderstockId() {
        orderstock = new Orderstock();
        orderstock.setOrderstockId(EXPECTED_ORDERSTOCK_ID);
        Assertions.assertEquals(EXPECTED_ORDERSTOCK_ID, orderstock.getOrderstockId());
    }

    @Test
    void getCash() {
        orderstock = new Orderstock();
        orderstock.setCash(EXPECTED_CASH);
        Assertions.assertEquals(EXPECTED_CASH, orderstock.getCash());
    }

    @Test
    void getStockSymbol() {
        orderstock = new Orderstock();
        orderstock.setStockSymbol(EXPECTED_STOCK_SYMBOL);
        Assertions.assertEquals(EXPECTED_STOCK_SYMBOL, orderstock.getStockSymbol());
    }

    @Test
    void getStockLot() {
        orderstock = new Orderstock();
        orderstock.setStockLot(EXPECTED_STOCK_LOT);
        Assertions.assertEquals(EXPECTED_STOCK_LOT, orderstock.getStockLot());
    }

    @Test
    void getOrderType() {
        orderstock = new Orderstock();
        orderstock.setOrderType(EXPECTED_ORDER_TYPE);
        Assertions.assertEquals(EXPECTED_ORDER_TYPE, orderstock.getOrderType());
    }

    @Test
    void isActive() {
        orderstock = new Orderstock();
        orderstock.setActive(EXPECTED_ACTIVE);
        Assertions.assertEquals(EXPECTED_ACTIVE, orderstock.isActive());
    }

    @Test
    void getUser() {
        orderstock = new Orderstock();
        User user = new User();
        orderstock.setUser(user);
        Assertions.assertEquals(user, orderstock.getUser());
    }
}