//package com.example.security.SpringSmartVehicle.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.context.properties.bind.BindException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.security.SpringSmartVehicle.Service.AdminService;

package com.example.security.SpringSmartVehicle.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.security.SpringSmartVehicle.Repository.DLRepo;
import com.example.security.SpringSmartVehicle.Service.AdminService;
import com.example.security.SpringSmartVehicle.Service.DLService;
import com.example.security.SpringSmartVehicle.Service.PoliceService;
import com.example.security.SpringSmartVehicle.entity.Admin;
import com.example.security.SpringSmartVehicle.entity.DrivingLicense;
import com.example.security.SpringSmartVehicle.entity.Police;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Controller
public class SpringVehicleController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private DLService dlService;

	@Autowired
	private DLRepo dlRepo;

	@Autowired
	private PoliceService policeService;

	public static final String ACCOUNT_SID = "AC81b1658cefbeaa45d1e39cfabef3d5d2";
	public static final String AUTH_TOKEN = "86d1aaee79d58701be43f540ab51b6fa";

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@PostMapping("/admin")
	public ModelAndView admin(@ModelAttribute Admin admin, Model model) throws Exception {

		if (adminService.loginValidator(admin.getUsername()) == 1) {
			ModelAndView mv = new ModelAndView("redirect:/createdl");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		model.addAttribute("fail", "login failed");
		return mv;

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
	public ModelAndView newDLRegister(@ModelAttribute DrivingLicense dl, Model model) throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/dllist");
		dl.setToDate(dl.getFromDate().plusYears(20));
		model.addAttribute("todate", dl.getToDate());
		dlService.createDL(dl);
		return mv;
	}

	@GetMapping("/updatedl/{id}")
	// @ResponseBody
	public String updateDL(@PathVariable("id") int id, Model model) {

		model.addAttribute("dl", dlService.getById(id));

		return "/updatedl";
	}

	// To list the Updated Dl Information.
	@PostMapping("/updatedl/{id}")
	public ModelAndView saveUpdatedl(@PathVariable("id") int id, @ModelAttribute DrivingLicense dl) {
		ModelAndView view = new ModelAndView("redirect:/updateddllist");
		dlService.update(dl);
		return view;
	}

	@GetMapping("/updateddllist")
	public String dllist(Model model) {
		System.out.println("List Of DL");

		System.out.println(dlService.getAll());
		model.addAttribute("dl", dlService.getAll());
		return "updateddllist";
	}

	@GetMapping("/userlogin")
	public String user() {
		return "/userlogin";
	}

	@PostMapping("/userlogin")
	public ModelAndView login(@ModelAttribute DrivingLicense dl, ModelMap model) throws NullPointerException {
		try {

			if (Long.valueOf(dl.getMobNo()) == null) {
				model.addAttribute("enter", "enter Phone NUmber");
				ModelAndView mv = new ModelAndView("/userlogin");
				return mv;
			}
			// User can only login if the dlno and Password Matches.
			System.out.println(dl.getMobNo());
			dl = dlRepo.findBymobNo(dl.getMobNo());
			System.out.println(dl);
			if (dl.getToDate().compareTo(LocalDate.now()) > 0) {

				System.out.println("User Page Requested");

				int id = dlService.getIdByMobNo(dl.getMobNo());
				System.out.println(id);
				ModelAndView mv = new ModelAndView("redirect:/vehicleType/" + id);
				mv.addObject("mobno", dl.getMobNo());
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
	public String Generate(Model model, @ModelAttribute DrivingLicense d) {
		//
		return "redirect:/GenerateOTP";
	}

	@PostMapping("/GenerateOTP")
	public String Generated(Model model, @ModelAttribute DrivingLicense dl) {
		System.out.println(dl.getMobNo());

		int id = dlService.getIdByMobNo(dl.getMobNo());
		System.out.println(id);
		model.addAttribute("mob", dl.getMobNo());
		// ModelAndView mv = new ModelAndView("redirect:/vehicleType/" + id);
		int otp = dlService.generateOTP();
		System.out.println(otp);
		model.addAttribute("otp", otp);
		// return "redirect:/vehicleType/" + id;

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new com.twilio.type.PhoneNumber("+91" + dl.getMobNo()),
				new com.twilio.type.PhoneNumber("+12058508975"), "otp is: " + otp).create();

		System.out.println("MESSAGE SENT");
		System.out.println(message.getSid());

		return "/GenerateOTP";
	}

	@GetMapping("/vehicleType/{id}")
	public String update(@PathVariable("id") int id, Model model, @ModelAttribute DrivingLicense dl) {
		ModelAndView mv = new ModelAndView();

		DrivingLicense dr = dlRepo.findById(id);

		DrivingLicense d = dlRepo.findBymobNo(dr.getMobNo());
		mv.setViewName("vehicleType");
		String[] veh = d.getVehicle();
		model.addAttribute("dl", veh);

		return "/vehicleType";
	}

	// To select the Type of Vehicle The User wish to Drive.
	@PostMapping("/vehicleType/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute DrivingLicense dl, Model model) {
		// ModelAndView mv1 = new ModelAndView("redirect:/userlogin");
		DrivingLicense dr = dlRepo.findById(id);

		DrivingLicense d = dlRepo.findBymobNo(dr.getMobNo());
		String[] veh = d.getVehicle();
		// The user is allow to Drive a Selected Vehicle if and only if the dl
		// is issued for that Vehicle Type.
		// for (String element : veh) {
		// if (element.equals(d.getVehicle())) {
		// flag = 1;
		// }
		// }
		//
		// if(flag==1){
		// System.out.println("Allow to drive");
		return "redirect:/allowAccess/{id}";
		// }
		// else{
		// System.out.println("notallow");
		// return "redirect:/accessDenied";
		// }
	}

	@GetMapping("/allowAccess/{id}")
	public String allowAccess(@PathVariable("id") int id) {
		return "allowAccess";
	}

	// while driving a Vehicle, If Accident happens The police want to know the
	// identity of user using userid.
	@PostMapping("/allowAccess/{id}")
	public ModelAndView AllowAccess(@PathVariable("id") int id, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/police/{id}");
		DrivingLicense dr = dlRepo.findById(id);
		DrivingLicense dl = dlRepo.findBymobNo(dr.getMobNo());
		Police police = new Police();
		police.setAddress(dl.getAddress());
		policeService.ProvideUserIdentity(police);
		System.out.println(police.getDlno());
		model.addAttribute("police", police);
		return mv;
	}

	private boolean checkIfDlnoExist(String dlno, String name) {
		DrivingLicense dl = dlRepo.findByDlno(dlno);
		if (dl.getDlno().equals(dlno) && dl.getName().equals(name))
			return true;
		else {
			return false;
		}

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
	public String PoliceNotified(@PathVariable("id") int id, Model model) {
		System.out.println("information of user");
		DrivingLicense dr = dlRepo.findById(id);
		DrivingLicense dl = dlRepo.findBymobNo(dr.getMobNo());
		Police p = new Police();
		p.setDlno(dl.getDlno());
		p.setAddress(dl.getAddress());
		p.setDateofBirth(dl.getDateofBirth());
		p.setName(dl.getName());
		p.setPhonenumber(dl.getMobNo());

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

}