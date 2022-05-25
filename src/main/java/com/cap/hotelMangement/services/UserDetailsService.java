package com.cap.hotelMangement.services;

import java.util.List;

import com.cap.hotelMangement.Model.UserDetails;

public interface UserDetailsService {
	public void addUser(UserDetails ud);
	public void updateUserDetails(UserDetails ud);
	public List<UserDetails> listUserDetails();
	public boolean removeUserDetails(int id);
	public UserDetails checkLogin(UserDetails uc);
	public UserDetails getbyId(int id);
}
