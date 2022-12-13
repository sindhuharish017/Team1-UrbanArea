package com.example.security.SpringSmartVehicle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.SpringSmartVehicle.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	Admin findByUsername(String username);

}
