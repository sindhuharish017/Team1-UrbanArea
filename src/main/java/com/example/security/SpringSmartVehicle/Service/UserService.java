package com.example.security.SpringSmartVehicle.Service;

import java.util.List;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.User;

public interface UserService {


	List<User> getAll();

	boolean checkIfPhoneNumberExist(String mobNo);

	boolean createUser(User user) throws Exception;

	User findUserBydl(DrivingLicense dl);

	User findUserByMobileNumber(String mobno);

	boolean userUpdate(String mobNo, int id) throws Exception;

}