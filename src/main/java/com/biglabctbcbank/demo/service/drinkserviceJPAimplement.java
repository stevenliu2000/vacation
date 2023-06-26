package com.biglabctbcbank.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biglabctbcbank.demo.entity.Drink;
import com.biglabctbcbank.demo.repository.drinkrepository;


@Component
public class drinkserviceJPAimplement implements drinkservice{

	@Autowired
	private drinkrepository repository;
	
	@Override
	public List<Drink> getalldrink() {
		return (List<Drink>) repository.findAll();
	}

	@Override
	public Drink getdrinkbtid(long id) {
		Optional<Drink> optionfindbyid =repository.findById(id); 
		return optionfindbyid.get();
	}

	@Override
	public Drink savealldrink(Drink bean) {
		Drink savealldata = repository.save(bean);
		return savealldata;
	}

	@Override
	public void deletedrinl(long id) {
		repository.deleteById(id);
		
	}

//	//透過名子找尋
//	@Override
//	public Drink FindByName(String drinkName) {
//		Drink drink = repository.findByName(drinkName);
//		if (drink != null && drink.getDrinkName().equals(drinkName)) {
//			return drink;
//		}else {
//			return null;	
//		}
//	}
}
