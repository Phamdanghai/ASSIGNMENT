package com.nashtech.assignment.pdh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "feedback")
@Getter
@Setter
public class FeedBack {
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fbId;
	
	@Column
	private String fbComment;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users users;
	
	@ManyToOne
	@JoinColumn(name = "proId")
	private Products products;
	
}
