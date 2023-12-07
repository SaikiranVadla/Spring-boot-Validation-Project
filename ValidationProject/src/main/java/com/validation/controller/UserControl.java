package com.validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.entity.User;
import com.validation.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserControl {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@Valid @RequestBody User user){
		log.info("Inside saveUser method of UserControl");
		String saveUser = userService.saveUser(user);
		return ResponseEntity.ok("saved details successfully");	
		}
	
	@GetMapping("/get")
	public List<User> getAllUsers(){
		log.info("Inside getAllUsers method of UserControl");
		return userService.findAllUsers();
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		log.info("Inside getUserById method of UserControl");
		return userService.getUserById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateUserById(@RequestBody User user) {
		log.info("Inside updateUserById method of UserControl");
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		log.info("Inside deleteUserById method of UserControl");
        return userService.deleteUserById(id);
	}

}
