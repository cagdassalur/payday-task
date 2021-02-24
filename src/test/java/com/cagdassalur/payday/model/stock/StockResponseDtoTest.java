package com.cagdassalur.payday.model.stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockResponseDtoTest {
    private static final String EXPECTED_SYMBOL = "ACSEL";
    private static final String EXPECTED_PRICE = "1";
    private StockResponseDto stockResponseDto;

    @Test
    void getSymbol() {
        stockResponseDto = new StockResponseDto();
        stockResponseDto.setSymbol("ACSEL");
        Assertions.assertEquals(EXPECTED_SYMBOL, stockResponseDto.getSymbol());
    }

    @Test
    void getPrice() {
        stockResponseDto = new StockResponseDto();
        stockResponseDto.setPrice("1");
        Assertions.assertEquals(EXPECTED_PRICE, stockResponseDto.getPrice());
    }
}