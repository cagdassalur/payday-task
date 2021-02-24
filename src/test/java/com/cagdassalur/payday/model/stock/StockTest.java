package com.cagdassalur.payday.model.stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockTest {
    private static final String EXPECTED_PRICE = "1";
    private static final String EXPECTED_COUNTRY = "Turkey";
    private static final String EXPECTED_SYMBOL = "ACSEL";
    private static final String EXPECTED_CURRENCY = "TL";
    private static final String EXPECTED_NAME = "ACSEL Seluloz";
    private static final String EXPECTED_EXCHANGE = "ACSEL";
    private static final String EXPECTED_TYPE = "BIST 100";
    private Stock stock;

    @Test
    void getSymbol() {
        stock = new Stock();
        stock.setSymbol(EXPECTED_SYMBOL);
        Assertions.assertEquals(EXPECTED_SYMBOL, stock.getSymbol());
    }

    @Test
    void getName() {
        stock = new Stock();
        stock.setName(EXPECTED_NAME);
        Assertions.assertEquals(EXPECTED_NAME, stock.getName());
    }

    @Test
    void getCurrency() {
        stock = new Stock();
        stock.setCurrency(EXPECTED_CURRENCY);
        Assertions.assertEquals(EXPECTED_CURRENCY, stock.getCurrency());
    }

    @Test
    void getExchange() {
        stock = new Stock();
        stock.setExchange(EXPECTED_EXCHANGE);
        Assertions.assertEquals(EXPECTED_EXCHANGE, stock.getExchange());
    }

    @Test
    void getCountry() {
        stock = new Stock();
        stock.setCountry(EXPECTED_COUNTRY);
        Assertions.assertEquals(EXPECTED_COUNTRY, stock.getCountry());
    }

    @Test
    void getType() {
        stock = new Stock();
        stock.setType(EXPECTED_TYPE);
        Assertions.assertEquals(EXPECTED_TYPE, stock.getType());
    }

    @Test
    void getPrice() {
        stock = new Stock();
        stock.setPrice(EXPECTED_PRICE);
        Assertions.assertEquals(EXPECTED_PRICE, stock.getPrice());
    }
}