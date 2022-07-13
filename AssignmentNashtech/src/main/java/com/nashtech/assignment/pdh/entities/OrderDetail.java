package com.nashtech.assignment.pdh.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
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

}
