package com.example.security.SpringSmartVehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(unique = true)
	private String mobNo;
	
	@OneToOne(fetch=FetchType.LAZY)
	private DrivingLicense drivingLicense;
	

	public DrivingLicense getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(DrivingLicense drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public User() {
		super();
	}
	
	public User(String mobNo, DrivingLicense drivingLicense) {
		super();
		this.mobNo = mobNo;
		this.drivingLicense = drivingLicense;
	}
	
	public User(int id, String mobNo, DrivingLicense drivingLicense) {
		super();
		this.id = id;
		this.mobNo = mobNo;
		this.drivingLicense = drivingLicense;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}


}
