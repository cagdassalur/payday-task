package com.cagdassalur.payday.event;

import com.cagdassalur.payday.service.stock.StockManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;


@ExtendWith(MockitoExtension.class)
class StockOrderEventListenerTest {
    private static final String EXPECTED_COUNTRY = "Turkey";

    @InjectMocks
    StockOrderEventListener stockOrderEventListener;

    @InjectMocks
    StockManagementService stockManagementService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void stockOrderEventListener() throws InterruptedException {
  /*
        StockList stockList = new StockList();
        Mockito
                .when(restTemplate.getForEntity("https://api.twelvedata.com/stocks?country="+EXPECTED_COUNTRY, StockList.class))
                .thenReturn(new ResponseEntity(stockList, HttpStatus.OK));

        Mockito
                .when(stockManagementService.findShareByCountry("Turkey"))
                .thenReturn(stockList);
        stockOrderEventListener.stockOrderEventListener();
   */
    }
}