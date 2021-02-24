package com.cagdassalur.payday.model.stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StockListTest {
    private static final String EXPECTED_OK = "ok";
    private static final List<Stock> EXPECTED_LIST_STOCK = new ArrayList<>();
    private StockList stockList;
    private List<Stock> stocks;

    @Test
    void getData() {
        stockList = new StockList();
        stocks = new ArrayList<>();
        stockList.setData(stocks);
        Assertions.assertEquals(EXPECTED_LIST_STOCK, stockList.getData());
    }

    @Test
    void getStatus() {
        stockList = new StockList();
        stockList.setStatus(EXPECTED_OK);
        Assertions.assertEquals(EXPECTED_OK, stockList.getStatus());
    }
}