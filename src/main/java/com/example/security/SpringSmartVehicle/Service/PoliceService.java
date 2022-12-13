package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import com.example.security.SpringSmartVehicle.entity.Police;

public interface PoliceService {
	Police findByUserId(int id);

//	void save(Police police);

	List<Police> getAll();

	

	void ProvideUserIdentity(Police police) throws Exception;

//	void ProvideUserIdentity(DrivingLicense dl) throws Exception;

}