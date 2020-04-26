package com.pfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.model.UserDTO;
import com.pfe.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public ResponseEntity<?> getUser() throws Exception {
		return ResponseEntity.ok(userDetailsService.getAll());
	}
	
	@RequestMapping(value = "/User", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam Integer id) throws Exception {
		return ResponseEntity.ok(userDetailsService.getUserById(id));
	}
	
	@RequestMapping(value = "/User", method = RequestMethod.GET)
	public ResponseEntity<?> getUserByEmail(@RequestParam String email) throws Exception {
		return ResponseEntity.ok(userDetailsService.getUserByEmail(email));
	}
	
	@RequestMapping(value = "/User", method = RequestMethod.GET)
	public ResponseEntity<?> getUserByUsername(@RequestParam String email) throws Exception {
		return ResponseEntity.ok(userDetailsService.getUserByUserName(email));
	}
	
	@RequestMapping(value = "/UserDelete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam Integer id) throws Exception {
		return ResponseEntity.ok(userDetailsService.delteUser(id));
	}
	
	@RequestMapping(value = "/UpdateUser", method = RequestMethod.PUT)
	public ResponseEntity<?> UpdateUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.updateUser(user));
	}
	
	
	

}