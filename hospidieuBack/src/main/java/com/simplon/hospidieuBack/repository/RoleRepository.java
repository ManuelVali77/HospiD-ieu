package com.simplon.hospidieuBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.hospidieuBack.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String role_name);
}
