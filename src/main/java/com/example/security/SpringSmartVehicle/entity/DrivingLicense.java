package com.example.security.SpringSmartVehicle.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class DrivingLicense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String dlno;
	private String name;
	private LocalDate dateofBirth;
	private String address;
	private LocalDate fromDate;
	private LocalDate toDate;
	private int age;
	private long mobNo;

	private String[] vehicle;
	

	
	//parameter less constructor
	public DrivingLicense() {
	
	}

	
	//parametered constructor
	public DrivingLicense(String name, LocalDate dateofBirth, String address, LocalDate fromDate, LocalDate toDate,
			int age, long mobNo, String[] vehicle) {
		super();
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.age = age;
		this.mobNo = mobNo;
		this.vehicle = vehicle;
	}



	public DrivingLicense(String dlno, String name, LocalDate dateofBirth, String address, LocalDate fromDate,
			LocalDate toDate, int age, long mobNo, String[] vehicle) {
		super();
		this.dlno = dlno;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.age = age;
		this.mobNo = mobNo;
		this.vehicle = vehicle;
	}



	


	public DrivingLicense(String dlno, String name, LocalDate dateofBirth, String address, LocalDate fromDate,
			LocalDate toDate, int age, long mobNo, String[] vehicle, User user) {
		super();
		this.dlno = dlno;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.age = age;
		this.mobNo = mobNo;
		this.vehicle = vehicle;
//		this.user = user;
	}






	public DrivingLicense(int id, String dlno, String name, LocalDate dateofBirth, String address, LocalDate fromDate,
			LocalDate toDate, int age, long mobNo, String[] vehicle, User user) {
		super();
		this.id = id;
		this.dlno = dlno;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.age = age;
		this.mobNo = mobNo;
		this.vehicle = vehicle;
//		this.user = user;
	}



	public DrivingLicense(int id, String dlno, String name, LocalDate dateofBirth, String address, LocalDate fromDate,
			LocalDate toDate, int age, long mobNo, String[] vehicle) {
		super();
		this.id = id;
		this.dlno = dlno;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.age = age;
		this.mobNo = mobNo;
		this.vehicle = vehicle;
	}



	//getter & setter
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LocalDate getDateofBirth() {
		return dateofBirth;
	}



	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public LocalDate getFromDate() {
		return fromDate;
	}



	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}



	public LocalDate getToDate() {
		return toDate;
	}



	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public long getMobNo() {
		return mobNo;
	}



	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}




	public String[] getVehicle() {
		return vehicle;
	}



	public void setVehicle(String[] vehicle) {
		this.vehicle = vehicle;
	}


	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", dlno=" + dlno + ", name=" + name + ", dateofBirth=" + dateofBirth
				+ ", address=" + address + ", fromDate=" + fromDate + ", toDate=" + toDate + ", age=" + age + ", mobNo="
				+ mobNo + ", vehicle=" + Arrays.toString(vehicle) + "]";
	}





}