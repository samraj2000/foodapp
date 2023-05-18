package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ItemsDao;
import com.ty.springBoot_FoodApp.dto.Items;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;
	
	public ResponseStructure<Items> saveItems(Items items)
	{
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved successfully");
		responseStructure.setData(dao.saveItem(items));
		return responseStructure;
	}

	public ResponseStructure<Items> updateItems(int id, Items items) {
		
		Items items2=dao.updateItems(id,items);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if(items2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(items2);
			return responseStructure;
		}
		else
		{
			return null;
		}
	}

	public ResponseStructure<Items> deleteItems(int id) {
		Items items=dao.deleteItems(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if(items!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			responseStructure.setData(items);
			return responseStructure;
		}
		else
		{
			return null;
		}
	}
	public ResponseStructure<Items> getItemsById(int id)
	{
		Items items=dao.getItemsById(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if(items!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("retrived successfully");
			responseStructure.setData(items);
			return responseStructure;
		}
		else
		{
			return null;
		}
	}
}
