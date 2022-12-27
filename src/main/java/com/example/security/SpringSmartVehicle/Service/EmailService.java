package com.example.security.SpringSmartVehicle.Service;

public interface EmailService {

	void SendMail(String from, String to, String subject, String text);

}