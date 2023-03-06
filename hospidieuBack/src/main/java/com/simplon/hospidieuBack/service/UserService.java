package com.simplon.hospidieuBack.service;

import java.util.List;

import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;

public interface UserService {
	void saveUser(UserDto userDto);

	List<User> getAllUser();

	List<UserDto> findAllUserDto();

}