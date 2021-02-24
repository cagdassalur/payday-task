package com.cagdassalur.payday.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataIntegrityViolationDbExceptionTest {
    private static final String EXPECTED_MESSAGE = "Couldn't create";
    private DataIntegrityViolationDbException dataIntegrityViolationDbException;

    @Test
    void setStockResponseDto() {
        dataIntegrityViolationDbException = new DataIntegrityViolationDbException("Couldn't create");
        Assertions.assertEquals(EXPECTED_MESSAGE, dataIntegrityViolationDbException.getMessage());
    }
}