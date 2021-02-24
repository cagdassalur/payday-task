package com.cagdassalur.payday.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel(description="OrderstockDto")
public class OrderstockDto {

    @ApiModelProperty(notes="Order amount")
    private BigDecimal cash;

    @ApiModelProperty(notes="Stock symbol")
    private String stockSymbol;

    @ApiModelProperty(notes="Shares to be ordered")
    private long stockLot;

    @ApiModelProperty(notes="BUY/SELL")
    private String orderType;

    @NotNull
    @ApiModelProperty(notes="Unique user id.")
    private long userId;
}