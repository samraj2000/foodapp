package com.ty.springBoot_FoodApp.exception;

public class ProductIdNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public ProductIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
