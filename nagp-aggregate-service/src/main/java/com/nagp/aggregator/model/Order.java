/*
 * @FileName       : Order.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */

package com.nagp.aggregator.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Date;


public class Order {
	
    @JsonProperty("orderId")
    private Long id;

    @JsonProperty("orderAmount")
    private Double amount;

    @JsonProperty("orderDate")
    private Date orderDate;
    
    @JsonProperty("userId")
    private Long userId;

    
    
    

}
