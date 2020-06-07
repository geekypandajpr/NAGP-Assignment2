/*
 * @FileName       : UserController.java
 * @Version        : 1.0
 * @DateOfCreation : 06/06/2020
 * @Author         : $u^^!t @ NAGP
 * @Dependencies   : N/A
 * @Description    : CopyRight Component.
 *
 * Copyright (c) 2020, NAGP. All rights reserved.
 */

package com.nagp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nagp.user.model.User;
import com.nagp.user.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired UserService userService;

    @GetMapping("")
    public List<User> listUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("")
    public User createUser(@Valid @RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") Long userId) {
        return this.userService.getUser(userId);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails) {
    	return this.userService.updateUser(userId, userDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
