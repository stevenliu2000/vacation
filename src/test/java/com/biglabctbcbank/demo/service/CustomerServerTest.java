package com.biglabctbcbank.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.biglabctbcbank.demo.entity.Customer;
import com.biglabctbcbank.demo.repository.customerrespository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CustomerServerTest {

	@Mock
	private customerrespository repository; //mock the repository //test
	
	@InjectMocks
	 private customerservice customerservice = new customerserviceJPAimplement();

	
	@BeforeEach
	void setUp() {
		 MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void Get_All_customer() {
		//when 
		customerservice.getallCustomer();
		//then
		verify(repository).findAll();
	}
	
	@Test //現在是錯的
	@Disabled
	 void Get_Customer_By_id() {
	  //givin
		
	  Customer customer = new Customer();
	  customer.setId(1L);
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");
	  repository.save(customer);
	  
	  //when
	  customerservice.getcustomerbyId(customer.getId());
	  
	  //then
	  assertThat(customer).isNotNull();
	 }
	 @Test
	 @Disabled
	 void Save_the_Customer() {
	  
	 }
	 
	 @Test
	 @Disabled
	 void Delete_The_Customer() {
	  
	 }
	 
	 @Test
	 @Disabled
	 void Get_Info_Customer() {
	  
	 }

	}
