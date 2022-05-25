package com.cap.hotelMangement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.hotelMangement.DAO.UserDetails_DAO;
import com.cap.hotelMangement.Model.UserDetails;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetails_DAO userDetails_DAO;

	@Override
	public void addUser(UserDetails ud) {
		userDetails_DAO.addUser(ud);

	}

	@Override
	public void updateUserDetails(UserDetails ud) {
		userDetails_DAO.updateUserDetails(ud);

	}

	@Override
	public List<UserDetails> listUserDetails() {
		List<UserDetails> uds = userDetails_DAO.listUserDetails();
		if (uds.size() == 0)
			return new ArrayList<UserDetails>();
		return uds;
	}

	@Override
	public boolean removeUserDetails(int id) {
		return userDetails_DAO.removeUserDetails(id);

	}

	@Override
	public UserDetails checkLogin(UserDetails uc) {

		UserDetails ud = userDetails_DAO.getByUsrnameandpassword(uc);
		
		if (ud == null)
			return null;

		return ud;

	}

	@Override
	public UserDetails getbyId(int id) {
		
		return userDetails_DAO.getbyId(id);
	}

}
