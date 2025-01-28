package com.novo.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.product.entity.User;
import com.novo.product.repository.UserRepository;
import com.novo.product.service.UsersSevice;
@Service
public class UserServiceImpl implements UsersSevice{
	@Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();  // Fetches all users from the database
    }
}
