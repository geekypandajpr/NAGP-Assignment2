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
import com.nagp.aggregator.model.User;

import javax.validation.Valid;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired ConfigMap config;
	@Autowired RestTemplate template;

    @GetMapping("")
    public List<User> listUsers() {
    	User[] responseData = template.getForObject(config.URL_USER_SERVICE, User[].class);
		return Arrays.asList(responseData);
    }

    @PostMapping("")
    public User createUser(@Valid @RequestBody User user) {
    	return template.postForObject(config.URL_USER_SERVICE, user, User.class);
    }

    @GetMapping("/{id}")
    public User getOrder(@PathVariable(value = "id") Long userId) {
    	return template.getForObject(config.URL_USER_SERVICE + "/"+userId, User.class);
    }

    @PutMapping("/{id}")
    public User updateOrder(@PathVariable(value = "id") Long orderId,
                                           @Valid @RequestBody User userInfo) {
    	HttpEntity<User> requestEntity = new HttpEntity<User>(userInfo, new HttpHeaders());
		return template.exchange(config.URL_USER_SERVICE + "/"+orderId, HttpMethod.PUT, requestEntity, User.class).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long userId) {
    	template.delete(URI.create(config.URL_USER_SERVICE + "/"+userId));
        return ResponseEntity.ok().build();
    }
}
