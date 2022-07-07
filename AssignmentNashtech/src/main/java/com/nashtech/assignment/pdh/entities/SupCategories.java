package com.nashtech.assignment.pdh.entities;

import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "supCategories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supCateId;

	@Column
	private String supCateName;

//	@ManyToOne
//	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
//	private Categories categories;

	@OneToMany(mappedBy = "supCategories", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Products> products;

}
