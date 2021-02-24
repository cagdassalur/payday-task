package com.cagdassalur.payday.service.orderstock;

import com.cagdassalur.payday.domain.Orderstock;
import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.model.OrderstockDto;

import java.math.BigDecimal;
import java.util.List;

public interface OrderstockService {
    List<Orderstock> buyStock(String stockSymbol, String orderType, BigDecimal cash);
    List<Orderstock> sellStock(String stockSymbol, String orderType, BigDecimal cash);
    Orderstock updateOrderstock(Orderstock orderstock);
    Orderstock orderstock(OrderstockDto orderstockDto, User user);
}
