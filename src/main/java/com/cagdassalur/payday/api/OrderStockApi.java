package com.cagdassalur.payday.api;

import com.cagdassalur.payday.domain.User;
import com.cagdassalur.payday.exception.DataIntegrityViolationDbException;
import com.cagdassalur.payday.model.OrderstockDto;
import com.cagdassalur.payday.service.orderstock.impl.OrderstockServiceImpl;
import com.cagdassalur.payday.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value="Orderstock API")
public class OrderStockApi {

    @Autowired
    OrderstockServiceImpl orderstockServiceImpl;

    @Autowired
    UserService userService;

    @PostMapping("/order")
    @ApiOperation(value="Place an order behalf of customer.")
    public ResponseEntity<Object> order(@Valid @RequestBody OrderstockDto orderstockDto) {
        User user = userService.findByUserId(orderstockDto.getUserId());
        if (user == null || !user.isEnabled()) {
            throw new DataIntegrityViolationDbException("No such user");
        }

        try{
            orderstockServiceImpl.order(orderstockDto, user);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationDbException("Could not order");
        }

        return ResponseEntity.ok().build();
    }
}
