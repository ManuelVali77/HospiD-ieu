package com.simplon.hospidieuBack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.hospidieuBack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByName(String name);
	  public boolean existsByMail(String mail);
	  public boolean existsByName(String name);
	User findByMail(String mail);
	
}