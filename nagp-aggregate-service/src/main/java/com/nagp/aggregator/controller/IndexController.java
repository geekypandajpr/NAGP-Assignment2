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


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagp.aggregator.common.ConfigMap;
import com.nagp.aggregator.model.Order;
import com.nagp.aggregator.model.OrderDetails;
import com.nagp.aggregator.model.User;


@RestController
@RequestMapping("/orderdetails")
public class IndexController {
	
	@Autowired RestTemplate template;
	@Autowired ConfigMap config;

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to the Aggregate Service application. You can get User order details  by making a POST request to /orderdetails/{userId} endpoint.";
    }
    
    
    @GetMapping("/{id}")
    public OrderDetails getUser(@PathVariable(value = "id") Long userId) {
    	OrderDetails orderDetails = new OrderDetails();
		Order[] responseData = template.getForObject(config.URL_ORDER_SERVICE + "/users/" +userId, Order[].class);
		User userInfo = template.getForObject(config.URL_USER_SERVICE + "/" +userId, User.class);
		orderDetails.setOrders(Arrays.asList(responseData));
		orderDetails.setUserDetails(userInfo);
		return orderDetails;
    }
}
