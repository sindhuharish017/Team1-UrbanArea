package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

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
		String sql = "update users set mob_no = ? where driving_license_id= ?";
		jdbcTemplate.update(sql, mobNo, id);

	}

	@Override
	public List<User> getAll() {

		List<User> u = userRepo.findAll();

		return u;

	}

	@Override
	public void createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public boolean checkIfPhoneNumberExist(String mobNo) {
		System.out.println(mobNo);
		User u = userRepo.findBymobNo(mobNo);
		if (u != null) {
			return false;
		}
		return true;
	}

	@Override
	public User findUserBydl(DrivingLicense dl) {
		// TODO Auto-generated method stub
		User u = userRepo.findByDrivingLicense(dl);
		return u;
	}

	@Override
	public User findUserByMobileNumber(String mobno) {
		// TODO Auto-generated method stub
		User u= userRepo.findBymobNo(mobno);
		return u;
	}

}
