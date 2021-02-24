package com.cagdassalur.payday.api;

import com.cagdassalur.payday.domain.EmailToken;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.exception.DataIntegrityViolationDbException;
import com.cagdassalur.payday.model.user.UserDto;
import com.cagdassalur.payday.model.user.UserSignInDto;
import com.cagdassalur.payday.service.confirmationToken.impl.ConfirmationTokenServiceImpl;
import com.cagdassalur.payday.service.email.EmailSenderService;
import com.cagdassalur.payday.service.user.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value="User API")
public class UserApi {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ConfirmationTokenServiceImpl confirmationTokenServiceImpl;

    @Value( "${spring.mail.username}" )
    private String username;

    @PostMapping("/register")
    @ApiOperation(value="Registers a user")
    public boolean register(@Valid @RequestBody UserDto userDto) {
        String register;

        User existingUser = service.findByEmailIdIgnoreCase(userDto.getEmail());
        if (existingUser != null) {
            throw new DataIntegrityViolationDbException("This email is taken");
        } else {
            register = service.register(userDto);

            emailSenderService.sendEmail(userDto.getEmail(), "Payday registration confirmation", username,"For confirmation, please follow the link : "
                    +"http://localhost:8082/confirm-account?token="+register);
            return true;
        }
    }

    @GetMapping("/confirm")
    @ApiOperation(value="Activates a user by email confirmation")
    public String confirmUserAccount(@RequestParam(required = true) String token)
    {
        EmailToken emailToken = confirmationTokenServiceImpl.findByToken(token);

        if(token != null) {
            User user = service.findByEmailIdIgnoreCase(emailToken.getUser().getEmail());
            user.setEnabled(true);
            service.updateUser(user);
            return "Success! You can sign in now.";
        }
        return "Unsuccessful";
    }

    @PostMapping("/sign-in")
    @ApiOperation(value="Signs-in the user")
    public Long signIn(@Valid @RequestBody UserSignInDto userSignInDto)
    {
        User existingUser = service.findByEmailIdAndPassword(userSignInDto.getEmail(), userSignInDto.getPassword());
        if (existingUser != null && existingUser.isEnabled()) {
            return existingUser.getUserId();
        }

        return 0l;
    }
}
