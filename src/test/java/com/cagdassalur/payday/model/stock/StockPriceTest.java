package com.cagdassalur.payday.model.stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockPriceTest {
    private static final String EXPECTED_PRICE = "1";
    private StockPrice stockPrice;

    @Test
    void getPrice() {
        stockPrice = new StockPrice();
        stockPrice.setPrice(EXPECTED_PRICE);
        Assertions.assertEquals(EXPECTED_PRICE, stockPrice.getPrice());
    }
}