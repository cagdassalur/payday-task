package com.cagdassalur.payday.service.user.impl;

import com.cagdassalur.payday.exception.DataIntegrityViolationDbException;
import com.cagdassalur.payday.repository.UserRepository;
import com.cagdassalur.payday.service.confirmationToken.impl.ConfirmationTokenServiceImpl;
import com.cagdassalur.payday.domain.EmailToken;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.user.UserDto;
import com.cagdassalur.payday.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationTokenServiceImpl confirmationTokenServiceImpl;

    @Override
    public User findByEmailIdIgnoreCase(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUserId(long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User findByEmailIdAndPassword(String email, String password) {
        return userRepository.findByEmailEqualsAndPasswordEquals(email, password);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public String register(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        user.setEnabled(false);

        try{
            userRepository.save(user);

            EmailToken emailToken = new EmailToken(user);
            confirmationTokenServiceImpl.save(emailToken);

            return emailToken.getConfirmationToken();
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationDbException("Could not register in db");
        }
    }
}
