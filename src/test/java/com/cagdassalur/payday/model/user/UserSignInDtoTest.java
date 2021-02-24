package com.cagdassalur.payday.model.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserSignInDtoTest {
    private static final String EXPECTED_EMAIL = "test@example.com";
    private static final String EXPECTED_PASSWORD = "password";
    private UserSignInDto userSignInDto;

    @Test
    void getEmail() {
        userSignInDto = new UserSignInDto();
        userSignInDto.setEmail("test@example.com");
        Assertions.assertEquals(EXPECTED_EMAIL, userSignInDto.getEmail());
    }

    @Test
    void getPassword() {
        userSignInDto = new UserSignInDto();
        userSignInDto.setPassword("password");
        Assertions.assertEquals(EXPECTED_PASSWORD, userSignInDto.getPassword());
    }
}