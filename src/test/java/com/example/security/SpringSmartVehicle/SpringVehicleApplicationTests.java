//package com.example.security.SpringSmartVehicle;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDate;
//import java.util.List;
//
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.security.SpringSmartVehicle.Service.DLServiceImpl;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class SpringVehicleApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private DLServiceImpl dlServiceImpl;
//
//	
//	
//
//
	@Test
	@WithAnonymousUser
	public void testHome() throws Exception {
		mvc.perform(get("/home")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
	}
//
//	@Test
//	void testRtoPage() throws Exception {
//		mvc.perform(get("/admin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//	}
//
//	@Test
//	void testadmincreatedl() throws Exception {
//		mvc.perform(get("/createdl")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//	}
//
//	@Test
//	void testdllist() throws Exception {
//		mvc.perform(get("/dllist")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//
//	}
//
//	@Test
//	void testUserPage() throws Exception {
//		mvc.perform(get("/userlogin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//	}
//
//	@Test
//	void testaccessdenied() throws Exception {
//		mvc.perform(get("/accessDenied")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//
//	}
//
	@Test
	void testvehicletype() throws Exception {
		String id = "1";
		mvc.perform(get("/vehicleType/{id}", id)).andDo(print()).andExpect(content().string(""))
				.andExpect(status().isOk());
	}
//
//	@Test
//	void testallowaccess() throws Exception {
//		String id = "1";
//		mvc.perform(get("/allowAccess/{id}", id)).andDo(print()).andExpect(content().string(""))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	void testpolice() throws Exception {
//		String id = "1";
//		mvc.perform(get("/police/{id}", id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//	}
//
////	@Test
////	public void testCreateDl() {
////		LocalDate d = LocalDate.parse("2001-05-07");
////		LocalDate fd = LocalDate.now();
////		LocalDate td = fd.plusYears(21);
////		String[] str = { "MC 50cc", "MAWG" };
////		DrivingLicense dl = new DrivingLicense(58,"KA06 20201671902", "Vaikumar", d, "Vumkur", fd, td, 76930991135L, str);
////
////		assertEquals(true, dlServiceImpl.createDL(dl));
////
////	}
//
//	
//
//	
//	
//
//	@Test
//	public void testDriverLicenceGetAll() {
//		List<DrivingLicense> alldriver = dlServiceImpl.getAll();
//
//		assertEquals(alldriver.size(), alldriver.size());
//	}
//
//
//	
//
////	@Test
////	public void testUpdate() {
////	
////
////		LocalDate d = LocalDate.parse("2000-05-07");
////		LocalDate fd = LocalDate.now();
////		LocalDate td = fd.plusYears(20);
////		String[] str = { "MC 50cc", "MCWG" };
////		DrivingLicense dl = new DrivingLicense(1,"ka06 12345678901", "saikumar", d, "Banglore", fd, td, 7683991135L, str);
////
////		assertEquals("dl Updated", dlServiceImpl.update(dl));
////
////	}
//
//}
