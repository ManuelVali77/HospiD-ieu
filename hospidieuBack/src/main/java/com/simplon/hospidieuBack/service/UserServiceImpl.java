package com.simplon.hospidieuBack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplon.hospidieuBack.model.Role;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.model.UserDto;
import com.simplon.hospidieuBack.repository.RoleRepository;
import com.simplon.hospidieuBack.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@GetMapping("user")
	public List<UserDto> findAllUserDto() {
		List<UserDto> usersDto = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			UserDto userDto = new UserDto();
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				String roleString = role.getRoleName();
				userDto.setRole(roleString);
			}
			userDto.setName(user.getName());
			userDto.setFirstName(user.getFirstName());
			userDto.setMail(user.getMail());
			userDto.setIdUser(user.getIdUser());
			usersDto.add(userDto);
		}
		return usersDto;
	}

	@Override
	public void saveUser(UserDto userDto) {
		final String infirmier = "ROLE_INFIRMIER";
		final String secretaire = "ROLE_SECRETAIRE";
		final String admin = "ROLE_ADMIN";
		User user = new User();
		List<Role> roles = new ArrayList<>();
		user.setFirstName(userDto.getFirstName());
		user.setName(userDto.getName());
		user.setMail(userDto.getMail());
		// encrypt the password using spring security
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		switch (userDto.getRole()) {
		case (admin):

			roles.add(roleRepository.findByRoleName(infirmier));
			roles.add(roleRepository.findByRoleName(secretaire));
			roles.add(roleRepository.findByRoleName(admin));
			break;
		case (infirmier):
			roles.add(roleRepository.findByRoleName(infirmier));
			break;
		case (secretaire):
			roles.add(roleRepository.findByRoleName(secretaire));
			break;
		default :
			break;
		}
		user.setRoles(roles);
		userRepository.save(user);
	}

}
