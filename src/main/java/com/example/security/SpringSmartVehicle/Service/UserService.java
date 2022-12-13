package com.example.security.SpringSmartVehicle.Service;


import java.util.Optional;

import com.example.security.SpringSmartVehicle.entity.User;

public interface UserService {

	public String createUser(User user) throws Exception ;

	public void deleteUser(User user) ;

	public void updateUser(User user);

	public Optional<User> getAll(int id);


	public Object getUser(int id);

	
	public String findpass(String pass);

	public long finduser(long mobNumber);
	
	public boolean checkIfDlExist(long mobNumber);
	
	public long getPhoneNumber(long mobNumber);
	
	public int getIdByMobileNumber(long mobNo);
	
	public Boolean loginValidator(long mobNumber,String pass);
	
}