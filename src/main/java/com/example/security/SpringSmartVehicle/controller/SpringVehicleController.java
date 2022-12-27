
package com.example.security.SpringSmartVehicle.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.security.SpringSmartVehicle.Service.DLService;
import com.example.security.SpringSmartVehicle.Service.EmailServiceImpl;
import com.example.security.SpringSmartVehicle.Service.PoliceService;
import com.example.security.SpringSmartVehicle.Service.SendMailImpl;
import com.example.security.SpringSmartVehicle.Service.UserService;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.Police;
import com.example.security.SpringSmartVehicle.entity.User;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;

@Controller
public class SpringVehicleController {

	@Autowired
	private DLService dlService;

	@Autowired
	private UserService userService;

	@Autowired
	private PoliceService policeService;
	
	private SendMailImpl sendMailImpl;
	
	private EmailServiceImpl emailServiceImpl;

	public static final String ACCOUNT_SID = "AC81b1658cefbeaa45d1e39cfabef3d5d2";
	public static final String AUTH_TOKEN = "4a91ba4d67ddde94a9d8cc8bd8dda21c";

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@PostMapping("/admin")
	public ModelAndView admin(@RequestParam String username, @RequestParam String pass, Model model) throws Exception {
		if (username.equals("admin") && (pass.equals("admin"))) {
			ModelAndView mv = new ModelAndView("redirect:/createdl");
			return mv;

		} else {
			ModelAndView mv = new ModelAndView();
			model.addAttribute("fail", "Invalid UserName or Password");
			return mv;
		}

	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/faq")
	public String faq() {
		return "faq";
	}

	@GetMapping("/aboutus")
	public String aboutUs() {
		return "aboutus";
	}

	@GetMapping("/createdl")
	public String dl() {
		return "createdl";
	}
	
	

	// To Create DL
	@PostMapping("/createdl")
	public ModelAndView newDLRegister(@ModelAttribute DrivingLicense dl, @ModelAttribute User user, Model model)
			throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/dllist");
		boolean dlno = dlService.checkdlno(dl);
		boolean dldob = dlService.DOBvalidation(dl);
		boolean userphno=userService.checkIfPhoneNumberExist(user.getMobNo());
		if (dlno) {
			if(userphno==false){
			if (dldob) {

				dl.setFromDate(LocalDate.now());
				dl.setToDate(dl.getFromDate().plusYears(20));
				model.addAttribute("todate", dl.getToDate());
				dlService.createDL(dl);
				
				user.setMobNo(user.getMobNo());
				user.setDrivingLicense(dl);

				userService.createUser(user);

				System.out.println("age validated");
				return mv;
			} else {

				model.addAttribute("fail", "Age must above 18 Years");
				ModelAndView mv1 = new ModelAndView("/createdl");
				return mv1;
			}
			}
			else{
				model.addAttribute("fail", "Phone number already exist");
				ModelAndView mv1 = new ModelAndView("/createdl");
				return mv1;
			}
		}

		else {

			model.addAttribute("fail", "DL number already exist");
			ModelAndView mv1 = new ModelAndView("/createdl");
			return mv1;
		}

	}

	@GetMapping("/updatedl/{id}")
	// @ResponseBody
	public String updateDL(@PathVariable("id") int id, Model model) {
		DrivingLicense d = dlService.getById(id);
		User u = userService.findUserBydl(d);
		model.addAttribute("dl", dlService.getById(id));
		model.addAttribute("phno", u.getMobNo());
		return "/updatedl";
	}

	// To list the Updated Dl Information.
	@PostMapping("/updatedl/{id}")
	public ModelAndView saveUpdatedl(@PathVariable("id") int id, @ModelAttribute DrivingLicense dl,
			@ModelAttribute User user) throws Exception {
		ModelAndView view = new ModelAndView("redirect:/updateddllist");

		dlService.update(dl);

		userService.userUpdate(user.getMobNo(), id);
		return view;
	}

	@GetMapping("/updateddllist")
	public String dllist(Model model) {

		model.addAttribute("dl", dlService.getAll());
		model.addAttribute("user", userService.getAll());
		return "updateddllist";
	}

	@GetMapping("/userlogin")
	public String user() {
		return "/userlogin";
	}

	@PostMapping("/userlogin")
	public ModelAndView login(@ModelAttribute DrivingLicense dl, User user, ModelMap model)
			throws NullPointerException {
		try {

			if (Long.valueOf(user.getMobNo()) == null) {
				model.addAttribute("enter", "enter Phone NUmber");
				ModelAndView mv = new ModelAndView("/userlogin");
				return mv;
			}
			// User can only login if the dlno and Password Matches.
			System.out.println(user.getMobNo());
			dl =userService.findUserByMobileNumber(user.getMobNo()).getDrivingLicense();
			
			System.out.println(dl);
			if (dl.getToDate().compareTo(LocalDate.now()) > 0) {

				System.out.println("User Page Requested");

				int id =dl.getId();
				System.out.println(id);
				ModelAndView mv = new ModelAndView("redirect:/vehicleType/" + id);
				mv.addObject("mobno", user.getMobNo());
				return mv;
			} else {
				model.addAttribute("fail", "Validity Expired ");
				ModelAndView mv = new ModelAndView("/userlogin");
				return mv;
			}
		} catch (NullPointerException e) {
			model.addAttribute("fail", "login failed");
			ModelAndView mv = new ModelAndView("/userlogin");
			return mv;
		}
	}

	@GetMapping("/GenerateOTP")
	public String Generate() {
		return "/GenerateOTP";
	}

	@PostMapping("/GenerateOTP")
	public String Generated(Model model, @ModelAttribute User user) throws NullPointerException, ApiException {

		try {
			System.out.println(LocalDate.now());
			 userService.findUserByMobileNumber(user.getMobNo());
			DrivingLicense d = userService.findUserByMobileNumber(user.getMobNo()).getDrivingLicense();
			System.out.println(d);
			if (userService.checkIfPhoneNumberExist(user.getMobNo()) == true) {
				System.out.println(d.getToDate());
				if (d.getToDate().compareTo(LocalDate.now()) > 0) {

					int id = d.getId();
					System.out.println(id);
					model.addAttribute("mob", user.getMobNo());
					int otp = dlService.generateOTP();
					System.out.println(otp);
					model.addAttribute("otp", otp);

					Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

					Message message = Message.creator(new com.twilio.type.PhoneNumber("+91" + user.getMobNo()),
							new com.twilio.type.PhoneNumber("+12058508975"),
							otp + " is the OTP(One time Password) to authenticate your drive").create();

					System.out.println("MESSAGE SENT");
					System.out.println(message.getSid());

					return "/GenerateOTP";
				}

				else {

					model.addAttribute("fail", "Validity is Expired");
					System.out.println(" Validity is Expired");
					return "userlogin";
				}
			}

		} catch (NullPointerException e) {
			model.addAttribute("fail", "Dl is not issued for this Number");
			System.out.println("Dl is not issued for this Number");
			return "userlogin";
		} catch (ApiException e) {
			model.addAttribute("fail", "Number is not verified by Twillio");
			System.out.println("Number is not verified by Twillio");
			return "userlogin";
		}
		return "redirect:/userlogin";
	}

	@GetMapping("/vehicleType/{id}")
	public String update(@PathVariable("id") int id, Model model, @RequestParam String mobno) {
		ModelAndView mv = new ModelAndView();
	
		DrivingLicense d = userService.findUserByMobileNumber(mobno).getDrivingLicense();
		mv.setViewName("vehicleType");
		String[] veh = d.getVehicle();
		model.addAttribute("dl", veh);
		return "/vehicleType";
	}

	// To select the Type of Vehicle The User wish to Drive.
	@PostMapping("/vehicleType/{id}")
	public String update() {
		return "redirect:/allowAccess/{id}";

	}

	@GetMapping("/allowAccess/{id}")
	public String allowAccess(@PathVariable("id") int id) {
		return "allowAccess";
	}

	// while driving a Vehicle, If Accident happens The police want to know the
	// identity of user using userid.
	@PostMapping("/allowAccess/{id}")
	public ModelAndView AllowAccess(@PathVariable("id") int id, User user, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/police/{id}");
		DrivingLicense dr =dlService.findDlById(id);

		Police police = new Police();
		police.setAddress(dr.getAddress());
		policeService.ProvideUserIdentity(police);
		System.out.println(police.getDlno());
		model.addAttribute("police", police);
		return mv;
	}

	// If the User Not Allowed To Drive a Vehicle
	@GetMapping("/accessDenied")
	public String acessDeniedfordl() {
		return "accessDenied";
	}

	@GetMapping("/dllist")
	public String list(Model model) {
		System.out.println("List Of DL");

		model.addAttribute("dl", dlService.getAll());
		return "dllist";
	}

	@GetMapping("/police/{id}")
	public String PoliceNotified(@PathVariable("id") int id, User user, Model model) {
		DrivingLicense dr = dlService.findDlById(id);
		User u = userService.findUserBydl(dr);
		Police p = new Police();
		p.setDlno(dr.getDlno());
		p.setAddress(dr.getAddress());
		p.setDateofBirth(dr.getDateofBirth());
		p.setName(dr.getName());
		p.setPhonenumber(u.getMobNo());

		model.addAttribute("phno", p.getPhonenumber());
		model.addAttribute("name", p.getName());
		model.addAttribute("address", p.getAddress());
		model.addAttribute("dob", p.getDateofBirth());
		model.addAttribute("dlno", p.getDlno());
		return "police";
	}

	@PostMapping("/police/{id}")
	public String police(@PathVariable("id") int id) {
		return "police";
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(){
		emailServiceImpl.SendMail("smartvehicle002@gmail.com", "smartrto123@gmail.com", "PASSWORD RECOVERY", "xyz");
		return "forgotPassword";
	}

}