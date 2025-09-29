package com.jsp.onlineUtilityBillPayment.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlineUtilityBillPayment.DTO.User;
import com.jsp.onlineUtilityBillPayment.SERVICE.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		return ResponseEntity.ok(userservice.registeruser(user));
		// * here we r returning with ResponseEntity with user object
		 
	}
	
	@GetMapping("/get")
	public ResponseEntity<User> getUser(@RequestParam Long id){
		return userservice.getUserById(id)//returns optional object
				.map(ResponseEntity::ok)//optional.map(...)is used when values is present
				.orElse(ResponseEntity.notFound().build());
		//here optional.orElse(...) is used when values is not present
		//ResponseEntity.notfound.build()-->this sends NotFound response with no body (no object)
		//.build() is returning if optional is empty then returntype for that we r caling this.
	}
	@GetMapping("/all")
	public List<User> getAllUser(){
		return userservice.getAllUsers();
	}
	
}
