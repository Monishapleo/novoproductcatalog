package com.novo.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.novo.product.config.CustomUserDetailsService;
import com.novo.product.entity.User;
import com.novo.product.service.UsersSevice;

@RestController
@RequestMapping("/users")
public class UserController {

    private  CustomUserDetailsService customUserDetailsService;
    private  UsersSevice usersService;
    
    
    
public UserController(CustomUserDetailsService customUserDetailsService, UsersSevice usersService) {
		this.customUserDetailsService = customUserDetailsService;
		this.usersService = usersService;
	}


    
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestParam(name="username") String username, 
                                             @RequestParam(name="password") String password, 
                                             @RequestParam(name="role") String role) {
        customUserDetailsService.createUser(username, password, role);
        return ResponseEntity.ok("User created successfully!");
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

