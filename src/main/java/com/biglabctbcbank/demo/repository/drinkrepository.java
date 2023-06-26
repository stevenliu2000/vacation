package com.biglabctbcbank.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.biglabctbcbank.demo.entity.Drink;

public interface drinkrepository extends CrudRepository<Drink, Long> {

//	Drink findByName (String drinkName);
//	Drink FindDrinkByName(String Name);
}
