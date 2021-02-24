package com.cagdassalur.payday.repository;

import com.cagdassalur.payday.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserId(long userId);
    User findByEmailEqualsAndPasswordEquals(String email,String password);
}
