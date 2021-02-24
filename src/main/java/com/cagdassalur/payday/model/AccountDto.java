package com.cagdassalur.payday.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel(description="AccountDto")
public class AccountDto {

    @NotNull
    @ApiModelProperty(notes="Cash amount of the account.")
    private BigDecimal cash;

    @NotNull
    @ApiModelProperty(notes="Unique id for account")
    private long userId;
}
