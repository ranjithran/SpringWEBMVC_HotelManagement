package com.cap.hotelMangement.services;

import java.util.List;

import com.cap.hotelMangement.Model.HotelRoomDetails;

public interface HotelRoomDetailsService {
	public void add(HotelRoomDetails hrd);

	public List<HotelRoomDetails> getAll();

	public boolean deleteById(int id);
	public HotelRoomDetails getbyId(int id);
}
