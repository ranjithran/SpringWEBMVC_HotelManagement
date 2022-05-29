package com.cap.hotelMangement.DAO;

import java.util.List;

import com.cap.hotelMangement.Model.HotelRoomDetails;


public interface HotelRoomDetails_DAO {
	public void add(HotelRoomDetails hrd);

	public List<HotelRoomDetails> getAll();

	public boolean deleteById(int id);
	public HotelRoomDetails getbyId(int id);
	public boolean updateById(HotelRoomDetails hrd);
}
