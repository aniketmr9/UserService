package com.ecommerce.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user.service.entity.Role;
import com.ecommerce.user.service.entity.User;
import com.ecommerce.user.service.repository.RoleRepository;
import com.ecommerce.user.service.repository.UserRepository;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping(value = "create")
	public User createUser(@RequestBody User user) {
		User u = userRepository.save(user);
		return u;
	}
	
	@GetMapping(value = "get/all")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping(value = "getRole")
	public Role getUserRole(String role) {
		System.out.println(role);
		return roleRepository.findByRole(role);
	}
	
	@PostMapping(value = "get/username")
	public User getUserByUserName(@RequestParam String userName) {
		return userRepository.findByUserName(userName);
	}
	
}
