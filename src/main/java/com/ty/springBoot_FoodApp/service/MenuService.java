package com.ty.springBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.MenuDao;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.exception.MenuIdNotFoundException;
@Service
public class MenuService {

	@Autowired
	private MenuDao dao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu)
	{
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("data saved");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
		Menu menu2=dao.updateMenu(id, menu);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if(menu2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(menu2);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new MenuIdNotFoundException("Menu id not found exception");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		Menu menu=dao.deleteMenu(id);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if(menu!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new MenuIdNotFoundException("Menu id not found exception");
		}
	}
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id)
	{
		Menu menu=dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if(menu!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("retrived the data successfully");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new MenuIdNotFoundException("Menu id not found exception");
		}
	}
	public Menu getMenuByName(String name)
	{
		Menu menu=dao.getMenuByName(name);
		if(menu!=null)
		{
			return menu;
		}
		else
		{
			throw new MenuIdNotFoundException("Menu id not found exception");
		}
	}
	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenu()
	{
		List<Menu> list=dao.getAllMenu();
		ResponseStructure<List<Menu>> responseStructure=new ResponseStructure<>();
		if(list!=null)
		{
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("The list of menu");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
}
