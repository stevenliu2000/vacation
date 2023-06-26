package com.biglabctbcbank.demo.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer" , uniqueConstraints = {
		@UniqueConstraint( columnNames = "email"),
		@UniqueConstraint( columnNames = "CUSTOMERNAME")})
@Accessors(chain = true)
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Length(max = 50 ,min = 6,message = "要大於6小於50")
	private String password;
	//這邊對應的是飲料，一個客人可以管理多杯飲料
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.REMOVE)
	//json這邊的用法是為了避免無線輪迴
	@JsonIgnore
	//是為了將資料顯示出來
	@ToString.Exclude
	private List<Drink> drinks;
}