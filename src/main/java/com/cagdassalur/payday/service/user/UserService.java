package com.cagdassalur.payday.service.user;

import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.user.UserDto;

public interface UserService {

    User findByEmailIdIgnoreCase(String email);
    User findByUserId(long userId);
    User findByEmailIdAndPassword(String email, String password);
    User updateUser(User user);
    String register(UserDto userDto);
}
