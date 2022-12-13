package com.example.security.SpringSmartVehicle.Service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.example.security.SpringSmartVehicle.entity.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class OtpService {
	private final String ACCOUNT_SID ="AC81b1658cefbeaa45d1e39cfabef3d5d2";

    private final String AUTH_TOKEN = "dd0bdeaa016f741e75db4c0901f1be9f";

    private final String FROM_NUMBER = "+12058508975";

    public void send(User user) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    	String TO_NUMBER=user.getMobNumber()+"";
        Message message = Message.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER), "you are reciving this because you are ready to drive vehicle")
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
