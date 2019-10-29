package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "USER_PASS")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHNO")
	private Long phno;
	
	@Column(name = "COUNTRY")
	private String country;
	
}
