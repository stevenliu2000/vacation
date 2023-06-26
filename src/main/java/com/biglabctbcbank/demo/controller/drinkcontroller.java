package com.biglabctbcbank.demo.controller;

import java.util.List;

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

import com.biglabctbcbank.demo.entity.Drink;
import com.biglabctbcbank.demo.service.customerservice;
import com.biglabctbcbank.demo.service.drinkservice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/drink")
public class drinkcontroller {

	@Autowired
	private drinkservice drink;
	
	@Autowired
	private customerservice customer;
	
	@GetMapping("/all")
	public List<Drink> getalldrink(){
		log.info("所有飲料名單");
		return drink.getalldrink();
	}
	//bad
	@GetMapping("/{drinkid}")
	public ResponseEntity<?> getcustomerbyid(@PathVariable Long drinkid){
		Drink bean = drink.getdrinkbtid(drinkid);
		return new ResponseEntity<>(bean,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{drinkid}")
	public ResponseEntity<?> deletecustomerbyid(@PathVariable Long drinkid){
		drink.deletedrinl(drinkid);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	//need customer id binding
	@PostMapping("")
	public ResponseEntity<?> createorupdata(@RequestBody Drink bean){
		Drink updatacustomer = drink.savealldrink(bean);
		return new ResponseEntity<>(updatacustomer,HttpStatus.OK);
	}
}
