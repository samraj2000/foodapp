package com.ty.springBoot_FoodApp.exception;

public class FoodOrderNameNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public FoodOrderNameNotFoundException(String message) {
		this.message = message;
	}
	
	
}
