package com.ms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.User;
import com.ms.exception.ResourceNotFoundException;
import com.ms.repo.UserRepo;


@Service
public class UserserviceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(String userId) {
		return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this id on server: " + userId));
	}

}
