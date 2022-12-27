package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.User;

public interface UserService {
	
	
	

	void userUpdate(String phno, int id) throws Exception;

	List<User> getAll();

	boolean checkIfPhoneNumberExist(String mobNo) ;
	
	void createUser(User user) throws Exception;
	
	User findUserBydl(DrivingLicense dl);
	
	User findUserByMobileNumber(String mobno);
	

}