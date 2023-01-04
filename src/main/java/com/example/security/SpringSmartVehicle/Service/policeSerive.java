package com.example.security.SpringSmartVehicle.Service;

import com.example.security.SpringSmartVehicle.entity.Police;
import com.example.security.SpringSmartVehicle.entity.User;

public interface policeSerive {

	void createPolice(Police p);

	boolean CheckIfAccidentAlreadyHappenseByUser(User u);

	void deleteById(int id);

}
