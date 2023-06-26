package com.biglabctbcbank.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.biglabctbcbank.demo.entity.Customer;

@Service
public interface customerservice  {

	//取得所有顧客
	List<Customer> getallCustomer();
	
	//取得顧客資料by id!!
	Customer getcustomerbyId (long id);
	
	//儲存所有顧客資料
	Customer saveallcustomer(Customer bean);
	
	//刪除顧客資料
	void deletecustomer(long id);
	
	//取得用戶by email and password
	Customer GetUserInfoByEmail (@Valid String email , @Valid String password);
}
