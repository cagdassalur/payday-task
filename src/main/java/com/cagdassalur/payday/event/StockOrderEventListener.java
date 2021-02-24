package com.cagdassalur.payday.event;

import com.google.common.collect.Lists;
import com.cagdassalur.payday.model.stock.Stock;
import com.cagdassalur.payday.model.stock.StockList;
import com.cagdassalur.payday.service.stock.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockOrderEventListener {

    @Autowired
    StockManagementService stockManagementService;

    @EventListener(ApplicationReadyEvent.class)
    public void stockOrderEventListener() throws InterruptedException {
        StockList stockListApi = stockManagementService.findShareByCountry("Turkey");
        List<List<Stock>> stockLists =  Lists.partition(stockListApi.getData(), 10);
        List<Stock> firstPartList = stockLists.get(0);

        while(true) {
            for (Stock stock : firstPartList) {
                stockManagementService.getPricesBySymbolEvent(stock);
            }
        }
    }

}
