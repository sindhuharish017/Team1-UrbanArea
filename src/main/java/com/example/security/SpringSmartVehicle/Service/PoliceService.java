package com.example.security.SpringSmartVehicle.Service;

import com.example.security.SpringSmartVehicle.entity.Police;

public interface PoliceService {
	Police findByUserId(int id);

	void ProvideUserIdentity(Police police) throws Exception;

	
}