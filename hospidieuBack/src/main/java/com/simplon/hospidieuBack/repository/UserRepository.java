package com.simplon.hospidieuBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.hospidieuBack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	

	
}