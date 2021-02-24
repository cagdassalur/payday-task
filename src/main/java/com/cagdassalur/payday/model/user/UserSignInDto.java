package com.cagdassalur.payday.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ApiModel(description="User Sign-in DTO")
public class UserSignInDto {

    @Email(message = "Email should be valid")
    @ApiModelProperty(notes="Email of customer")
    private String email;

    @Size(min=6, message="Password should be at least 6 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    @NotNull(message = "Password cannot be null")
    @ApiModelProperty(notes="Password of customer")
    private String password;
}