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

package com.nagp.order.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.nagp.order.service.OrderService;
import com.nagp.order.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired OrderService orderService;

    @GetMapping("")
    public List<Order> listOrders() {
        return this.orderService.getOrders();
    }
    
    @GetMapping("/users/{id}")
    public List<Order> orderByUser(@PathVariable(value = "id") Long userId) {
        return this.orderService.getOrderByUser(userId);
    }

    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order) {
        return this.orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable(value = "id") Long orderId) {
        return this.orderService.getOrder(orderId);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable(value = "id") Long orderId,
                                           @Valid @RequestBody Order orderDetails) {
    	return this.orderService.updateOrder(orderId, orderDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long orderId) {
        this.orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
