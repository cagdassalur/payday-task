package com.cagdassalur.payday.service.confirmationToken;

import com.cagdassalur.payday.domain.EmailToken;

public interface ConfirmationTokenService {
    EmailToken save(EmailToken emailToken);
    EmailToken findByConfirmationToken(String confirmationToken);
}
