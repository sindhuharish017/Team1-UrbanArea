package com.example.security.SpringSmartVehicle.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.Police;
import com.example.security.SpringSmartVehicle.entity.User;

@Repository
public interface PoliceRepo extends JpaRepository<Police, Integer>{

//	DrivingLicense findByUserId(int userid);

	void save(DrivingLicense dl);

	Police findByDlno(String dlno);

//	DrivingLicense findByUserId();

}
