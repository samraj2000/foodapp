package com.ty.springBoot_FoodApp.exception;

public class UserIdNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public UserIdNotFoundException(String message) {
		this.message = message;
	}
	
	
	
	
}
