package com.nagp.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.order.exception.ResourceNotFoundException;
import com.nagp.order.model.Order;
import com.nagp.order.repository.OrderRepository;

@Service
public class OrderServiceeImpl implements OrderService{

	@Autowired OrderRepository orderRepository;
	
	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		// TODO Auto-generated method stub
		Order orderObject = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		orderObject.setAmount(order.getAmount());
		orderObject.setOrderDate(order.getOrderDate());
		orderObject.setUserId(order.getUserId());
        Order updatedOrder = orderRepository.save(orderObject);
        return updatedOrder;
	}

	@Override
	public void deleteOrder(Long id) {
		// TODO Auto-generated method stub
		Order order = this.orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        this.orderRepository.delete(order);
	}
	
	@Override
	public Order getOrder(Long id) {
		return this.orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
	}

	@Override
	public List<Order> getOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public List<Order> getOrderByUser(Long userId) {
		// TODO Auto-generated method stub
		return this.orderRepository.findAllByUserId(userId);
	}

}
