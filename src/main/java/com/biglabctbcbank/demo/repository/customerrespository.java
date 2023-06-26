package com.biglabctbcbank.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.biglabctbcbank.demo.entity.Customer;

public interface customerrespository extends CrudRepository<Customer, Long>{

	Customer findByEmailAndPassword(String email , String password);
	
}
