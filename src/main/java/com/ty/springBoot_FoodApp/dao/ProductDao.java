package com.ty.springBoot_FoodApp.dao;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;
	
	public Product saveProduct(Product product)
	{
		Product product2=repo.save(product);
		return product2;
	}
	
	public Product updateProduct(int id,Product product)
	{
		Optional<Product> opt=repo.findById(id);
		if(opt.isPresent())
		{
			product.setpId(id);
			repo.save(product);
			return opt.get();
		}
		else
		{
			return null;
		}
	}
	
	public Product deleteProduct(int id)
	{
		Optional<Product> opt=repo.findById(id);
		if(opt.isPresent())
		{
			repo.deleteById(id);
			return opt.get();
		}
		else
		{
			return null;
		}
	}

	public Product getProductById(int id) {
		Optional<Product> opt=repo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			return null;
		}
	}
	
}
