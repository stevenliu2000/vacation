package com.biglabctbcbank.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.biglabctbcbank.demo.entity.Customer;
import com.biglabctbcbank.demo.repository.customerrespository;


//@ExtendWith(CustomerJPATest.class)
@DataJpaTest
//@SpringBootTest
class CustomerJPATest {

	@Autowired
	 private EntityManager entityManager;
	
	@Autowired
	private customerrespository repository;
	
	@Test
	 public void should_find_no_customer_if_repository_empty() {

	  List<Customer> customer = (List<Customer>) repository.findAll();

	  assertThat(customer).isEmpty();

	 }

	 @Test
	 public void should_store_a_customer() {

	  Customer customer = new Customer();
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");
	  repository.save(customer);

	  assertThat(customer).isNotNull();
	  assertThat(customer).hasFieldOrPropertyWithValue("email", "steven@gmail.com");
	 }

	 @Test
	 public void should_find_all_customer() {
	  Customer customer = new Customer();
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");
	  repository.save(customer);
	  
	  Customer customer2 = new Customer();
	  customer2.setCustomerName("steven2");
	  customer2.setEmail("steven2@gmail.com");
	  customer2.setPassword("123456");
	  repository.save(customer2);
	  
	  List<Customer> customer_list = (List<Customer>) repository.findAll();
	  assertThat(customer_list).hasSize(2);
	 }

	 @Test
	 public void should_find_customer_by_id() {
	  Customer customer = new Customer();
	  customer.setCustomerName("steven");
	  customer.setEmail("steven@gmail.com");
	  customer.setPassword("123456");
	  repository.save(customer);
	  
	  Customer customer2 = new Customer();
	  customer2.setCustomerName("steven2");
	  customer2.setEmail("steven2@gmail.com");
	  customer2.setPassword("123456");
	  repository.save(customer2);
	  
	//  Optional<Customer> find_id = repository.findById(customer.getId());
	//  assertThat(find_id).isEqualTo(customer);
	  
	  //這裡因為optional所以她回的數值會有一個類似arraylist的感覺
	  //所以在find_id的後面新增.orelse(null) 主要是用來判斷optional如果為空值則會回傳null，若不是，則會回傳customer的值
	  
	  Customer find_id = repository.findById(customer.getId()).get();
	  assertThat(find_id).isEqualTo(customer);
	  
	  Customer find_id2 = repository.findById(customer2.getId()).get();
	  assertThat(find_id2).isEqualTo(customer2);
	 }
	 
	 @Test
	 public void customer_update_by_id() {
	    Customer customer = new Customer();
	    customer.setCustomerName("steven");
	    customer.setEmail("steven@gmail.com");
	    customer.setPassword("123456");
	    repository.save(customer);

	    customer.setCustomerName("jason");
	    customer.setEmail("jason@outlook.com");
	    customer.setPassword("789456123");
	    repository.save(customer);

	    Customer updatedCustomerOptional = repository.findById(customer.getId()).get();
	    assertThat(updatedCustomerOptional).isEqualTo(customer);
	  }
	 
	// @Test
	 public void customer_delete_by_id() {

	   Customer customer = new Customer();
	   customer.setCustomerName("steven");
	   customer.setEmail("steven@gmail.com");
	   customer.setPassword("45678913");
	   repository.save(customer);

	   Customer customer2 = new Customer();
	   customer2.setCustomerName("jason");
	   customer2.setEmail("jason@gmail.com");
	   customer2.setPassword("789456123");
	   repository.save(customer2);

	   repository.deleteById(2L);
	   assertThat(repository.existsById((long) 2)).isFalse();
	 }
	 
	 
	 @Test
	 public void customer_delete_all() {
	  Customer customer = new Customer();
	    customer.setCustomerName("steven");
	    customer.setEmail("steven@gmail.com");
	    customer.setPassword("45678913");
	    entityManager.persist(customer);

	    Customer customer2 = new Customer();
	    customer2.setCustomerName("jason");
	    customer2.setEmail("jason@gmail.com");
	    customer2.setPassword("789456123");
	    entityManager.persist(customer2);

	    Customer customer3 = new Customer();
	    customer3.setCustomerName("kim");
	    customer3.setEmail("kim@gmail.com");
	    customer3.setPassword("123456789");
	    entityManager.persist(customer3);
	    
	    repository.deleteAll();
	    assertThat(repository.findAll()).isEmpty();
	 }
	 
	 @Test
	 public void customer_create_null_exception() {
	   Customer customer = new Customer();
	   customer.setCustomerName("steven");
	   customer.setPassword("45678913");
	   assertThrows(ConstraintViolationException.class, () -> {
	     repository.save(customer);
	   });

	   List<Customer> customerList = (List<Customer>) repository.findAll();
	   assertThat(customerList).hasSize(2);
	 }
	}
