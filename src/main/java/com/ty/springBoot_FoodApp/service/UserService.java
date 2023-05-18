	package com.ty.springBoot_FoodApp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.UserDao;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.exception.UserEmailNotFooundException;
import com.ty.springBoot_FoodApp.exception.UserIdNotFoundException;
import com.ty.springBoot_FoodApp.exception.UserPasswordMismatchException;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("user successfully saved");
		responseStructure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(int id,User user)
	{
		User user2=dao.updateUser(id, user);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		
		if(user2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new UserIdNotFoundException("User id not found exception");	
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id)
	{
		User user=dao.deleteUser(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(user!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully deleted");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new UserIdNotFoundException("User id not found exception");
		}
	}
	
	public ResponseEntity<ResponseStructure<User>>getUserById(int id)
	{
		User user=dao.getUserById(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(user!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("user found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new UserIdNotFoundException("User id not found exception");
			
		}
	}
	public ResponseEntity<ResponseStructure<User>> getUserByEmail(String email)
	{
		User user=dao.getUserByEmail(email);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(user!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("User found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new UserEmailNotFooundException("Email is not found");
		}
	}
	public ResponseEntity<ResponseStructure<User>> getUserByEmailAndPassword(String email,String password) {
		User user=dao.getUserByEmailAndPassword(email,password);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(user!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("User found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new UserPasswordMismatchException("password doesn't match");
		}
	}
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser()
	{
		List<User> list=dao.getAllUser();
		ResponseStructure<List<User>> responseStructure=new ResponseStructure<>();
		if(list!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("The list of users");
			responseStructure.setData(list);
			return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
}
