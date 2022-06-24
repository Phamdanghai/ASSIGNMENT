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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Users.getUserEmail", query = "SELECT a FROM Users a where a.userEmail = :email")})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotBlank
	@Column(nullable = false, length = 200)
	private String userPassword;

	@NotBlank
	@Column(length = 350)
	@Email
	private String userEmail;

	/*
	 * @Column private Long roleId;
	 */

	@ManyToOne
	@JoinColumn(name = "roleId")
	private Roles roles;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<FeedBack> feedBacks;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<Orders> orders;

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Information information;

	public Users(String email, String password) {
		this.userEmail = email;
		this.userPassword = password;
	}

}
