package com.example.security.SpringSmartVehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username = "admin";
	private String pass = "admin";
	
	//parameter less constructor
	public Admin() {
	}
	
	//parametered constructor
	public Admin(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
	//getter & setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
