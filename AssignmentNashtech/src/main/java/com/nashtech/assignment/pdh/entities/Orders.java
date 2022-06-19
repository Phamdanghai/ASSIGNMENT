package com.nashtech.assignment.pdh.entities;

import java.util.Set;

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
@Table(name = "orders")
@Getter
@Setter
public class Orders {
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orId;
	@Column
	private String orDate;
	@Column
	private String orStatus;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users users;
	
	@OneToMany(mappedBy = "orders")
	private Set<OrderDetail>details;

	public Long getOrId() {
		return orId;
	}

	public void setOrId(Long orId) {
		this.orId = orId;
	}

	public String getOrDate() {
		return orDate;
	}

	public void setOrDate(String orDate) {
		this.orDate = orDate;
	}

	public String getOrStatus() {
		return orStatus;
	}

	public void setOrStatus(String orStatus) {
		this.orStatus = orStatus;
	}
	
	
	
}
