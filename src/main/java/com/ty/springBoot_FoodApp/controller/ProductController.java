package com.ty.springBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService  service;
	
	@PostMapping
	public ResponseStructure<Product> saveProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	@PutMapping
	public ResponseStructure<Product> updateProduct(@RequestParam int id,@RequestBody Product product)
	{
		return service.updateProduct(id, product);
	}
	@DeleteMapping
	public ResponseStructure<Product> deleteProduct(@RequestParam int id)
	{
		return service.deleteProduct(id);
	}
//	@GetMapping("getProductById")
	@GetMapping("/{id}")
	public ResponseStructure<Product> getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
}
