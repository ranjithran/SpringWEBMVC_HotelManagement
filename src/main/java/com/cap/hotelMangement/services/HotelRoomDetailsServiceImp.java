package com.cap.hotelMangement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.hotelMangement.DAO.HotelRoomDetails_DAO;
import com.cap.hotelMangement.Model.HotelRoomDetails;

@Service
@Transactional
public class HotelRoomDetailsServiceImp implements HotelRoomDetailsService{

	@Autowired
	HotelRoomDetails_DAO hoteDetails_DAO;
	@Override
	public void add(HotelRoomDetails hrd) {
		hoteDetails_DAO.add(hrd);
		
	}

	@Override
	public List<HotelRoomDetails> getAll() {
		return hoteDetails_DAO.getAll();
	}

	@Override
	public boolean deleteById(int id) {
		if (hoteDetails_DAO.deleteById(id))
			return true;

		return false;

	}

	@Override
	public HotelRoomDetails getbyId(int id) {
		
		return hoteDetails_DAO.getbyId(id);
	}

	@Override
	public boolean updateById(HotelRoomDetails hrd) {
		
		return hoteDetails_DAO.updateById(hrd);
	}
	
}
