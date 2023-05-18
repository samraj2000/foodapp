package com.ty.springBoot_FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.service.MenuService;
@RestController
public class MenuController {

	@Autowired
	private MenuService service;
	
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu)
	{
		return service.saveMenu(menu);
	}
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id,@RequestBody Menu menu)
	{
		return service.updateMenu(id,menu);
	}
	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int id)
	{
		return service.deleteMenu(id);
		
	}
	@GetMapping("/getMenuById")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int id)
	{
		return service.getMenuById(id);
	}
	@GetMapping("/getMenuByName")
	public Menu getMenuByName(String name)
	{
		return service.getMenuByName(name);
	}
	@GetMapping("/getAllMenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenu()
	{
		return service.getAllMenu();
	}
}
