package com.cagdassalur.payday.model.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="Stock response DTO")
public class StockResponseDto {

    @ApiModelProperty(notes="Stock symbol")
    private String symbol;

    @ApiModelProperty(notes="Price of the stock")
    private String price;
}
