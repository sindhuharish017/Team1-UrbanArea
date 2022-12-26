package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.User;

public interface DLService {


	DrivingLicense findDrivingLicenseByUser(User u);

	int getIdByMobNo(String mobNo);

	int generateOTP();

	boolean createDL(DrivingLicense dl);

	List<DrivingLicense> getAll();

	String update(DrivingLicense dl);

	DrivingLicense getById(int id);

	boolean DOBvalidation(DrivingLicense dlno);

	boolean checkdlno(DrivingLicense dl);

	DrivingLicense findDlById(int id);

}