/*
 * @FileName       : OrderAggregatorService.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */

package com.nagp.aggregator.service;

import com.nagp.aggregator.model.OrderDetails;;

public interface OrderAggregatorService {
	public abstract OrderDetails getUserOrders(Long userId);
}
