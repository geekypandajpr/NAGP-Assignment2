/*
 * @FileName       : ConfigMap.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */
package com.nagp.aggregator.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigMap {
	
	@Value("${URL_USER_SERVICE:http://localhost:8081/users}")
	public String URL_USER_SERVICE;
	
	@Value("${URL_ORDER_SERVICE:http://localhost:8082/orders}")
	public String URL_ORDER_SERVICE;

}
