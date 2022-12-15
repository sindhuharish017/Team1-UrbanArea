package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;

public interface DLService {

	

	

	

	int getIdByMobNo(long mobNo);

	int generateOTP();

	boolean createDL(DrivingLicense dl);

	List<DrivingLicense> getAll();

	void update(DrivingLicense dl);

	DrivingLicense getAlldls();

	DrivingLicense getById(int id);

	boolean DOBvalidation(DrivingLicense dlno);

	boolean checkmobnodlno(DrivingLicense dl);

	boolean checkIfMobNoExist(long mobNo);


}