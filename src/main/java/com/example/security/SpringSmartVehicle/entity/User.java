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
	private String dlno;
	@NotBlank
	@Column(unique = true, nullable = false)
	private String pass;
	private String vehicleType;
	@Column(name="name")
	private String fullname;
	private long phonenumber;
	private String email;
	private LocalDate dateofbirth;
	private String confirmpassword;


	public User() {
	}

	public User(int id, String dlno, @NotBlank String pass, String vehicleType, String fullname, long phonenumber,
			String email, LocalDate dateofbirth, String confirmpassword) {
		super();
		this.id = id;
		this.dlno = dlno;
		this.pass = pass;
		this.vehicleType = vehicleType;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.confirmpassword = confirmpassword;
	}

	public User(String dlno, @NotBlank String pass, String vehicleType, String fullname, long phonenumber, String email,
			LocalDate dateofbirth, String confirmpassword) {
		super();
		this.dlno = dlno;
		this.pass = pass;
		this.vehicleType = vehicleType;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.confirmpassword = confirmpassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDlno() {
		return dlno;
	}

	public void setDlno(String dlno) {
		this.dlno = dlno;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	

}
