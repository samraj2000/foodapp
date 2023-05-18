package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springBoot_FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

	@Query("select m from Menu m where m.name=?1")
	public Menu getMenuByName(String name);
}
