package com.cagdassalur.payday.service.account;

import com.cagdassalur.payday.domain.Account;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.AccountDto;

public interface AccountService {
    Account loadCash(AccountDto accountDto, User user);
    Account withdrawCash(AccountDto accountDto, User user);
    Account findByUser(User user);
}
