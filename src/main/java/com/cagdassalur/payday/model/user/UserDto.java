package com.cagdassalur.payday.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(description="UserDto")
public class UserDto {

    @Email(message = "Email should be valid")
    @ApiModelProperty(notes="Email of the User.")
    private String email;

    @NotNull(message = "Password cannot be null")
    @ApiModelProperty(notes="Password of the User.")
    private String password;

    @NotNull(message = "User name cannot be null")
    @ApiModelProperty(notes="Username of the user.")
    private String userName;
}