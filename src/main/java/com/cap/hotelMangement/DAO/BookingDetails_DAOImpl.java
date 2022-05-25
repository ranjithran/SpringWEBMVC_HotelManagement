package com.cap.hotelMangement.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.hotelMangement.Model.BookingDetails;
import com.cap.hotelMangement.Model.UserDetails;

@Repository
public class BookingDetails_DAOImpl implements BookingDetails_DAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void add(BookingDetails bd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bd);
	}

	@Override
	public List<BookingDetails> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<BookingDetails> bds = session.createQuery("from BookingDetails", BookingDetails.class).list();
		return bds;
	}

	@Override
	public List<BookingDetails> getByUserId(UserDetails ud) {
		Session session = this.sessionFactory.getCurrentSession();
		Query<BookingDetails> q = session.createQuery("from BookingDetails where userdetails_id=:uid",
				BookingDetails.class);
		q.setParameter("uid", ud.getId());

		return q.list();
	}

	@Override
	public boolean delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		BookingDetails ud = session.get(BookingDetails.class, id);
		if (ud == null)
			return false;
		session.delete(ud);
		return true;

	}

}
