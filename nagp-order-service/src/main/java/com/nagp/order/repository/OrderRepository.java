/*
 * @FileName       : UserRepository.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */


package com.nagp.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagp.order.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByUserId(Long userId);
}
