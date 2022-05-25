package com.cap.hotelMangement.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.hotelMangement.Model.HotelRoomDetails;

@Repository
public class HotelRoomDetails_DAOImpl implements HotelRoomDetails_DAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private All_IN_OneDAOImp<HotelRoomDetails> all_IN_OneDAOImp;

	@Override
	public void add(HotelRoomDetails hrd) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.persist(hrd);
		all_IN_OneDAOImp.add(hrd);

	}

	@Override
	public List<HotelRoomDetails> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HotelRoomDetails> hds = session
				.createQuery("from HotelRoomDetails where isbooked=false", HotelRoomDetails.class).list();
		return hds;
	}

	@Override
	public boolean deleteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		HotelRoomDetails hrd = session.get(HotelRoomDetails.class, id);
		if (hrd == null)
			return false;
		session.delete(hrd);

		return true;
	}

	@Override
	public HotelRoomDetails getbyId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		HotelRoomDetails hotel = session.get(HotelRoomDetails.class, id);
		return hotel;
	}

}
