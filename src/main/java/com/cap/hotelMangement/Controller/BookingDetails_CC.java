package com.cap.hotelMangement.Controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.hotelMangement.Model.BookingDetails;
import com.cap.hotelMangement.Model.HotelRoomDetails;
import com.cap.hotelMangement.Model.UserDetails;
import com.cap.hotelMangement.services.BookDetailsService;
import com.cap.hotelMangement.services.HotelRoomDetailsService;
import com.cap.hotelMangement.services.UserDetailsService;

@Controller
public class BookingDetails_CC {
	@Autowired
	private BookDetailsService bookDetailsService;
	@Autowired
	private HotelRoomDetailsService hotelRoomDetailsService;

	@Autowired
	private UserDetailsService userDetails;

	@PostMapping(value = "/bookHotel", produces = MediaType.ALL_VALUE)
	@ResponseBody
	public String bookHotel(@RequestParam(value = "hid", required = true) int hid,
			@RequestParam(value = "uid", required = true) String id, @ModelAttribute("booking") BookingDetails bd,
			HttpServletResponse response) {

		HotelRoomDetails hrd = hotelRoomDetailsService.getbyId(hid);
		UserDetails ud = userDetails.getbyId(id);
		System.out.println("-->" + hrd.getHeading() + hrd.getCost());
		bd.setHotelRoomDetails(hrd);
		bd.setUserdetails(ud);
		bd.setBookeedtime(new Timestamp(new Date().getTime()));
		bd.setDescrp(ud.getUsername() + " Booked this Room");

		bookDetailsService.add(bd);
		response.setStatus(HttpServletResponse.SC_OK);
		return "{'state':'Booked'}";
	}

	@PostMapping(value = "/deleteBooking", produces = MediaType.ALL_VALUE)
	@ResponseBody
	public String DeleteBooking(@RequestParam(value = "id", required = true) int id, HttpServletResponse response) {

		boolean value = bookDetailsService.updateCancelStatus(id);
		response.setStatus(HttpServletResponse.SC_OK);
		return "done :" + value;
	}

	@PostMapping(value = "/updateBooking", produces = MediaType.ALL_VALUE)
	@ResponseBody
	public String updateBooking(@ModelAttribute("BookingDeatails") BookingDetails bookingDetails,
			HttpServletResponse response) {

		System.out.println(bookingDetails.getFromDate() + "-->" + bookingDetails.getToDate()+"-->"+bookingDetails.getCancled());
		boolean value = bookDetailsService.updateBookingDetails(bookingDetails);
		response.setStatus(HttpServletResponse.SC_OK);
		return "done :" + value;
	}

}
