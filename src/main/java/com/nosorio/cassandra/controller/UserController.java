package com.nosorio.cassandra.controller;

import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableSet;

import com.nosorio.cassandra.model.User;
import com.nosorio.cassandra.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(); 

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping({"/", ""})
	public User saveUser(@RequestParam Optional<String> firstName, 
						 @RequestParam Optional<String> lastName, 
						 @RequestParam Optional<Set<String>> tags) {
		logger.info("Creating user...");
		User user = new User(UUIDs.timeBased(), firstName.orElse("John"), lastName.orElse("Due"), tags.orElse(ImmutableSet.of("Software Engineer", "Tech Lead")));
		return userRepository.save(user);
	}
	
	@GetMapping({"/", ""})
	public Iterable<User> getUsers() {
		logger.info("Getting users...");
		return userRepository.findAll();
	}
	
	@DeleteMapping({"/", ""})
	public void clear() {
		logger.info("Clearing database...");
		userRepository.deleteAll();
	}
}
