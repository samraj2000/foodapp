package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ProductDao;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.exception.ProductIdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public ResponseStructure<Product> saveProduct(Product product)
	{
		ResponseStructure<Product> responseStructure=new  ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("product created successfully");
		responseStructure.setData(dao.saveProduct(product));
		return responseStructure;
	}
	
	public ResponseStructure<Product> updateProduct(int id,Product product)
	{
		Product product2=dao.updateProduct(id, product);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		
		if(product2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(product2);
			return responseStructure;
		}
		else
		{
			throw new ProductIdNotFoundException("product not found");
		}	
	}
	public ResponseStructure<Product> deleteProduct(int id)
	{
		Product product=dao.deleteProduct(id);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if(product!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted successfully");
			responseStructure.setData(product);
			return responseStructure;
		}
		else
		{
			throw new ProductIdNotFoundException("product not found");
		}
	}

	public ResponseStructure<Product> getProductById(int id) {
		Product product=dao.getProductById(id);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if(product!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found successfult");
			responseStructure.setData(product);
			return responseStructure;
		}
		else
		{
			throw new ProductIdNotFoundException("product not found");
		}
	}
	
}
