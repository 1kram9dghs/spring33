package com.akram.livres.service;

import com.akram.livres.entities.Role;
import com.akram.livres.entities.User;

public interface UserService {
 User saveUser(User user);
 User findUserByUsername (String username);
 Role addRole(Role role);
 User addRoleToUser(String username, String rolename);
}