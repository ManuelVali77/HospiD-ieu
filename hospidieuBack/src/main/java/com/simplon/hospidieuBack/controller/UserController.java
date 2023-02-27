package com.simplon.hospidieuBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;
import com.simplon.hospidieuBack.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("user")
//	public List<User> getAllUser() {
//		return this.userService.getAllUser();
//	}

	@GetMapping("user")
	public List<UserDto> findAllUserDto() {
		return this.userService.findAllUserDto();
	}
	

}
