package com.ty.springBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.repo.ItemRepo;

@Repository
public class ItemsDao {

	@Autowired
	private ItemRepo repo;
	
	public Items saveItem(Items items)
	{
		return repo.save(items);
	}

	public Items updateItems(int id, Items items) {
		Optional<Items> opt=repo.findById(id);
		if(opt.isPresent())
		{
			items.setItem_id(id);
			repo.save(items);
			Items items2=(Items)opt.get();
			return items2;
		}
		else
		{
			return null;
		}
	}

	public Items deleteItems(int id) {
		Optional<Items>opt=repo.findById(id);
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
	
	public Items getItemsById(int id)
	{
		Optional<Items> opt=repo.findById(id);
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
