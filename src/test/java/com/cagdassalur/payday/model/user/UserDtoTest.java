package com.cagdassalur.payday.model.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDtoTest {
    private static final String EXPECTED_USER_NAME = "username";
    private static final String EXPECTED_EMAIL = "test@example.com";
    private static final String EXPECTED_PASSWORD = "password";
    private UserDto userDto;

    @Test
    void getEmail() {
        userDto = new UserDto();
        userDto.setEmail("test@example.com");
        Assertions.assertEquals(EXPECTED_EMAIL, userDto.getEmail());
    }

    @Test
    void getPassword() {
        userDto = new UserDto();
        userDto.setPassword("password");
        Assertions.assertEquals(EXPECTED_PASSWORD, userDto.getPassword());
    }

    @Test
    void getUserName() {
        userDto = new UserDto();
        userDto.setUserName("username");
        Assertions.assertEquals(EXPECTED_USER_NAME, userDto.getUserName());
    }
}