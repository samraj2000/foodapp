package com.ty.springBoot_FoodApp.exception;

public class UserPasswordMismatchException extends RuntimeException{

	private String message;
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
	public UserPasswordMismatchException(String message)
	{
		this.message=message;
	}
}
