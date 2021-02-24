package com.cagdassalur.payday.domain.user;

import com.cagdassalur.payday.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    private static final long EXPECTED_USER_ID = 58;
    private static final String EXPECTED_USER_NAME = "username";
    private static final String EXPECTED_EMAIL = "test@example.com";
    private static final String EXPECTED_PASSWORD = "password";
    private static final Boolean EXPECTED_ENABLED = true;
    private User user;

    @Test
    void getUserId() {
        user = new User();
        user.setUserId(EXPECTED_USER_ID);
        Assertions.assertEquals(EXPECTED_USER_ID, user.getUserId());
    }

    @Test
    void getEmail() {
        user = new User();
        user.setPassword(EXPECTED_EMAIL);
        Assertions.assertEquals(EXPECTED_EMAIL, user.getPassword());
    }

    @Test
    void getPassword() {
        user = new User();
        user.setPassword(EXPECTED_PASSWORD);
        Assertions.assertEquals(EXPECTED_PASSWORD, user.getPassword());
    }

    @Test
    void getUserName() {
        user = new User();
        user.setUserName(EXPECTED_USER_NAME);
        Assertions.assertEquals(EXPECTED_USER_NAME, user.getUserName());
    }

    @Test
    void isEnabled() {
        user = new User();
        user.setEnabled(EXPECTED_ENABLED);
        Assertions.assertEquals(EXPECTED_ENABLED, user.isEnabled());
    }

}