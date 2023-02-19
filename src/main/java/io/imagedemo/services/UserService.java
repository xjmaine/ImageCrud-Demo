package io.imagedemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imagedemo.models.User;
import io.imagedemo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User save(User user) {
		return repo.save(user);
	}
	
	

}
