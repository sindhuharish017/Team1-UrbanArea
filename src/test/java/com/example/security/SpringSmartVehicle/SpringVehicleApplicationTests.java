package com.example.security.SpringSmartVehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.When;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.security.SpringSmartVehicle.Repository.DLRepo;
import com.example.security.SpringSmartVehicle.Repository.UserRepo;
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
	private UserServiceImpl userServiceImpl;
	
	
	@Autowired
	private UserRepo userrepo;
	
	
	@Autowired
	private DLRepo dlrepo;

	
	


	@Test
	@WithAnonymousUser
	public void testHome() throws Exception {
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
	void testUserPage() throws Exception {
		mvc.perform(get("/userlogin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	}

	

	@Test
	void testvehicletype() throws Exception {
		String id = "1";
		mvc.perform(get("/vehicleType/{id}", id)).andDo(print()).andExpect(content().string(""))
				.andExpect(status().isOk());
	}

	@Test
	void testallowaccess() throws Exception {
		String id = "1";
		mvc.perform(get("/allowAccess/{id}", id)).andDo(print()).andExpect(content().string(""))
				.andExpect(status().isOk());
	}

	@Test
	void testpolice() throws Exception {
		String id = "1";
		mvc.perform(get("/police/{id}", id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	}
	

	@Test
	public void testCreateDl() throws Exception {
		
		String dlno = "KA06 65462626256";
		LocalDate dob = LocalDate.parse("2000-10-11");
		
		LocalDate isd = LocalDate.now();
		LocalDate vtd = isd.plusYears(20);
		String str[]  = {"MC50cc","LMV-NT"};
		DrivingLicense drivingLicense = new DrivingLicense( dlno,"saikumar",dob, "tumkur", isd, vtd,str) ;
		
		assertEquals(drivingLicense.getDlno(), "KA06 65462626256");
		User u=new User("9964657487" ,drivingLicense);
		if(userServiceImpl.checkIfPhoneNumberExist(u.getMobNo()))
			assertEquals(true, userServiceImpl.createUser(u));
		drivingLicense.setName("ritesh");
		dlServiceImpl.update(drivingLicense);
		
		assertEquals(drivingLicense.getName(),"ritesh");
		
//		assertEquals(drivingLicense.getId(),drivingLicense.getId());
			}
		
		
	
//	@Test
//	public void testDriverLicenceGetAll() {
//		List<DrivingLicense> alldl = dlServiceImpl.getAll();
//		assertEquals(alldl.size(), alldl.size());
//	}


	
//	@Test
//	public void testUpdate() throws Exception {
//	
//		DrivingLicense dl = dlServiceImpl.getById(1);
//		
//		dl.setName("ritesh");
//		dlServiceImpl.update(dl);
//		
//		assertEquals(dl.getName(),"ritesh");
//	}
	
	@Test
	public void testfindUserByMobileNumber(){
		User user = userrepo.findBymobNo("6363702829");
		assertEquals(user.getMobNo(),"6363702829");
		
	}
	
	
	
//	@Test
//	public void testfindUserByDl(DrivingLicense dl){
//		
//		User u=userServiceImpl.findUserBydl(dl);
//		assertEquals(u, userServiceImpl.findUserBydl(dl));
//		
//	
//	}

//	@Test
//	public void testcreateUser() throws Exception{
//		
//		DrivingLicense dl = dlServiceImpl.getById(1);
//		User u=new User("8217782949" , dl);
//		if(userServiceImpl.checkIfPhoneNumberExist(u.getMobNo()))
//			assertEquals(true, userServiceImpl.createUser(u));
//	}

	@Test
	public void testuserupdate() throws Exception{
	
		assertEquals(true, userServiceImpl.userUpdate("8217782949", 2));
	
	}
	
	
//	@Test
//	public void testfindbyid(){
//		
// 
//		DrivingLicense d4 = dlrepo.findById(1);
//		
//		//assertEquals(d4,dlrepo.findById(5));
//		assertEquals(d4.getId(),1);
//		
//		
//		
//		
//	}

	
	
	

}
