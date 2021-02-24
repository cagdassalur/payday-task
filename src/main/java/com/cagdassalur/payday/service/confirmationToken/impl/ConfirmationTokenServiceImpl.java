package com.cagdassalur.payday.service.confirmationToken.impl;

import com.cagdassalur.payday.repository.ConfirmationTokenRepository;
import com.cagdassalur.payday.domain.EmailToken;
import com.cagdassalur.payday.service.confirmationToken.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public EmailToken save(EmailToken emailToken) {
        return confirmationTokenRepository.save(emailToken);
    }

    @Override
    public EmailToken findByToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }
}
