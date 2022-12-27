package com.example.security.SpringSmartVehicle.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.security.SpringSmartVehicle.Repository.DLRepo;
import com.example.security.SpringSmartVehicle.Repository.UserRepo;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class DLServiceImpl implements DLService {

	@Autowired
	private DLRepo dlRepo;
	
	@Autowired
	private UserRepo userRepo;

	private static final Logger logger = LoggerFactory.getLogger(DLServiceImpl.class);

	// To create a new dl
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean createDL(DrivingLicense dl) {
		logger.info("saving new dl");
		DrivingLicense d = dlRepo.save(dl);
		logger.debug("Driving License saved with id =" + d.getId() + " is " + d);
		return true;
	}

	// To Check Whether the DL number already exist
	@Override
	public boolean checkdlno(DrivingLicense dl) {
		logger.info("check DL number exist");
		if (checkIfDLExist(dl.getDlno()) != null) {
			return false;
		}
		return true;
	}



	// check if the dl exist or not
	private DrivingLicense checkIfDLExist(String dlno) {
		DrivingLicense d = dlRepo.findByDlno(dlno);
		return d;
	}

	// listing the dl
	@Override
	public List<DrivingLicense> getAll() {

		logger.info("loading all DL");
		List<DrivingLicense> d = dlRepo.findAll();
	logger.info("loaded " + d.size() + " DL");
		logger.debug("DL are" + d);
		return d;

		
	}
	
	
	// updating the dl
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String update(DrivingLicense dl) {
		logger.info("updating Driving license with id " + dl.getId());
		dlRepo.save(dl);
		logger.debug("Driving license updated with id =" + dl.getId() + " is " + dl);
		
        return "dl updated";
	}

	
	// listing the no of dl using id(getbyid)
	@Override
	public DrivingLicense getById(int id) {
		logger.info("Listing Driving license with id ");
		DrivingLicense d = dlRepo.findById(id);
		logger.debug("Listing Driving license with id " + d.getId());
		return d;

	}
//To get ID using user mobile number
	@Override
	public int getIdByMobNo(String mobNo) {
		logger.info("fetch mob number ");

		User u = userRepo.findBymobNo(mobNo);
		DrivingLicense dl= dlRepo.findByUser(u);
		int id = dl.getId();
		logger.debug("Moblie Number " +mobNo);
		return id;
	}

	//To generate OTP
	@Override
	public int generateOTP() {

		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return otp;
	}

	//To validate Date of Birth such that it is greater than 18 years from the current date
	@Override
	public boolean DOBvalidation(DrivingLicense dlno) {
		DrivingLicense dl = dlno;
		LocalDate today = LocalDate.now();
		LocalDate DOB = dl.getDateofBirth();
	
		int diff = today.compareTo(DOB);
		logger.info("checking whether DOB greater than 18");
		if (diff > 18) {

			return true;
		} else {

			return false;
		}

	}

	//To find dl information using user
	@Override
	public DrivingLicense findDrivingLicenseByUser(User u) {
		logger.info("find Driving license Using User");
		DrivingLicense dl=dlRepo.findByUser(u);
		logger.debug("User " + dl);
		return dl;
	}

	@Override
	public DrivingLicense findDlById(int id) {
		logger.info("find Driving license Using Id");
		DrivingLicense d=dlRepo.findById(id);
		logger.debug("Id " + d);
		return d;
	}




	
}
