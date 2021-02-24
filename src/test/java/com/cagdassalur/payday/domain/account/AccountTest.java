package com.cagdassalur.payday.domain.account;

import com.cagdassalur.payday.domain.Account;
import com.cagdassalur.payday.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {
    private static final BigDecimal EXPECTED_CASH = new BigDecimal(120);
    private static final long EXPECTED_USER_ID = 30;
    private static final long EXPECTED_ACCOUNT_ID = 3;
    private Account account;

    @Test
    void getAccountId() {
        account = new Account();

        account.setAccountId(EXPECTED_ACCOUNT_ID);
        Assertions.assertEquals(EXPECTED_ACCOUNT_ID, account.getAccountId());
    }
    @Test
    void getCash() {
        account = new Account();
        account.setCash(EXPECTED_CASH);
        Assertions.assertEquals(EXPECTED_CASH, account.getCash());
    }

    @Test
    void getUser() {
        account = new Account();

        User user = new User();
        user.setUserId(EXPECTED_USER_ID);
        account.setUser(user);

        Assertions.assertEquals(user, account.getUser());
    }
}
