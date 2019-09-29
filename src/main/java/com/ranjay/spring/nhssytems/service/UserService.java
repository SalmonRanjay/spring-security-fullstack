package com.ranjay.spring.nhssytems.service;

import java.util.ArrayList;
import java.util.List;

import com.ranjay.spring.nhssytems.models.Role;
import com.ranjay.spring.nhssytems.models.User;
import com.ranjay.spring.nhssytems.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        userRepository.save(user);
    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        userRepository.save(user);
    }

    public User findOne(String email){
        return userRepository.findById(email).orElse(null);
    }

	public boolean isUserPresent(String email) {
        User u = userRepository.findById(email).orElse(null);
        if(u != null)
            return true;
		return false;
	}
}