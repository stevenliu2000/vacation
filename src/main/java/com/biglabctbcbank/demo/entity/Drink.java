package com.biglabctbcbank.demo.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Entity
@Table
@Accessors(chain = true)
public class Drink {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DRINKNAME")
	private String drinkName;
	
	private String drinkdetail;
	
	//飲料對應的是多對一，一個用戶可以管理多杯飲料
	@ManyToOne
	@JoinColumn(name = "Customer_id",nullable = false)
	private Customer customer;
	
}
