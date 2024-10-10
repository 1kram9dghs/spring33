package com.akram.livres.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akram.livres.entities.User;
import com.akram.livres.repos.UserRepository;


@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
@Autowired
UserRepository userRep;
@GetMapping("/all")
public List<User> getAllUsers() {
return userRep.findAll();
}
}