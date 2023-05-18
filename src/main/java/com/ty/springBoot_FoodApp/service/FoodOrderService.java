package com.ty.springBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.FoodOrderDao;
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.exception.FoodOrderIdNotFoundException;

@Service
public class FoodOrderService {

	@Autowired
	public FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder order) {
		List<Items> list = order.getItems();
		double totalPrice = 0;
		for (Items items : list) {
			totalPrice += items.getCost() * items.getQuantity();
		}
		order.setTotalPrice(totalPrice);
		FoodOrder order2 = dao.saveFoodOrder(order);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if (order2 != null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("saved successfully");
			responseStructure.setData(order2);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
		} else {
			throw new FoodOrderIdNotFoundException("Order id not found exception");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int id, FoodOrder order) {
		FoodOrder order2 = dao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if (order2 != null) {
			double totalPrice = 0;
			List<Items> list = order.getItems();
			for (Items items : list) {
				totalPrice += items.getCost() * items.getQuantity();
			}
			order.setTotalPrice(totalPrice);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(dao.updateFoodOrder(id, order));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFoundException("Order id not found exception");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder foodOrder=dao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if(foodOrder != null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new FoodOrderIdNotFoundException("Order id not found exception");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		FoodOrder foodOrder = dao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if(foodOrder!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("retrieved successfully");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new FoodOrderIdNotFoundException("Order id not found exception");
		}
	}
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> getAllFoodOrder()
	{
		List<FoodOrder> list=dao.getAllFoodOrder();
		ResponseStructure<List<FoodOrder>> responseStructure=new ResponseStructure<>();
		if(list!=null)
		{
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("The list of Food order");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}
}
