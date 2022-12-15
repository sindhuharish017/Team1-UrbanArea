package com.example.security.SpringSmartVehicle.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean createDL(DrivingLicense dl) {
		
        dlRepo.save(dl);
		return true;
	}
	@Override
	public boolean checkmobnodlno(DrivingLicense dl){
		if (checkIfDLExist(dl.getDlno()) != null) {
			return false;
		} else if (checkIfPhoneNumberExist(dl.getMobNo()) != null) {
			return false;
		}
		return true;
	}


	private DrivingLicense checkIfPhoneNumberExist(long mobNo) {
		// TODO Auto-generated method stub

		return dlRepo.findBymobNo(mobNo);
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
	public String update(DrivingLicense dl) {
		dlRepo.save(dl);
		return "dl Updated";
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
	return dlRepo.findById(id);
	
}
	@Override
	public int getIdByMobNo(long mobNo) {
		// TODO Auto-generated method stub
		DrivingLicense dl=dlRepo.findBymobNo(mobNo);
		int id=dl.getId();
		return id;
	}
	@Override
	 public int generateOTP(){

		    Random random = new Random();
		    int otp = 100000 + random.nextInt(900000);
		    return otp;
}
	@Override
	public boolean DOBvalidation(DrivingLicense dlno) {
		DrivingLicense dl = dlno;
		LocalDate today = LocalDate.now();
		LocalDate DOB = dl.getDateofBirth();
		LocalDate DOI = dl.getFromDate();
		int diff = today.compareTo(DOB);
		if (diff>18 ) {
			return true;
		} else {

			return false;
		}

	}
	@Override
    public boolean checkIfMobNoExist(long mobNo) {
        // TODO Auto-generated method stub
        DrivingLicense d=dlRepo.findBymobNo(mobNo);
        if(d!=null){
            return true;
        }
        return false;
    }
}
