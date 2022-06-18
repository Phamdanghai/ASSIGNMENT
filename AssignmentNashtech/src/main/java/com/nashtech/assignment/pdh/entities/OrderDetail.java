package com.nashtech.assignment.pdh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
public class OrderDetail {
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordId;
	
	@Column
	private String ordName;
	
	@Column
	private String ordPhone;
	
	@Column
	private String ordDate;
	
	@Column
	private float ordPrice;
	
	@Column
	private int ordQuantity;
	
	@Column
	private Long proId;
	
	@Column
	private Long orId;
}
