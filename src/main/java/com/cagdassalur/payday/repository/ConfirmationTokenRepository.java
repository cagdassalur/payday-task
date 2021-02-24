package com.cagdassalur.payday.repository;

import com.cagdassalur.payday.domain.EmailToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<EmailToken, Long> {
    EmailToken findByConfirmationToken(String confirmationToken);
}
