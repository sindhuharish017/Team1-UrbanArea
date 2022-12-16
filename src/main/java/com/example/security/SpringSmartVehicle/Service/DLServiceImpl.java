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
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class DLServiceImpl implements DLService {

	@Autowired
	private DLRepo dlRepo;

	private static final Logger logger = LoggerFactory.getLogger(DLServiceImpl.class);

	// create a new dl
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean createDL(DrivingLicense dl) {
		logger.info("saving new dl");
		DrivingLicense d = dlRepo.save(dl);
		logger.debug("Driving License saved with id =" + d.getId() + " is " + d);
		return true;
	}

	// To Check Whether the DL number and Phone number exist
	@Override
	public boolean checkmobnodlno(DrivingLicense dl) {
		logger.info("check DL number and phone number exist");
		if (checkIfDLExist(dl.getDlno()) != null) {

			return false;
		}

		else if (checkIfPhoneNumberExist(dl.getMobNo()) != null) {
			return false;
		}
		return true;
	}

	private DrivingLicense checkIfPhoneNumberExist(long mobNo) {

		DrivingLicense d = dlRepo.findBymobNo(mobNo);
		return d;
	}

	// check if the dl exist or not
	private DrivingLicense checkIfDLExist(String dlno) {
		DrivingLicense d = dlRepo.findByDlno(dlno);
		return d;
	}

	// list the dl
	@Override
	public List<DrivingLicense> getAll() {
		logger.info("loading all DL");
		List<DrivingLicense> d = dlRepo.findAll();
		logger.info("loaded " + d.size() + " DL");
		logger.debug("DL are" + d);
		return d;
	}

	// update the dl
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(DrivingLicense dl) {
		logger.info("updating Driving license with id " + dl.getId());
		DrivingLicense d = dlRepo.save(dl);
		logger.debug("Driving license updated with id =" + dl.getId() + " is " + dl);

	}

	// list the dl
	@Override
	public DrivingLicense getAlldls() {
		// TODO Auto-generated method stub
		return null;
	}

	// listing the no of dl using id(getbyid)
	@Override
	public DrivingLicense getById(int id) {
		logger.info("Listing Driving license with id ");
		DrivingLicense d = dlRepo.findById(id);
		logger.debug("Listing Driving license with id " + d.getId());
		return d;

	}

	@Override
	public int getIdByMobNo(long mobNo) {
		logger.info("fetch moblie number ");
		DrivingLicense dl = dlRepo.findBymobNo(mobNo);
		int id = dl.getId();
		logger.debug("Moblie Number " + dl.getMobNo());
		return id;
	}

	@Override
	public int generateOTP() {

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
		logger.info("checking whether DOB greater than 18");
		if (diff > 18) {

			return true;
		} else {

			return false;
		}

	}

	@Override
	public boolean checkIfMobNoExist(long mobNo) {

		DrivingLicense d = dlRepo.findBymobNo(mobNo);
		logger.info("checking whether DOB greater than 18");
		if (d != null) {

			return true;
		}
		return false;
	}
}
