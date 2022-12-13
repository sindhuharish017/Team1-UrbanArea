package com.example.security.SpringSmartVehicle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.SpringSmartVehicle.entity.DrivingLicense;

@Repository
public interface DLRepo extends JpaRepository<DrivingLicense, Integer> {

	 DrivingLicense findBymobNo(long mobNo) ;
	 DrivingLicense findByDlno(String dlno);

		
}
