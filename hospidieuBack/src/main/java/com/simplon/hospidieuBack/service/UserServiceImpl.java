package com.simplon.hospidieuBack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setName(userDto.getName());
        user.setMail(userDto.getMail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByRoleName("ROLE_" + userDto.getRole());
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setIdUser(user.getIdUser());
        userDto.setFirstName(user.getFirstName());
        userDto.setName(user.getName());
        userDto.setMail(user.getMail());
        return userDto;
    }

}
