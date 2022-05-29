package com.cap.hotelMangement.DAO;

import java.util.List;

import com.cap.hotelMangement.Model.BookingDetails;
import com.cap.hotelMangement.Model.UserDetails;

public interface BookingDetails_DAO {
	public void add(BookingDetails bd);
	public List<BookingDetails> getAll();
	public List<BookingDetails> getByUserId(UserDetails ud);
	public boolean updateCancelStatus(int id);
	public boolean updateBookingDetails(BookingDetails details);
}
