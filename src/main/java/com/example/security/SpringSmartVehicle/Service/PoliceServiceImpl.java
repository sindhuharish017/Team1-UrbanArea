package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.security.SpringSmartVehicle.Repository.PoliceRepo;
import com.example.security.SpringSmartVehicle.entity.Police;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class PoliceServiceImpl implements PoliceService {

	@Autowired
	private PoliceRepo policeRepo;
	
//Storing User Information to Police If Accident Happense
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void ProvideUserIdentity(@ModelAttribute Police police ) throws Exception {
//		Police police= findByUserId(drivingLicense.getId());
			policeRepo.save(police);
		}
			
	
		@Override
		public List<Police> getAll() {
			return policeRepo.findAll();
		}

//to get the Particular User Details
		@Override
		public Police findByUserId(int id) {
			// TODO Auto-generated method stub
			return policeRepo.findById(id).get();
		}


		
}
