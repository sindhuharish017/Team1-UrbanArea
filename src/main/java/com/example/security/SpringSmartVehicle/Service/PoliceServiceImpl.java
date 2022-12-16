package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(PoliceServiceImpl.class);
	
//Storing User Information to Police If Accident Happense
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void ProvideUserIdentity(@ModelAttribute Police police ) throws Exception {
	    	logger.info("user Info");
            Police p=policeRepo.save(police);
            logger.debug("Storing User info "+p);
		}
			
	
		

//to get the Particular User Details
		@Override
		public Police findByUserId(int id) {
			logger.info("get particular user info");
			Police p=policeRepo.findById(id).get();
			logger.debug("particular user "+p);
			return p;
		}


		
}
