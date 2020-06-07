/*
 * @FileName       : UserService.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */

package com.nagp.order.service;

import java.util.List;

import com.nagp.order.model.Order;

public interface OrderService {
	
	public abstract Order createOrder(Order order);
	public abstract Order updateOrder(Long id, Order order);
	public abstract void deleteOrder(Long id);
	public abstract Order getOrder(Long id);
	public abstract List<Order> getOrders();
	public abstract List<Order> getOrderByUser(Long userId);
}
