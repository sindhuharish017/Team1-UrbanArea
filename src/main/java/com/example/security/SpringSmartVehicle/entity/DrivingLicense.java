package com.example.security.SpringSmartVehicle.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class DrivingLicense {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(unique = true)
	private String dlno;
	private String name;
	private LocalDate dateofBirth;
	private String address;
	private LocalDate dateofIssue;
	private LocalDate validTill;
	private String[] vehicle;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="drivingLicense")
	@JoinColumn(name="userid",nullable=false)
	private User user;
	
	// parameter less constructor
	public DrivingLicense() {

	}

	public DrivingLicense(String dlno, String name, LocalDate dateofBirth, String address, LocalDate dateofIssue,
			LocalDate validTill, String[] vehicle) {
		super();
		this.dlno = dlno;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.dateofIssue = dateofIssue;
		this.validTill = validTill;

	
		this.vehicle = vehicle;
	}

	public DrivingLicense(int id, String dlno, String name, LocalDate dateofBirth, String address, LocalDate dateofIssue,
			LocalDate validTill, String[] vehicle) {
		super();
		this.id = id;
		this.dlno = dlno;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.address = address;
		this.dateofIssue = dateofIssue;
		this.validTill = validTill;
		this.vehicle = vehicle;
	}

	// getter & setter
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
		return dateofIssue;
	}

	public void setFromDate(LocalDate dateofIssue) {
		this.dateofIssue = dateofIssue;
	}

	public LocalDate getToDate() {
		return validTill;
	}

	public void setToDate(LocalDate validTill) {
		this.validTill = validTill;
	}


	public String[] getVehicle() {
		return vehicle;
	}

	public void setVehicle(String[] vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDate getDateofIssue() {
		return dateofIssue;
	}

	public void setDateofIssue(LocalDate dateofIssue) {
		this.dateofIssue = dateofIssue;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", dlno=" + dlno + ", name=" + name + ", dateofBirth=" + dateofBirth
				+ ", address=" + address + ", dateofIssue=" + dateofIssue + ", validTill=" + validTill + ", vehicle="
				+ Arrays.toString(vehicle) + ", user=" + user + "]";
	}
	
	

}