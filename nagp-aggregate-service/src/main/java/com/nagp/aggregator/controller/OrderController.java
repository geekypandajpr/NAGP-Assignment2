/*
 * @FileName       : OrderController.java
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.nagp.aggregator.common.ConfigMap;
import com.nagp.aggregator.model.Order;

import javax.validation.Valid;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired ConfigMap config;
	@Autowired RestTemplate template;

    @GetMapping("")
    public List<Order> listOrders() {
    	Order[] responseData = template.getForObject(config.URL_ORDER_SERVICE, Order[].class);
		return Arrays.asList(responseData);
    }

    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order) {
    	return template.postForObject(config.URL_ORDER_SERVICE, order, Order.class);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable(value = "id") Long orderId) {
    	return template.getForObject(config.URL_ORDER_SERVICE + "/"+orderId, Order.class);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable(value = "id") Long orderId,
                                           @Valid @RequestBody Order orderDetails) {
    	HttpEntity<Order> requestEntity = new HttpEntity<Order>(orderDetails, new HttpHeaders());
		return template.exchange(config.URL_ORDER_SERVICE + "/"+orderId, HttpMethod.PUT, requestEntity, Order.class).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long orderId) {
    	template.delete(URI.create(config.URL_ORDER_SERVICE + "/"+orderId));
        return ResponseEntity.ok().build();
    }
}
