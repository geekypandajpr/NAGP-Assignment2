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

package com.nagp.user.service;

import java.util.List;

import com.nagp.user.model.User;

public interface UserService {
	
	public abstract User createUser(User user);
	public abstract User updateUser(Long id, User user);
	public abstract void deleteUser(Long id);
	public abstract User getUser(Long id);
	public abstract List<User> getUsers();
}
