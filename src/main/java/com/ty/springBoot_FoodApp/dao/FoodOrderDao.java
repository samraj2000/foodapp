package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo repo;

	public FoodOrder saveFoodOrder(FoodOrder order) {
		return repo.save(order);
	}

	public FoodOrder updateFoodOrder(int id, FoodOrder order) {
		Optional<FoodOrder> order2 = repo.findById(id);
		if (order2.isPresent()) {
			order.setfId(id);
			order.setItems(order.getItems());
			repo.save(order);
			return order2.get();
		} else {
			return null;
		}
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = repo.findById(id);
		if (foodOrder.isPresent()) {
			return foodOrder.get();
		} else {
			return null;
		}
	}

	public FoodOrder deleteFoodOrder(int id) {
		Optional<FoodOrder> opt = repo.findById(id);
		if (opt.isPresent()) {
			repo.deleteById(id);
			return opt.get();
		} else {
			return null;
		}
	}
	public List<FoodOrder> getAllFoodOrder()
	{
		return repo.findAll();
	}

}
