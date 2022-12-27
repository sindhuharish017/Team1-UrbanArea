
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

import com.example.security.SpringSmartVehicle.Repository.PoliceRepo;
import com.example.security.SpringSmartVehicle.Service.DLService;
import com.example.security.SpringSmartVehicle.Service.UserService;
import com.example.security.SpringSmartVehicle.Service.policeSerive;
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
	private policeSerive pservice;

	public static final String ACCOUNT_SID = "AC81b1658cefbeaa45d1e39cfabef3d5d2";
    public static final String AUTH_TOKEN = "277ec74357cead14dc7ef409aa0ec202";

	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	//Directs to the admin page
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}


	//directs to about page
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
		try {
			ModelAndView mv = new ModelAndView("redirect:/dllist");
			boolean dlno = dlService.checkdlno(dl);
			boolean dldob = dlService.DOBvalidation(dl);
			boolean userphno = userService.checkIfPhoneNumberExist(user.getMobNo());
			
			//If dl number does not exist
			if (dlno) {
				//If phone number does not exist
				if (userphno == false) {
					//If date of birth is greater than 18 years from current date
					if (dldob) {
                        //Sets the date of issue to current date
						dl.setFromDate(LocalDate.now());
						//Sets the validity date of dl
						dl.setToDate(dl.getFromDate().plusYears(20));
//						model.addAttribute("todate", dl.getToDate());
						
						//calls createdl from dl service
						dlService.createDL(dl);

						user.setMobNo(user.getMobNo());
						user.setDrivingLicense(dl);

						userService.createUser(user);

//						System.out.println("age validated");
						return mv;
					} else {
                        //displays the error message 
						model.addAttribute("fail", "Age must above 18 Years");
						ModelAndView mv1 = new ModelAndView("/createdl");
						return mv1;
					}
				} else {
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

		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("redirect:/createdl");
			System.out.println(e);
			model.addAttribute("fail", e);
			return mv;
		}
	}

	//To list the dl
	@GetMapping("/dllist")
	public String list(Model model) {
		System.out.println("List Of DL");
		model.addAttribute("dl", dlService.getAll());
		return "dllist";
	}

	//displays the dl information of the user of the specified id
	@GetMapping("/updatedl/{id}")
	// @ResponseBody
	public String updateDL(@PathVariable("id") int id, Model model) {
		DrivingLicense d = dlService.getById(id);
		User u = userService.findUserBydl(d);
		model.addAttribute("dl", dlService.getById(id));
		model.addAttribute("phno", u.getMobNo());
		return "/updatedl";
	}

	// To update the dl
	@PostMapping("/updatedl/{id}")
	public ModelAndView saveUpdatedl(@PathVariable("id") int id, @ModelAttribute DrivingLicense dl,
			@ModelAttribute User user) throws Exception {
		try {
			
			ModelAndView view = new ModelAndView("redirect:/updateddllist");
         
			dlService.update(dl);

			userService.userUpdate(user.getMobNo(), id);
			return view;
		} catch (Exception e) {
			ModelAndView view = new ModelAndView("redirect:/updatedl/{id}");
			System.out.println(e);
			return view;
		}
	}

	//To view the updated dl list
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

	// Allows user to login if dl is issued to specified phone number
	@PostMapping("/userlogin")
	public ModelAndView login(@ModelAttribute DrivingLicense dl, User user, ModelMap model)
			throws NullPointerException {
		try {
               //if phone number is not entered
			if (Long.valueOf(user.getMobNo()) == null) {
				model.addAttribute("enter", "enter Phone NUmber");
				ModelAndView mv = new ModelAndView("/userlogin");
				return mv;
			}
	
			System.out.println(user.getMobNo());
			
			dl = userService.findUserByMobileNumber(user.getMobNo()).getDrivingLicense();

			System.out.println(dl);
			//Checks whether the expiry date is greater than the current date
			if (dl.getToDate().compareTo(LocalDate.now()) > 0) {

				System.out.println("User Page Requested");

				int id = dl.getId();
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
    
	//Generates OTP if Phone number is valid
	@PostMapping("/GenerateOTP")
	public String Generated(Model model, @ModelAttribute User user) throws NullPointerException, ApiException {

		try {
			System.out.println(LocalDate.now());
			userService.findUserByMobileNumber(user.getMobNo());
			DrivingLicense d = userService.findUserByMobileNumber(user.getMobNo()).getDrivingLicense();
			System.out.println(d);
			//checks whether the dl is issued to a given phone number
			if (userService.checkIfPhoneNumberExist(user.getMobNo()) == true) {
				System.out.println(d.getToDate());
				//Checks whether the expiry date is greater than current date
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

	//Displays the vehicle type of the user 
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

	// while driving a Vehicle, If Accident happens the police gets to know the identity of user through his userid
	@PostMapping("/allowAccess/{id}")
	public ModelAndView AllowAccess(@PathVariable("id") int id,  Model model) throws Exception {
		try {

			ModelAndView mv = new ModelAndView("redirect:/police/{id}");
			User u= userService.findUserBydl(dlService.findDlById(id));
			Police police = new Police();
			police.setUser(u);
			pservice.createPolice(police);
			System.out.println(police.getUser().getId());
			model.addAttribute("police", police);
			return mv;
		} catch (Exception e) {
			ModelAndView view = new ModelAndView("redirect:/allowAccess/{id}");
			System.out.println(e);
			return view;
		}
	}

	// If the User Not Allowed To Drive a Vehicle
	@GetMapping("/accessDenied")
	public String acessDeniedfordl() {
		return "accessDenied";
	}

	
	@GetMapping("/police/{id}")
	public String PoliceNotified(@PathVariable("id") int id, Model model) {
		User u= userService.findUserBydl(dlService.findDlById(id));
		model.addAttribute("phno", u.getMobNo());
		model.addAttribute("name",u.getDrivingLicense().getName());
		model.addAttribute("address",u.getDrivingLicense().getAddress());
		model.addAttribute("dob",u.getDrivingLicense().getDateofBirth());
		model.addAttribute("dlno",u.getDrivingLicense().getDlno());
		return "police";
	}

	@PostMapping("/police/{id}")
	public String police(@PathVariable("id") int id) {
		return "police";
	}
}

































