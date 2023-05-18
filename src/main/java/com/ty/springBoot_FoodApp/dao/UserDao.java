package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		User user2 = repo.save(user);
		return user2;
	}

	public User updateUser(int id, User user) {
		Optional<User> opt = repo.findById(id);
		User user2 = opt.get();
		if (user2 != null) {
			user.setId(id);
			repo.save(user);
			return user2;
		} else {
			return null;
		}
	}

	public User deleteUser(int id) {
		Optional<User> opt = repo.findById(id);
		if (opt.isPresent()) {
			repo.deleteById(id);
			return opt.get();
		} else {
			return null;
		}
	}

	public User getUserById(int id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public User getUserByEmail(String email) {
		User user = repo.getUserByEmail(email);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
	
	public User getUserByEmailAndPassword(String email,String password)
	{
		User user=repo.getUserByEmail(email);
		if(user!=null && password.equals(user.getPassword()))
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	public List<User> getAllUser()
	{
		List<User> list=repo.findAll();
		return list;
	}
}
