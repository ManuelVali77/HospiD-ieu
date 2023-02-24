package com.simplon.hospidieuBack.service;

import java.util.List;

import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;

public interface UserService {

	    List < User > getAllUser();

		List<UserDto> findAllUserDto();

	}