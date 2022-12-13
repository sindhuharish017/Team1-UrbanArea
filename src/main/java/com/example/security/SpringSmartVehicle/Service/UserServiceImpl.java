package com.example.security.SpringSmartVehicle.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.security.SpringSmartVehicle.Repository.UserRepo;
import com.example.security.SpringSmartVehicle.entity.User;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	
	
	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);
	}

	@Override
	public Optional<User> getAll(int id) {
		return userRepo.findById(id);
	}


//To Validate While User is Login
	@Override
	public Boolean loginValidator(long mobNumber,String pass) {
		User user=userRepo.findBymobNumber(mobNumber);
		 if(user.getMobNumber()==mobNumber && user.getPass()==pass)
			 return true;
		 else 
			 return false;
	    }

	//User Registration 
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String createUser(@ModelAttribute User user) throws Exception {
		
		if(Long.valueOf(user.getMobNumber())==null){
			if(user.getPass()==""){
			try {
				throw new Exception("please enter dlno and password");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return "user not created";
		}
		else {
			userRepo.save(user);
			return "Successfully created User";
		}
			
//			if(u.getDlno().equals(user.getDlno()))
//				return true;
//			else {
//				userRepo.save(user);
//		?		return false;
//			}
		
		}
			
		
			

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUser(User user) {
//		user.setVehicleType(user.getVehicleType());
		userRepo.save(user);
	}

//	@Override
//	public Optional<User> getAll(int id) {
//		return userRepo.findById(id);
//	}

	//Getting User by providing Dlno 
	@Override
	public int getIdByMobileNumber(long mobNo) {
		User u=userRepo.findBymobNumber(mobNo);
		int id=u.getId();
		return id;
	}
	
	@Override
	public long getPhoneNumber(long mobNumber) {
		User u=userRepo.findBymobNumber(mobNumber);
		u.getId();
		return u.getMobNumber();
	}
	//Getting User by providing id 
	@Override
	public Object getUser(int id) {
		return userRepo.findById(id);
	}


	@Override
	public boolean checkIfDlExist(long mobNumber) {
	User u = userRepo.findBymobNumber(mobNumber);
	if(u.getMobNumber()==mobNumber)
		return true;
	else {
		return false;
	}
//		return userRepo.findByDlno(dlno);
	
	}


	@Override
	public long finduser(long mobNumber) {

		 if(userRepo.findBymobNumber(mobNumber)!=null){
			 return userRepo.findBymobNumber(mobNumber).getMobNumber();
		 }
			 return 0;
	}


	@Override
	public String findpass(String pass) {
		// TODO Auto-generated method stub
		if(userRepo.findByPass(pass)!=null){
			 return userRepo.findByPass(pass).getPass();
		 }
			 return null;
	}


	

	
}
