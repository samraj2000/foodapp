package com.ty.springBoot_FoodApp.exception;

public class FoodOrderIdNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public FoodOrderIdNotFoundException(String message) {
		this.message = message;
	}
	
	
}
