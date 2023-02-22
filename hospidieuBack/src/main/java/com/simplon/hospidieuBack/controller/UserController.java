package com.simplon.hospidieuBack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;
import com.simplon.hospidieuBack.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

	private UserService userService;
	
//	@GetMapping("add-user")
//	public User getUser(UserDto user) {
//		return this.userService.saveUser(user);
//	}
}
