/*
 * @FileName       : IndexController.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */

package com.nagp.aggregator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.aggregator.model.OrderDetails;
import com.nagp.aggregator.service.OrderAggregatorService;


@RestController
@RequestMapping("/orderdetails")
public class IndexController {
	
	@Autowired OrderAggregatorService orderAggregatorService;

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to the User Service application. You can create a new User by making a POST request to /users endpoint.";
    }
    
    
    @GetMapping("/{id}")
    public OrderDetails getUser(@PathVariable(value = "id") Long userId) {
    	return this.orderAggregatorService.getUserOrders(userId);
    }
}
