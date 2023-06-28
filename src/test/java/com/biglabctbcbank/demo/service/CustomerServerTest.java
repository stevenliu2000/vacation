package com.biglabctbcbank.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.biglabctbcbank.demo.entity.Customer;
import com.biglabctbcbank.demo.repository.customerrespository;

import lombok.extern.slf4j.Slf4j;

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
	
	@Test // 現在是錯的
	 public void Get_Customer_By_id() {
	  // givin
	  Customer customer = new Customer();
	  customer.setId(1L);
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");
	  Mockito.when(repository.findById(customer.getId())).thenReturn(Optional.of(customer));

	  // when
	  Customer foundCustomer = customerservice.getcustomerbyId(customer.getId());

	  // then
	  assertThat(foundCustomer).isNotNull();
	  assertThat(foundCustomer.getId()).isEqualTo(customer.getId());
	  assertThat(foundCustomer.getCustomerName()).isEqualTo(customer.getCustomerName());
	  assertThat(foundCustomer.getEmail()).isEqualTo(customer.getEmail());
	  assertThat(foundCustomer.getPassword()).isEqualTo(customer.getPassword());
	 }

	 @Test
	 public void Save_the_Customer() {
	  // giving
	  Customer customer = new Customer();
	  customer.setId(1L);
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");
	  Mockito.when(repository.save(customer)).thenReturn(customer);

	  // when
	  Customer savedCustomer = customerservice.saveallcustomer(customer);

	  // then
	  assertThat(savedCustomer).isNotNull();
	  assertThat(savedCustomer.getId()).isEqualTo(customer.getId());
	  assertThat(savedCustomer.getCustomerName()).isEqualTo(customer.getCustomerName());
	  assertThat(savedCustomer.getEmail()).isEqualTo(customer.getEmail());
	  assertThat(savedCustomer.getPassword()).isEqualTo(customer.getPassword());
	  verify(repository).save(customer);

	 }

	 @Test
	 public void Delete_The_Customer() {
	  // giving
	  Customer customer = new Customer();
	  customer.setId(1L);
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");

	  Customer customer2 = new Customer();
	  customer2.setId(2L);
	  customer2.setCustomerName("jason");
	  customer2.setEmail("jason@gmail.com");
	  customer2.setPassword("123456");

	  // when
	  customerservice.deletecustomer(customer.getId());

	  // then
	  verify(repository).deleteById(customer.getId());
	//  verify(repository).findById(customer.getId());

	 }

	 @Test
	 public void Get_Info_Customer() {
	  // giving
	  Customer customer = new Customer();
	    customer.setId(1L);
	    customer.setCustomerName("steven");
	    customer.setEmail("steven@gmail.com");
	    customer.setPassword("123456");
	    Mockito.when(repository.findByEmailAndPassword("steven@gmail.com", "123456")).thenReturn(customer);
	  
	  // when
	  Customer findbyemail = customerservice.GetUserInfoByEmail("steven@gmail.com", "123456");
	  
	  //then
	  assertThat(findbyemail).isEqualTo(customer);
	  verify(repository).findByEmailAndPassword("steven@gmail.com", "123456");
	 }
	}
