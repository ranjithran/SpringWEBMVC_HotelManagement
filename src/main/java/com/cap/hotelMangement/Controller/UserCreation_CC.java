package com.cap.hotelMangement.Controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cap.hotelMangement.Exception.DeleteException;
import com.cap.hotelMangement.Model.BookingDetails;
import com.cap.hotelMangement.Model.HotelRoomDetails;
import com.cap.hotelMangement.Model.UserDetails;
import com.cap.hotelMangement.services.BookDetailsService;
import com.cap.hotelMangement.services.HotelRoomDetailsService;
import com.cap.hotelMangement.services.UserDetailsService;

@Controller
@RequestMapping("/User")
public class UserCreation_CC {

	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	HotelRoomDetailsService hotelRoomDetailsService;
	@Autowired
	ApplicationContext appCxt;

	@PostMapping("/create")
	public ModelAndView createAccount(@ModelAttribute("User") UserDetails uc) {
		uc.setUser(true);
		uc.setCreatedTime(new Timestamp(new Date().getTime()));
		userDetailsService.addUser(uc);
		System.out.println(uc);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("User") UserDetails uc, HttpServletRequest request, Model model) {
		uc = userDetailsService.checkLogin(uc);
		if (uc != null) {
			model.addAttribute("userId", uc.getId());
			request.getSession().setAttribute("User", uc);
			if (uc.isAdmin()) {
				return adminLogic(model);
			} else {
				return userLogic(model, uc);
			}
		}
		model.addAttribute("error", "Worng UserName and Password");
		return "index";
	}

	@GetMapping("/CreatePage")
	public String navigateToCreatePage() {
		return "UserCreation_Page";
	}

	@PostMapping(value = "deleteUser", produces = MediaType.ALL_VALUE)
	@ResponseBody
	public String deleteUserbyId(@RequestParam(value = "id") int id) {
		Boolean value = false;
		try {
			value = userDetailsService.removeUserDetails(id);
			
		} catch (Exception e) {
			throw new DeleteException();
		}
		return "done :" + value;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@ModelAttribute
	public void addBootStrapjsandcss(Model model) {
		String css = "<link rel='stylesheet'"
				+ "href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css'"
				+ "integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3'"
				+ "crossorigin='anonymous'>";
		String js = "<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\"\r\n"
				+ "	integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>";
		model.addAttribute("bootstrapjs", js);
		model.addAttribute("bootstrapcss", css);
	}

	private String adminLogic(Model model) {
		model.addAttribute("Room", "active");
		List<HotelRoomDetails> hrds = hotelRoomDetailsService.getAll();
		BookDetailsService bookDetailsService = (BookDetailsService) appCxt.getBean(BookDetailsService.class);
		List<BookingDetails> bds = bookDetailsService.getAll();
		List<UserDetails> ud = userDetailsService.listUserDetails();
		model.addAttribute("BookingDetails", bds);
		model.addAttribute("UserDetails", ud);
		model.addAttribute("HotelRoomDetails", hrds);
		model.addAttribute("usertype", "admin");
		return "AdminLanding_Page";
	}

	private String userLogic(Model model, UserDetails ud) {

		List<HotelRoomDetails> hrds = hotelRoomDetailsService.getAll();
		BookDetailsService bookDetailsService = (BookDetailsService) appCxt.getBean(BookDetailsService.class);
		List<BookingDetails> bds = bookDetailsService.getByUserId(ud);
		model.addAttribute("BookingDetails", bds);
		model.addAttribute("HotelRoomDetails", hrds);
		model.addAttribute(ud);
		model.addAttribute("Home", "active");
		model.addAttribute("usertype", "user");
		return "UserLanding_Page";
	}
}
