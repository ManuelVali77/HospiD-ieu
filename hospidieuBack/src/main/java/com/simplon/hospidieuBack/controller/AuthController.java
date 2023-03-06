package com.simplon.hospidieuBack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.AuthResponse;
import com.simplon.hospidieuBack.model.CustomUserBean;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.repository.RoleRepository;
import com.simplon.hospidieuBack.repository.UserRepository;
import com.simplon.hospidieuBack.security.JwtTokenUtil;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PutMapping("/login")
	public ResponseEntity<Object> userLogin(@Valid @RequestBody User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getMail(), user.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenUtil.generateJwtToken(authentication);
		CustomUserBean userBean = (CustomUserBean) authentication.getPrincipal();
		List<String> roles = userBean.getAuthorities().stream().map(auth -> auth.getAuthority())
				.collect(Collectors.toList());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(token);
		authResponse.setRoles(roles);
		return ResponseEntity.ok(authResponse);
	}
}
