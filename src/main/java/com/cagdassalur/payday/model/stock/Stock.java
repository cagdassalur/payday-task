package com.cagdassalur.payday.model.stock;

import lombok.Data;

@Data
public class Stock {

    private String symbol;
    private String name;
    private String currency;
    private String exchange;
    private String country;
    private String type;
    private String price;

}
