package com.cap.hotelMangement.DAO;

import java.util.List;

import com.cap.hotelMangement.Model.UserDetails;

public interface UserDetails_DAO {
	public void addUser(UserDetails ud);
	public void updateUserDetails(UserDetails ud);
	public List<UserDetails> listUserDetails();
	public boolean removeUserDetails(String email);
	public UserDetails getByUsrnameandpassword(UserDetails ud);
	public UserDetails getbyId(String id);
}
