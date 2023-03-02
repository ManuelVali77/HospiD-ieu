package com.simplon.hospidieuBack.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<UserDto> usersDto = new ArrayList();
        List<User> users = userRepository.findAll();
        for(User user : users) {
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
		User user = new User();
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		user.setFirstName(userDto.getFirstName());
		user.setName(userDto.getName());
		user.setMail(userDto.getMail());
		// encrypt the password using spring security
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		switch (userDto.getRole()) {
		case ("ROLE_ADMIN"):

			role = roleRepository.findByRoleName("ROLE_INFIRMIER");
			roles.add(role);
			role = roleRepository.findByRoleName("ROLE_SECRETAIRE");
			roles.add(role);
			role = roleRepository.findByRoleName(userDto.getRole());
			roles.add(role);
			break;
		case ("ROLE_INFIRMIER"):
			role = roleRepository.findByRoleName("ROLE_INFIRMIER");
			roles.add(role);
			break;
		case ("ROLE_SECRETAIRE"):
			role = roleRepository.findByRoleName("ROLE_SECRETAIRE");
			roles.add(role);
			break;
		}
		user.setRoles(roles);
		userRepository.save(user);
	}

}
