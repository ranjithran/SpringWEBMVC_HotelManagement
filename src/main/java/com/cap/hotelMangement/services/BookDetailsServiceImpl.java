package com.cap.hotelMangement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.hotelMangement.DAO.BookingDetails_DAO;
import com.cap.hotelMangement.Model.BookingDetails;
import com.cap.hotelMangement.Model.UserDetails;

@Service
@Transactional
public class BookDetailsServiceImpl implements BookDetailsService {

	@Autowired
	private BookingDetails_DAO bookingDetails_DAO;
	@Override
	public void add(BookingDetails bd) {
		bookingDetails_DAO.add(bd);
	}

	@Override
	public List<BookingDetails> getAll() {
		
		return bookingDetails_DAO.getAll();
	}

	@Override
	public List<BookingDetails> getByUserId(UserDetails ud) {
		
		return bookingDetails_DAO.getByUserId(ud);
	}

	@Override
	public boolean delete(int id) {
	
		return bookingDetails_DAO.delete(id);
	}

}
