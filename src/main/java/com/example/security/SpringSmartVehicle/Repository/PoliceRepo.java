package com.example.security.SpringSmartVehicle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.Police;

@Repository
public interface PoliceRepo extends JpaRepository<Police, Integer> {

	void save(DrivingLicense dl);

	Police findByDlno(String dlno);

}
