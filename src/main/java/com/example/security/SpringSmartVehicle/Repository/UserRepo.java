package com.example.security.SpringSmartVehicle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.SpringSmartVehicle.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findBymobNumber(long mobNumber);
//	boolean findByDlnoAndPass(String dlno,String pass);

	User findByPass(String pass);




	
}
