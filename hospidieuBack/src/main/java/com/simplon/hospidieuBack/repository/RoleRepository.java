package com.simplon.hospidieuBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.hospidieuBack.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);
}
