package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.UserData;
import com.user.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public UserData save(UserData user) {
		return repo.save(user);
	}
	
	public UserData get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		 repo.deleteById(id);
	}
	
	public UserData update(int id, UserData data) {
		
		UserData old = repo.findById(id).get();
		
		old.setUsername(data.getUsername());
		old.setEmail(data.getEmail());
		old.setMobile(data.getMobile());
		
		return repo.save(old);
	}
}
