package com.cagdassalur.payday.repository;

import com.cagdassalur.payday.domain.Account;
import com.cagdassalur.payday.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUser(User userId);
}
