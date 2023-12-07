package com.validation.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.entity.User;
import com.validation.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public String saveUser(User user) {
		log.info("Inside saveUser method of UserService");
		User save = userRepo.save(user);
		return "saved details successfully";
	}
	
	public List<User> findAllUsers(){
		log.info("Inside findAllUsers method of UserService");
		List<User> all = userRepo.findAll();
		return all;
	}

	public User getUserById(Long id) {
		log.info("Inside getUserById method of UserService");
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else return null;
	}
	
	public String updateUserById(Long id) {
		log.info("Inside updateUserById method of UserService");
		Optional<User> user1 = userRepo.findById(id);
		if (user1.isPresent()) {
			User user = new User();
			User origin = user1.get();
			if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
				
				origin.setName(user.getName());
				
			}
			
			}
		return "Updated details successfully";
	}
	
	
	public String deleteUserById(Long id) {
		log.info("Inside deleteUserById method of UserService");
		if (userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
			return "Deleted successfully";
		}
			
	return "No such User exists";
	}
}
