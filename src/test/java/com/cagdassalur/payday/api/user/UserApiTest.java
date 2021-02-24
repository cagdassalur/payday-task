package com.cagdassalur.payday.api.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.cagdassalur.payday.api.UserApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cagdassalur.payday.domain.EmailToken;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.user.UserDto;
import com.cagdassalur.payday.model.user.UserSignInDto;
import com.cagdassalur.payday.repository.UserRepository;
import com.cagdassalur.payday.service.confirmationToken.impl.ConfirmationTokenServiceImpl;
import com.cagdassalur.payday.service.email.EmailSenderService;
import com.cagdassalur.payday.service.user.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserApi.class)
class UserApiTest {
    private static final String EXPECTED_EMAIL = "test@example.com";
    private static final String EXPECTED_PASSWORD = "mugiwara";
    private static final String EXPECTED_USER_NAME = "username";
    private static final long EXPECTED_USER_ID = 0;
    private static final String EXPECTED_MESSAGE = "Successful. You can sign in to platform.";
    private static final String EXPECTED_TOKEN = "419f7735-0699-4544-9a23-f4f0ee650f01";
    private static final String EXPECTED_CONTENT_TYPE = "application/json";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    @MockBean
    private EmailSenderService emailSenderService;

    @MockBean
    private ConfirmationTokenServiceImpl confirmationTokenServiceImpl;

    @MockBean
    UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void register() {
        UserDto userDto = new UserDto();
        userDto.setEmail(EXPECTED_EMAIL);
        userDto.setPassword(EXPECTED_PASSWORD);
        userDto.setUserName(EXPECTED_USER_NAME);

        try {
            this.mockMvc.perform(post("/register")
                    .contentType(EXPECTED_CONTENT_TYPE)
                    .content(objectMapper.writeValueAsString(userDto)))
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void registerNullException() {
        UserDto userDto = new UserDto();
        userDto.setEmail(EXPECTED_EMAIL);
        userDto.setPassword(EXPECTED_PASSWORD);
        userDto.setUserName(EXPECTED_USER_NAME);

        User existingUser = new User();
        existingUser.setEnabled(true);
        existingUser.setUserId(1);

        Mockito
                .when(userService.findByEmailIdIgnoreCase(EXPECTED_PASSWORD))
                .thenReturn(existingUser);
        try {
            this.mockMvc.perform(post("/register")
                    .contentType(EXPECTED_CONTENT_TYPE)
                    .content(objectMapper.writeValueAsString(userDto)))
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void confirmUserAccount() {
        String token = EXPECTED_TOKEN;
        String url = "/confirm-account?token=" + EXPECTED_TOKEN;
        try {
            User user = new User();
            user.setEmail(EXPECTED_EMAIL);

            EmailToken emailToken = new EmailToken(user);
            Mockito
                    .when(confirmationTokenServiceImpl.findByConfirmationToken(token))
                    .thenReturn(emailToken);

            Mockito
                    .when(userService.findByEmailIdIgnoreCase(EXPECTED_EMAIL))
                    .thenReturn(user);

            this.mockMvc.perform(get(url)
                    .contentType(EXPECTED_CONTENT_TYPE)
                    .content(objectMapper.writeValueAsString(token)))
                .andExpect(content().string(String.valueOf(EXPECTED_MESSAGE)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void signIn() {
        UserSignInDto userSignInDto = new UserSignInDto();
        userSignInDto.setEmail(EXPECTED_EMAIL);
        userSignInDto.setPassword(EXPECTED_PASSWORD);
        try {
            this.mockMvc.perform(post("/sign-in")
                    .contentType(EXPECTED_CONTENT_TYPE)
                    .content(objectMapper.writeValueAsString(userSignInDto)))
                    .andExpect(content().string(String.valueOf(EXPECTED_USER_ID)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}