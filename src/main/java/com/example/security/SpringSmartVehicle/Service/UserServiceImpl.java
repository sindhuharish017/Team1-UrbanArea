package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.security.SpringSmartVehicle.Repository.UserRepo;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.security.SpringSmartVehicle.Service.UserService#userUpdate(
	 * java.lang.String, int)
	 */
	@Override
	public void userUpdate(String mobNo, int id) throws Exception {
		System.out.println(mobNo + id);
		logger.info("updating user");
		String sql = "update users set mob_no = ? where driving_license_id= ?";
		jdbcTemplate.update(sql, mobNo, id);
		logger.debug("user updated id =" + id);

	}

	@Override
	public List<User> getAll() {
		logger.info("loading all user");
		List<User> u = userRepo.findAll();
		logger.info("loaded " + u.size() + " User");
		logger.debug("User are" + u);
		return u;

	}

	@Override
	public void createUser(User user) throws Exception {
		logger.info("saving new user");
		userRepo.save(user);
		logger.debug("User saved with id =" + user.getId() + " is " + user);
	}

	@Override
	public boolean checkIfPhoneNumberExist(String mobNo) {
//		System.out.println(mobNo);
		logger.info("mob_no" +mobNo);
		User u = userRepo.findBymobNo(mobNo);
		if (u != null) {
			return false;
		}
		return true;
	}

	@Override
	public User findUserBydl(DrivingLicense dl) {
		logger.info("find User Using DL");
		User u = userRepo.findByDrivingLicense(dl);
		logger.debug("dl No " + u);
		return u;
	}

	@Override
	public User findUserByMobileNumber(String mobno) {
		logger.info("find User Using Mob_No");
		User u= userRepo.findBymobNo(mobno);
		logger.debug("Mob No " + u);
		return u;
	}

}
