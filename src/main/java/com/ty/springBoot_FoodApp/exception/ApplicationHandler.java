package com.ty.springBoot_FoodApp.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springBoot_FoodApp.config.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {
	
	private Object object;
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userIdNotFound(UserIdNotFoundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The record you are searching for is no more exists. please enter valid id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserEmailNotFooundException.class)
	public ResponseEntity<ResponseStructure<String>> userEmailNotFound(UserEmailNotFooundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The record you are searching for is no more exists. please enter valid email");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserPasswordMismatchException.class)
	public ResponseEntity<ResponseStructure<String>> userPasswordMismatch(UserPasswordMismatchException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("Password you have entered wrong. please provide correct password");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_ACCEPTABLE);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list=ex.getAllErrors();
		HashMap<String, String> hashMap=new HashMap<>();
		for(ObjectError error:list)
		{
			String message=error.getDefaultMessage();
//			FieldError fieldError=(FieldError)error;
//			String findname=fieldError.getField();
			String findname=((FieldError)error).getField();
			hashMap.put(message,findname);
		}
		return new ResponseEntity<Object>(hashMap,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productIdNotFound(ProductIdNotFoundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The record you are searching for is no more exists. please enter valid id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ProductNameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productNameNotFound(ProductNameNotFoundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The product you are searching for is nore exists.. please enter valid product name");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MenuIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> menuIdNotFound(MenuIdNotFoundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The record you are searching for is no more exists. please enter valid id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodOrderIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderIdNotFound(FoodOrderIdNotFoundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The record you are searching for is no more exists. please enter valid id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodOrderNameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderNameNotFound(FoodOrderNameNotFoundException e)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData("The food order you are searching for is not present. please enter valid name of your food order");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
