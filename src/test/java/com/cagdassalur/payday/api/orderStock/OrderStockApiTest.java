package com.cagdassalur.payday.api.orderStock;

import com.cagdassalur.payday.api.OrderStockApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cagdassalur.payday.domain.Orderstock;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.OrderstockDto;
import com.cagdassalur.payday.service.orderstock.impl.OrderstockServiceImpl;
import com.cagdassalur.payday.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderStockApi.class)
class OrderStockApiTest {
    private static final BigDecimal EXPECTED_CASH = new BigDecimal(120);
    private static final long EXPECTED_ORDERSTOCK_ID = 30;
    private static final long EXPECTED_STOCK_LOT = 10;
    private static final String EXPECTED_STOCK_SYMBOL = "ACSEL";
    private static final String EXPECTED_ORDER_TYPE = "BUY";
    private static final long EXPECTED_USER_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    OrderstockServiceImpl orderstockServiceImpl;

    @MockBean
    UserService userService;

    @Test
    void orderStock() {
        OrderstockDto orderstockDto = new OrderstockDto();
        orderstockDto.setUserId(EXPECTED_ORDERSTOCK_ID);
        orderstockDto.setStockLot(EXPECTED_STOCK_LOT);
        orderstockDto.setStockSymbol(EXPECTED_STOCK_SYMBOL);
        orderstockDto.setCash(EXPECTED_CASH);
        orderstockDto.setOrderType(EXPECTED_ORDER_TYPE);

        User existingUser = new User();
        existingUser.setUserId(EXPECTED_USER_ID);
        existingUser.setEnabled(true);
        Mockito
                .when(userService.findByUserId(orderstockDto.getUserId()))
                .thenReturn(existingUser);

        Orderstock orderstock = new Orderstock();
        Mockito
                .when(orderstockServiceImpl.orderstock(orderstockDto, existingUser))
                .thenReturn(orderstock);
        try {
            this.mockMvc.perform(post("/orderstock")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(orderstockDto)))
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}