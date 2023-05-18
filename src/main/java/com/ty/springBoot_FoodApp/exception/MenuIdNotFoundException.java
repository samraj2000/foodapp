package com.ty.springBoot_FoodApp.exception;

public class MenuIdNotFoundException extends RuntimeException {

	private String message;
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
	public MenuIdNotFoundException(String message)
	{
		this.message=message;
	}
}
