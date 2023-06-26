package com.biglabctbcbank.demo.runnable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biglabctbcbank.demo.entity.Customer;
import com.biglabctbcbank.demo.entity.Drink;

import com.biglabctbcbank.demo.repository.customerrespository;
import com.biglabctbcbank.demo.repository.drinkrepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class datarunner implements CommandLineRunner{
	
	@Autowired
	private customerrespository repository;
	
	@Autowired
	private drinkrepository repository2;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		initData();
		for (Customer c : repository.findAll()) {
			log.info("all customer:{}",c);
		}
		for (Drink d : repository2.findAll()) {
			log.info("drink detail:{}",d);
		}
	}
	private void initData() {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		Drink d = new Drink();
		Drink d2 = new Drink();
		
		c.setId((long) 2);
		c.setCustomerName("steven liu2");
		c.setEmail("iamironman20220613@gmail.com");
		c.setPassword("styu00123");
		repository.save(c);
		
//		d.setDrinkName("焦糖瑪奇朵");
//		d.setDrinkdetail("1212");
//		d.setCustomer(c);
//		repository2.save(d);
//		
//		d2.setDrinkName("112");
//		d2.setDrinkdetail("1212");
//		d2.setCustomer(c);
//		repository2.save(d2);
	}

}