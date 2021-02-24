package com.cagdassalur.payday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DataIntegrityViolationDbException extends RuntimeException {
    public DataIntegrityViolationDbException(String message) {
        super(message);
    }
}
