package com.example.security.SpringSmartVehicle.entity;

import javax.persistence.CascadeType;
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
	private String dlNo;
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
	public User(int id, String dlNo, String mobNo) {
		super();
		this.id = id;
		this.dlNo = dlNo;
		this.mobNo = mobNo;
	}
	public User(String dlNo, String mobNo) {
		super();
		this.dlNo = dlNo;
		this.mobNo = mobNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDlNo() {
		return dlNo;
	}
	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	
}
