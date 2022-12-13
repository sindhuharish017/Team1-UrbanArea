package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.security.SpringSmartVehicle.Repository.DLRepo;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class DLServiceImpl implements DLService {
	
	@Autowired
	private DLRepo dlRepo;
	
	//create a new dl
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String createDL(DrivingLicense dl)  {
		if(checkIfDLExist(dl.getDlno())!=null){
			return "DL already Exists";
		}
		dlRepo.save(dl);
		return "Sucessfully Added DL Information";
	}
	
	//check if the dl exist or not
	private DrivingLicense checkIfDLExist(String dlno) {
		return dlRepo.findByDlno(dlno);
	}
	//list the dl
	@Override
	public List<DrivingLicense> getAll() {
		return dlRepo.findAll();
	}
	
	//update the dl
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(DrivingLicense dl) {
		dlRepo.save(dl);
	}

	//list the dl
	@Override
	public DrivingLicense getAlldls() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//listing the no of dl using id(getbyid)
	@Override
	public DrivingLicense getById(int id) {
	return dlRepo.findById(id).get();
	
}

}
