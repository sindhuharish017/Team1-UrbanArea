package com.example.security.SpringSmartVehicle.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	private long mobNumber;
	@NotBlank
	@Column(unique = true, nullable = false)
	private String pass;
	private String vehicleType;
	private String confirmpassword;


	public User() {
	}


	public User(long mobNumber, @NotBlank String pass, String vehicleType, String confirmpassword) {
		super();
		this.mobNumber = mobNumber;
		this.pass = pass;
		this.vehicleType = vehicleType;
		this.confirmpassword = confirmpassword;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getMobNumber() {
		return mobNumber;
	}


	public void setMobNumber(long mobNumber) {
		this.mobNumber = mobNumber;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}