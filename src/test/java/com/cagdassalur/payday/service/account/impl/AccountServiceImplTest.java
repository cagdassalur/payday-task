package com.cagdassalur.payday.service.account.impl;

import com.cagdassalur.payday.domain.Account;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.AccountDto;
import com.cagdassalur.payday.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    private static final BigDecimal EXPECTED_CASH = new BigDecimal(120);
    private static final long EXPECTED_USER_ID = 30;

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @Mock
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loadCash() {
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);

        Account account = new Account();
        account.setAccountId(EXPECTED_USER_ID);
        account.setUser(user);
        account.setCash(EXPECTED_CASH);

        AccountDto accountDto = new AccountDto();
        accountDto.setCash(EXPECTED_CASH);
        accountDto.setUserId(EXPECTED_USER_ID);

        Mockito.when(accountServiceImpl.loadCash(accountDto,user)).thenReturn(account);
        Account accountTest = accountServiceImpl.loadCash(accountDto,user);

        Assertions.assertEquals(accountTest, account);

        Mockito
                .when(accountRepository.findByUser(user))
                .thenReturn(account);

        Mockito.when(accountServiceImpl.loadCash(accountDto,user)).thenReturn(account);
        accountTest = accountServiceImpl.loadCash(accountDto,user);

        Assertions.assertEquals(accountTest, account);
    }

    @Test
    void withdrawCash() {
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);

        Account account = new Account();
        account.setAccountId(EXPECTED_USER_ID);
        account.setUser(user);
        account.setCash(EXPECTED_CASH);

        AccountDto accountDto = new AccountDto();
        accountDto.setCash(EXPECTED_CASH);
        accountDto.setUserId(EXPECTED_USER_ID);

        Mockito.when(accountServiceImpl.withdrawCash(accountDto,user)).thenReturn(account);
        Account accountTest = accountServiceImpl.withdrawCash(accountDto,user);

        Assertions.assertEquals(accountTest, account);

        Mockito
                .when(accountRepository.findByUser(user))
                .thenReturn(account);

        Mockito.when(accountServiceImpl.withdrawCash(accountDto,user)).thenReturn(account);
        accountTest = accountServiceImpl.withdrawCash(accountDto,user);
    }

    @Test
    void findByUser() {
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);

        Account account = new Account();
        account.setCash(EXPECTED_CASH);
        account.setUser(user);
        Mockito.when(accountServiceImpl.findByUser(user)).thenReturn(account);
        Account accountTest = accountServiceImpl.findByUser(user);

        Assertions.assertEquals(accountTest, account);
    }
}