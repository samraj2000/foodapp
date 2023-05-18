package com.ty.springBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.service.ItemsService;

@RestController
public class ItemsController {

	@Autowired
	private ItemsService service;
	
	@PostMapping("/saveItems")
	public ResponseStructure<Items> saveItems(@RequestBody Items items)
	{
		return service.saveItems(items);
	}
	@PutMapping("/updateItems")
	public ResponseStructure<Items> updateItems(@RequestParam int id,@RequestBody Items items)
	{
		return service.updateItems(id,items);
	}
	@DeleteMapping("/deleteItems")
	public ResponseStructure<Items> deleteItems(@RequestParam int id)
	{
		return service.deleteItems(id);
	}
	@GetMapping("/getItemsById")
	public ResponseStructure<Items> getItemsById(@RequestParam int id)
	{
		return service.getItemsById(id);
	}
}
