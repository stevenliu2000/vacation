package com.biglabctbcbank.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biglabctbcbank.demo.entity.Customer;
import com.biglabctbcbank.demo.service.customerservice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class customercontroller {
	
	@Autowired
	private customerservice customer;
	
	@GetMapping("/all")
	public List<Customer> getallCustomer(){
		log.info("所有顧客名單"+customer.getallCustomer());
		return customer.getallCustomer();
	}
	
	@GetMapping("{customerid}")
	public ResponseEntity<?> getcustomerbyid(@PathVariable Long customerid){
		Customer bean = customer.getcustomerbyId(customerid);
		return new ResponseEntity<>(bean,HttpStatus.OK);
	}

	@DeleteMapping(value = "{customerid}")
	public ResponseEntity<?> deletecustomerbyid(@PathVariable Long customerid){
		customer.deletecustomer(customerid);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@PostMapping("")
	public ResponseEntity<?> createorupdata(@RequestBody Customer bean){
		Customer updatacustomer = customer.saveallcustomer(bean);
		return new ResponseEntity<>(updatacustomer,HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid Customer bean){
		Customer FindCustomerByEmailAndPassword = customer.GetUserInfoByEmail(bean.getEmail(), bean.getPassword());
//		String Email = customerservice.getEmail();
//		String Password = customerservice.getPassword();
//		customer.GetUserInfoByEmail(bean.getEmail(), bean.getPassword());
		
		if (FindCustomerByEmailAndPassword != null) {
			customer.GetUserInfoByEmail(bean.getEmail(), bean.getPassword());
			log.info("取得用戶資料"+ customer.GetUserInfoByEmail(bean.getEmail(), bean.getPassword()));
//			return new ResponseEntity<>(HttpStatus.OK);
			return ResponseEntity.ok(FindCustomerByEmailAndPassword);
//			FindCustomerByEmailAndPassword
		}
		else {
			log.info("登入失敗");
//			return new ResponseEntity<>(HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
}
