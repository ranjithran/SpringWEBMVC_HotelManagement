package com.cap.hotelMangement.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.hotelMangement.Exception.DeleteException;
import com.cap.hotelMangement.Model.HotelRoomDetails;
import com.cap.hotelMangement.services.HotelRoomDetailsService;

@Controller
@RequestMapping("/hotelRoom")
public class HotelRoomDetails_CC {

	@Autowired
	private HotelRoomDetailsService hotelRoomDetailsService;

	@PostMapping("/addRoom")
	public String addRoom(@ModelAttribute HotelRoomDetails hrd, Model model) {

		if (hrd != null) {
			hotelRoomDetailsService.add(hrd);
			model.addAttribute("HotelRoomDetails", hotelRoomDetailsService.getAll());
			model.addAttribute("usertype", "admin");
		}
		return "AdminLanding_Page";
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

	@PostMapping(value = "/delteRoom", produces = MediaType.ALL_VALUE)
	@ResponseBody
	public String deletRoom(@RequestParam(value = "id") int id,HttpServletResponse reponse) {
		boolean value = false;
		try {
			value = hotelRoomDetailsService.deleteById(id);

		} catch (Exception e) {
			reponse.setStatus(406, "Delete bookDetails for this room");
			throw new DeleteException();
		}
		return "" + value;
	}
}
