package com.example.security.SpringSmartVehicle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.SpringSmartVehicle.Repository.PoliceRepo;
import com.example.security.SpringSmartVehicle.entity.Police;

@Service
public class policeServiceImpl implements policeSerive{

	@Autowired
	private PoliceRepo policerepo;
	
	@Override
	public void createPolice(Police p){
		policerepo.save(p);
	}
}
