package com.simplon.hospidieuBack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplon.hospidieuBack.controller.UserController;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;
import com.simplon.hospidieuBack.repository.Dao;

@SpringBootApplication
public class HospidieuBackApplication  implements CommandLineRunner {
	
	@Autowired
	UserController controller;

	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		for (UserDto user : this.controller.findAllUserDto()) {
//			System.out.println(UserDto.getRole());
//		}
	}

}
