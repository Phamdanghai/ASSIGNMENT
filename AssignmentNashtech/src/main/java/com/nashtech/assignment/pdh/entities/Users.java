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
@Table(name = "users")
@Getter
@Setter
public class Users {
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	
	@Column(nullable = false,length = 200)
	private String userName;
	
	@Column(nullable = false,length = 200)
	private String userPassword;
	
	@Column(length = 350)
	private String userEmail;
	
	@Column
	private Long roleId;
}
