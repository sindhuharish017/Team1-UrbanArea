package com.example.security.SpringSmartVehicle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.SpringSmartVehicle.Repository.PoliceRepo;
import com.example.security.SpringSmartVehicle.dao.DaoService;
import com.example.security.SpringSmartVehicle.entity.Police;
import com.example.security.SpringSmartVehicle.entity.User;


@Service
public class policeServiceImpl implements policeSerive{

	@Autowired
	private PoliceRepo policerepo;
	
@Autowired
	private DaoService daoService;
	
	
	@Override
	public void createPolice(Police p){
		policerepo.save(p);
	}

	
	@Override
	public boolean CheckIfAccidentAlreadyHappenseByUser(User u) {
		// TODO Auto-generated method stub
		Police p=policerepo.findByUser(u);
		if(p!=null){
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		daoService.deleteById(id);
	}
}
