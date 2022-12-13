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
	public Boolean loginValidator(String dlno,String pass) {
		User user=userRepo.findByDlno(dlno);
		 if(user.getDlno()==dlno && user.getPass()==pass)
			 return true;
		 else 
			 return false;
	    }

	//User Registration 
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String createUser(@ModelAttribute User user) throws Exception {
//		User u = userRepo.findByDlno(user.getDlno());
		if(user.getDlno()==""){
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
	public int getIdByDlno(String dlno) {
		User u=userRepo.findByDlno(dlno);
		int id=u.getId();
		return id;
	}
	
	@Override
	public String getDlno(String dlno) {
		User u=userRepo.findByDlno(dlno);
		u.getId();
		return u.getDlno();
	}
	//Getting User by providing id 
	@Override
	public Object getUser(int id) {
		return userRepo.findById(id);
	}


	@Override
	public boolean checkIfDlExist(String dlno) {
	User u = userRepo.findByDlno(dlno);
	if(u.getDlno().equals(dlno))
		return true;
	else {
		return false;
	}
//		return userRepo.findByDlno(dlno);
	
	}


	@Override
	public String finduser(String dlno) {

		 if(userRepo.findByDlno(dlno)!=null){
			 return userRepo.findByDlno(dlno).getDlno();
		 }
			 return null;
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
