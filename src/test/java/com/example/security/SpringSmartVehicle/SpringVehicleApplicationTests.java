package com.example.security.SpringSmartVehicle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.security.SpringSmartVehicle.Service.DLServiceImpl;
import com.example.security.SpringSmartVehicle.Service.UserServiceImpl;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.User;


@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class SpringVehicleApplicationTests {

	@Autowired
	 private MockMvc mvc;
	
	
	@Autowired
	private DLServiceImpl dlServiceImpl;
	
	@Autowired
	private UserServiceImpl userserviceimpl;
	  @Test
	    @WithAnonymousUser
		public void testHome() throws Exception{
			mvc.perform(get("/home")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
		}
	   @Test 
	    void testRtoPage() throws Exception {
	        mvc.perform(get("/admin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	    }
	   @Test
	    void testadmincreatedl() throws Exception {
	        mvc.perform(get("/createdl")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk()); 
	    }
	    @Test
	    void testdllist() throws Exception {
	        mvc.perform(get("/dllist")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	        
	    }
	    @Test
	    void testuserregister() throws Exception {
	        mvc.perform(get("/register")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	        
	    }
	    @Test 
	    void testUserPage() throws Exception {
	        mvc.perform(get("/userlogin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	    }
	    @Test
	    void testaccessdenied() throws Exception {
	        mvc.perform(get("/accessDenied")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	        
	    }
	   
	    @Test
	    void testvehicletype() throws Exception {
	        String id = "1";
	        mvc.perform(get("/vehicleType/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	    }
	
	    @Test
	    void testallowaccess() throws Exception {
	    	String id="1";
	        mvc.perform(get("/allowAccess/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	    }
	    @Test
	    void testpolice() throws Exception {
	        String id = "1";
	        mvc.perform(get("/police/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	    }

//	    @Test
//	    public void createDL() {
//	    	LocalDate d=LocalDate.parse("2000-05-07");
//	    	String[] str={"2wheeler","3Wheeler"};
//	    	DrivingLicense dl=new DrivingLicense(1,"s5s54","nayana",d,"shimoga",d,d,22,9987543261L,str);
//	    	assertEquals("Sucessfully Added DL Information",dlServiceImpl.createDL(dl));
//	    }
//	    @Test
//	    public void createUser() throws Exception {
//	    	LocalDate d=LocalDate.parse("2000-05-07");
//	    	User u=new User("s5s54","ab", "2Wheeler","sss",9987543261L , "ss@gmail.com",d, "ab");
//	    	assertEquals("Successfully created User", userserviceimpl.createUser(u));
//	    }

	}


