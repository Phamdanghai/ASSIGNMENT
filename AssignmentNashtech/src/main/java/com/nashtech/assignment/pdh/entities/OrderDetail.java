package com.nashtech.assignment.pdh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "proId")
	private Products products;
	
	@ManyToOne
	@JoinColumn(name = "orId")
	private Orders orders;

	public Long getOrdId() {
		return ordId;
	}

	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

	public String getOrdName() {
		return ordName;
	}

	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}

	public String getOrdPhone() {
		return ordPhone;
	}

	public void setOrdPhone(String ordPhone) {
		this.ordPhone = ordPhone;
	}

	public String getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}

	public float getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(float ordPrice) {
		this.ordPrice = ordPrice;
	}

	public int getOrdQuantity() {
		return ordQuantity;
	}

	public void setOrdQuantity(int ordQuantity) {
		this.ordQuantity = ordQuantity;
	}
	
	
}
