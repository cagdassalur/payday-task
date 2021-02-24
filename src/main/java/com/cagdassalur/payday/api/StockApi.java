package com.cagdassalur.payday.api;

import com.google.common.collect.Lists;
import com.cagdassalur.payday.model.stock.Stock;
import com.cagdassalur.payday.model.stock.StockList;
import com.cagdassalur.payday.model.stock.StockPrice;
import com.cagdassalur.payday.model.stock.StockResponseDto;
import com.cagdassalur.payday.service.stock.StockManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Api(value="Stock API")
public class StockApi {

    @Autowired
    StockManagementService stockManagementService;

    @GetMapping("/stock")
    @ApiOperation(value="Returns stock prices")
    public List<StockResponseDto> stock()
    {
        StockList stockListApi = stockManagementService.findShareByCountry("Turkey");
        List<List<Stock>> stockLists =  Lists.partition(stockListApi.getData(), 20);
        List<Stock> firstStockList = stockLists.get(0);

        Random rand = new Random();
        double randomPrice;
        List<StockResponseDto> stocks = new ArrayList<>();
        for (Stock stock: firstStockList) {
            StockResponseDto stockResponseDto = new StockResponseDto();
            StockPrice price = stockManagementService.stockPrice(stock.getSymbol());
            randomPrice = rand.nextDouble() * 100;
            stockResponseDto.setPrice(price != null && price.getPrice() != null ? price.getPrice() : String.valueOf(randomPrice));
            stockResponseDto.setSymbol(stock.getSymbol());

            stocks.add(stockResponseDto);
        }
        return stocks;
    }

}
