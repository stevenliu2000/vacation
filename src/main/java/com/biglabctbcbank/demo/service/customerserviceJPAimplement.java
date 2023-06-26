package com.biglabctbcbank.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biglabctbcbank.demo.entity.Customer;
import com.biglabctbcbank.demo.repository.customerrespository;


@Component
public class customerserviceJPAimplement implements customerservice {

	@Autowired
	private customerrespository repository;
	
	@Override
	public List<Customer> getallCustomer() {
		return (List<Customer>) repository.findAll();
	}

	@Override
	public Customer getcustomerbyId(long id) {
		Optional<Customer> optionalfindbyid = repository.findById(id);
		return optionalfindbyid.get();
	}

	@Override
	public Customer saveallcustomer(Customer bean) {
		Customer savealldata =repository.save(bean);
		return savealldata;
	}

	@Override
	public void deletecustomer(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Customer GetUserInfoByEmail(String email, String password) {
		Customer customer = repository.findByEmailAndPassword(email, password);
		if (customer != null && customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
			return customer;
		}
		else {
			return null;
		}
	}


}
