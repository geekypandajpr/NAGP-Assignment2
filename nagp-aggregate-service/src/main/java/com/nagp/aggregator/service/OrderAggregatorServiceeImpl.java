package com.nagp.aggregator.service;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.aggregator.model.Order;
import com.nagp.aggregator.model.OrderDetails;
import com.nagp.aggregator.model.User;

@Service
public class OrderAggregatorServiceeImpl implements OrderAggregatorService {

	@Value("${app.url.service.user}")
	private String userServiceUrl;
	
	@Value("${app.url.service.order}")
	private String orderServiceUrl;
	
	@Autowired RestTemplate template;
	
	@Override
	public OrderDetails getUserOrders(Long userId) {
		OrderDetails orderDetails = new OrderDetails();
		Order[] responseData = template.getForObject(orderServiceUrl + "/users/" +userId, Order[].class);
		User userInfo = template.getForObject(userServiceUrl + "/" +userId, User.class);
		orderDetails.setOrders(Arrays.asList(responseData));
		orderDetails.setUserDetails(userInfo);
		return orderDetails;
	}
	
	
	

}
