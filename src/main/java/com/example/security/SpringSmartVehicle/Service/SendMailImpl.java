package com.example.security.SpringSmartVehicle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SendMailImpl implements SendMail {
	

	// SendMail mm = new SendMailImpl();

	@Autowired
	EmailService emailService;
	
	private UserServiceImpl userServiceImpl;
	

	/* (non-Javadoc)
	 * @see com.retail.delight.service.SendMail#sendAlert(java.lang.String, java.lang.String)
	 */
	

	/* (non-Javadoc)
	 * @see com.retail.delight.service.SendMail#registeredSuccessfully(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendForgotPasswordToAdmin(String email, String role, String name) {
		String subject1 = "Password Recovery !! .. " + name;
		String body1 = "Hello, ADMIN, Your Password is " + userServiceImpl.PASSWORD
				+ " Thank You For Contacting the Team - Team SMART VEHICLE";
		
		// mm.sendMail(email, subject1, body1);
		emailService.SendMail("retaildelightsmartgroceries@gmail.com", email, subject1, body1);
	}



}
