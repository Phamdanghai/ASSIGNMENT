package com.nashtech.assignment.pdh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "infor")
@Getter
@Setter
public class Information {
	public Information() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long infId;
	
	@Column(nullable = false,length = 250)
	private String infFullName;
	
	@Column(length = 15)
	private String infPhone;
	
	@Column(length = 300)
	private String intAddress;
	
	@NotBlank
	@Column(nullable = false, length = 200)
	private String userName;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Users users;

}
