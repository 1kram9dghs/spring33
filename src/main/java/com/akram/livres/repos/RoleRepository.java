package com.akram.livres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akram.livres.entities.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}