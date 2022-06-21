package com.nashtech.assignment.pdh.entities;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supCategories")
@Getter
@Setter
public class SupCategories {
	public SupCategories() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supCateId;
	
	@Column
	private String supCateName;
	
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Categories categories;
	
	@OneToMany(mappedBy = "supCategories",cascade = CascadeType.ALL)
	private Set<Products> products;
	

}
