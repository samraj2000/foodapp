package com.ty.springBoot_FoodApp.exception;

public class ProductNameNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public ProductNameNotFoundException(String message) {
		this.message = message;
	}
	
	
}
