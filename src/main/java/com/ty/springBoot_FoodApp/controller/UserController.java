package com.ty.springBoot_FoodApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@ApiOperation(value="save user",notes = "API is used to save user for given user id")
	@ApiResponses(value= {@ApiResponse(code = 200,message="successfully saved"),
							@ApiResponse(code = 404, message = "id not found for the given user id")})
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	
	@ApiOperation(value = "update user", notes = "API is used to update the user for given user id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updtaed"),
							@ApiResponse(code = 404,message = "id not found for the given user id" )})
	@PutMapping("/updateUser")
	public ResponseEntity<ResponseStructure<User>>  updateUser(@Valid @RequestParam int id,@RequestBody User user)
	{
		return service.updateUser(id, user);
	}
	
	@ApiOperation(value = "delete user",notes = "API is used to delete the user for given user id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),
							@ApiResponse(code = 404,message = "id not found for the given user id")})
	@DeleteMapping("/deleteUser")
	public ResponseEntity<ResponseStructure<User>>  deleteUser(@Valid @RequestParam int id)
	{
		return service.deleteUser(id);
	}
	@ApiOperation(value = "get user y id",notes="API is used to get the user for the given user id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "User successfully found"),
							@ApiResponse(code = 404,message = "id not found for the given user id")})
	@GetMapping("/getUserById")
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid @RequestParam int id)
	{
		return service.getUserById(id);
	}
	@GetMapping("/getUserByEmail")
	public ResponseEntity<ResponseStructure<User>> getUserByEmail(@Valid @RequestParam String email)
	{
		return service.getUserByEmail(email);
	}
	@GetMapping("/getUserByEmailAndPassword")
	public ResponseEntity<ResponseStructure<User>> getUserByEmailAndPassword(@Valid @RequestParam String email,@RequestParam String password)
	{
		return service.getUserByEmailAndPassword(email,password);
	}
	@GetMapping("getAllUser")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser()
	{
		return service.getAllUser();
	}
}
