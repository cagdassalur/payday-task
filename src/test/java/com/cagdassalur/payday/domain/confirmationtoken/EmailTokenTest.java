package com.cagdassalur.payday.domain.confirmationtoken;

import com.cagdassalur.payday.domain.EmailToken;
import com.cagdassalur.payday.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class EmailTokenTest {
    private static final long EXPECTED_TOKEN_ID = 30;
    private static final long EXPECTED_USER_ID = 1;
    private static final String EXPECTED_TOKEN = "419f7735-0699-4544-9a23-f4f0ee650f01";
    private EmailToken emailToken;

    @Test
    void getTokenId() {
        emailToken = new EmailToken();
        emailToken.setTokenId(EXPECTED_TOKEN_ID);
        Assertions.assertEquals(EXPECTED_TOKEN_ID, emailToken.getTokenId());
    }

    @Test
    void getConfirmationToken() {
        emailToken = new EmailToken();
        emailToken.setConfirmationToken(EXPECTED_TOKEN);
        Assertions.assertEquals(EXPECTED_TOKEN, emailToken.getConfirmationToken());
    }

    @Test
    void getCreatedDate() {
        emailToken = new EmailToken();
        Date createdDate = new Date();
        emailToken.setCreatedDate(createdDate);
        Assertions.assertEquals(createdDate, emailToken.getCreatedDate());
    }

    @Test
    void getUser() {
        emailToken = new EmailToken();
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);
        emailToken.setUser(user);

        Assertions.assertEquals(user, emailToken.getUser());
    }

    @Test
    public void setConfirmationTokenParameter() {
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);

        EmailToken emailTokenParameter = new EmailToken(user);
        EmailToken emailTokenWithoutParameter = new EmailToken();
        Assertions.assertNotEquals(emailTokenWithoutParameter, emailTokenParameter);
    }
}