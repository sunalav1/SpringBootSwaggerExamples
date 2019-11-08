package com.ibm.userrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.userrestapi.entity.User;
import com.ibm.userrestapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@PostMapping("/api/createuser")
	public void createNewUser(@Valid @RequestBody User user) {
		userService.addUser(user);
	}

	@PutMapping("/api/changeuser")
	public void changeExistingUser(@Valid @RequestBody User user) {
		userService.modifyUser(user);
	}

	@DeleteMapping("/api/removeuser/{id}")
	public void removeUser(@PathVariable(value = "id") long userId) {
		userService.removeUser(userId);
	}

	@GetMapping("/api/viewsingleuser/{id}")
	public User viewUserById(@PathVariable(value = "id") long userId) {
		return userService.getUserById(userId);
	}

	@GetMapping("/api/viewalluser")
	public List<User> viewAllUser() {
		return userService.getAllUser();
	}

}
