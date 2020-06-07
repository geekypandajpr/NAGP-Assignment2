package com.nagp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.user.exception.ResourceNotFoundException;
import com.nagp.user.model.User;
import com.nagp.user.repository.UserRepository;

@Service
public class UserServiceeImpl implements UserService{

	@Autowired UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		User userObject = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userObject.setAge(user.getAge());
		userObject.setEmail(user.getEmail());
		userObject.setName(user.getName());
        User updatedUser = userRepository.save(userObject);
        return updatedUser;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        this.userRepository.delete(user);
	}
	
	@Override
	public User getUser(Long id) {
		return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

}
