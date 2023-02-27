package com.simplon.hospidieuBack.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplon.hospidieuBack.model.Role;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;
import com.simplon.hospidieuBack.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository dao;

	@Override
	public List<User> getAllUser() {
		return dao.findAll();
	}
	
	@Override
    @GetMapping("user")
    public List<UserDto> findAllUserDto() {
        List<UserDto> usersDto = new ArrayList();
        List<User> users = dao.findAll();
        for(User user : users) {
            UserDto userDto = new UserDto();
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                String roleString = role.getRoleName();
                userDto.setRole(roleString);
            }
            userDto.setName(user.getName());
            userDto.setFirstname(user.getFirstName());
            userDto.setEmail(user.getMail());
            userDto.setPassword(user.getPassword());
            userDto.setIdUser(user.getIdUser());
            usersDto.add(userDto);
        }
        return usersDto;
    }
//	public UserDto displayUserDto(Role userRole) {
//		
//		List<User> user = userRole.getUsers(); 
//		
//		UserDto userDto = new UserDto();
//		
//		userDto.setName(((User) user).getName());
//		userDto.setFirstname(user.getFirstname());
//		userDto.setRole(userRole.getIdRole());
//		userDto.setEmail(user.getEmail());
//		
//		return userDto;
//	}

}
