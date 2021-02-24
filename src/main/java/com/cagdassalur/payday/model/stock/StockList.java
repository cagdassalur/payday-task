package com.cagdassalur.payday.model.stock;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StockList {
    private List<Stock> data;
    private String status;

    public StockList() {
        data = new ArrayList<Stock>();
    }
}
