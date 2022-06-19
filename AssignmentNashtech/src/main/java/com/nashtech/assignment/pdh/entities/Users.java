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
import javax.persistence.OneToOne;
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
	private Long userId;
	
	@Column(nullable = false,length = 200)
	private String userName;
	
	@Column(nullable = false,length = 200)
	private String userPassword;
	
	@Column(length = 350)
	private String userEmail;
	
	/*
	 * @Column private Long roleId;
	 */
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Roles roles;
	
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
	private Set<FeedBack>feedBacks;
	
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
	private Set<Orders>orders;
	
	@OneToOne(mappedBy = "users",cascade = CascadeType.ALL)
	private Information information;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
	
}
