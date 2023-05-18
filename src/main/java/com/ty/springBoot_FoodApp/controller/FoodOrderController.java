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
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;
	
	@ApiOperation(value = "save food order",notes = "API is used to save food order")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully saved")})
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder order) {
		return service.saveFoodOrder(order);
	}

	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int id, @RequestBody FoodOrder order) {
		return service.updateFoodOrder(id, order);
	}

	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}

	@GetMapping("/getFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int id) {
		return service.getFoodOrderById(id);
	}
	@GetMapping("/getAllFoodOrder")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> getAllFoodOrder()
	{
		return service.getAllFoodOrder();
	}
}
