package com.biglabctbcbank.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biglabctbcbank.demo.entity.Drink;

@Service
public interface drinkservice {

	//取得所有飲料的資料
	List<Drink> getalldrink();
	
	//取得飲料資料by id
	Drink getdrinkbtid(long id);
	
	//儲存所有飲料資料
	Drink savealldrink(Drink bean);
	
	//刪除資料
	void deletedrinl(long id);
	
//	//搜尋飲料
//	Drink FindByName(@Valid String drinkName);
}
