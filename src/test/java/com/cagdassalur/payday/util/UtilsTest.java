package com.cagdassalur.payday.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UtilsTest {
    private static final String EXPECTED_BUY = "BUY";
    private static final String EXPECTED_SELL = "SELL";

    @Test
    void setExpectedBuy() {
        Assertions.assertEquals(EXPECTED_BUY, Utils.BUY);
    }

    @Test
    void setExpectedSell() {
        Assertions.assertEquals(EXPECTED_SELL, Utils.SELL);
    }

}
