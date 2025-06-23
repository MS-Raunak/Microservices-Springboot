package com.ms.service;

import java.util.List;

import com.ms.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(String userId);

}
