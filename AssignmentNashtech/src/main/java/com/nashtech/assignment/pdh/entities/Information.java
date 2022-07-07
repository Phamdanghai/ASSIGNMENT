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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long infId;

	@Column(nullable = false, length = 250)
	private String infFullName;

	@Column(length = 15)
	private String infPhone;

	@Column(length = 300)
	private String infAddress;

	@OneToOne
	@JoinColumn(name = "userId")
	private Users users;

}
