package com.cagdassalur.payday.service.confirmationToken.impl;

import com.cagdassalur.payday.domain.EmailToken;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.repository.ConfirmationTokenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailTokenServiceImplTest {
    public static final long EXPECTED_USER_ID = 1;
    public static final String EXPECTED_TOKEN = "419f7735-0699-4544-9a23-f4f0ee650f01";

    @InjectMocks
    ConfirmationTokenServiceImpl confirmationTokenServiceImpl;

    @Mock
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Test
    void save() {
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);
        EmailToken emailToken = new EmailToken(user);

        Mockito.when(confirmationTokenServiceImpl.save(emailToken)).thenReturn(emailToken);
        EmailToken emailTokenTest = confirmationTokenServiceImpl.save(emailToken);

        Assertions.assertEquals(emailTokenTest.getUser(), emailToken.getUser());
    }

    @Test
    void findByConfirmationToken() {
        User user = new User();
        user.setUserId(EXPECTED_USER_ID);

        EmailToken emailToken = new EmailToken();
        emailToken.setConfirmationToken(EXPECTED_TOKEN);
        emailToken.setUser(user);

        Mockito.when(confirmationTokenServiceImpl.findByConfirmationToken(EXPECTED_TOKEN)).thenReturn(emailToken);
        EmailToken emailTokenTest = confirmationTokenServiceImpl.findByConfirmationToken(EXPECTED_TOKEN);

        Assertions.assertEquals(emailTokenTest.getTokenId(), emailToken.getTokenId());
    }
}