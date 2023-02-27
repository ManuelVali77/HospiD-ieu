package com.simplon.hospidieuBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.hospidieuBack.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByMail(String mail);
}
