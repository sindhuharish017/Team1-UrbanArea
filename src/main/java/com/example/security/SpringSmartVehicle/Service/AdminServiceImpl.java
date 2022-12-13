package com.example.security.SpringSmartVehicle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.SpringSmartVehicle.Repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

//	@Override
	public int loginValidator(String username) {
		if(adminRepo.findByUsername(username)!= null){
			return 1;
	}
	return 0;
	}

}
