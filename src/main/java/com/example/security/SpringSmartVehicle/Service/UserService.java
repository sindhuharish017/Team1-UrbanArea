package com.example.security.SpringSmartVehicle.Service;


import java.util.Optional;

import com.example.security.SpringSmartVehicle.entity.User;

public interface UserService {

	public String createUser(User user) throws Exception ;

	public void deleteUser(User user) ;

	public Boolean loginValidator(String dlno,String pass);

	public void updateUser(User user);

	public Optional<User> getAll(int id);

	public int getIdByDlno(String dlno);

	public Object getUser(int id);

	public boolean checkIfDlExist(String dlno);

	String getDlno(String dlno);

	public String finduser(String dlno);

	public String findpass(String pass);


	
}