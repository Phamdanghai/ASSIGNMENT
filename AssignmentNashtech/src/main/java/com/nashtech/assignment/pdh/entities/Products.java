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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proId;

	@Column(nullable = false, length = 250)
	private String proName;

	@Column(nullable = false)
	private float proPice;

	@Column(length = 1000)
	private String proImage;

	@Column(length = 150)
	private String proDiscreption;

	@Column(nullable = false)
	private int proQuantity;

	// @Column
	// private Long categoryId;

	@ManyToOne
	@JoinColumn(name = "supCateId")
	private SupCategories supCategories;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Categories categories;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Set<FeedBack> feedBacks;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Set<CartItem> cartItems;
}
