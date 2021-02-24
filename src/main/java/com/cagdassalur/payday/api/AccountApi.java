package com.cagdassalur.payday.api;

import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.exception.DataIntegrityViolationDbException;
import com.cagdassalur.payday.model.AccountDto;
import com.cagdassalur.payday.service.account.impl.AccountServiceImpl;
import com.cagdassalur.payday.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value="Account API")
public class AccountApi {

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Autowired
    UserService userService;

    @PostMapping("/deposit")
    @ApiOperation(value = "Deposit amount into account")
    public ResponseEntity<Object> deposit(@Valid @RequestBody AccountDto accountDto) {
        User user = userService.findByUserId(accountDto.getUserId());
        if (user == null || !user.isEnabled()) {
            throw new DataIntegrityViolationDbException("No such user");
        }

        try{
            accountServiceImpl.deposit(accountDto, user);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationDbException("Could not deposit");
        }

        return ResponseEntity.ok().build();
    }
}
