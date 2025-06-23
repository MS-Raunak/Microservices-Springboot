package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.User;
import com.ms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//Save user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> fetchUserById(@PathVariable String userId){
		User getUser = userService.getUserById(userId);
		return ResponseEntity.ok(getUser);
	}
	
	
	@GetMapping
	public ResponseEntity<List<User>> fetchAllUser(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	

}
