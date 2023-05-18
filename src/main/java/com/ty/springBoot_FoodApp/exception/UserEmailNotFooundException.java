package com.ty.springBoot_FoodApp.exception;

public class UserEmailNotFooundException extends RuntimeException{

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public UserEmailNotFooundException(String message) {
		this.message = message;
	}
	
	
	
}
