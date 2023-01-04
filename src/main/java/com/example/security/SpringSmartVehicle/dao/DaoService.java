package com.example.security.SpringSmartVehicle.dao;

public interface DaoService {

	void userUpdate(String mobNo, int id) throws Exception;

	void deleteById(int id);

}