package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springBoot_FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email=?1")
	public User getUserByEmail(String email);
	
}
