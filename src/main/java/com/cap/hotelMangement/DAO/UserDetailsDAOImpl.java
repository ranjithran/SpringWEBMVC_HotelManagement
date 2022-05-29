package com.cap.hotelMangement.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.hotelMangement.Model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetails_DAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private All_IN_OneDAOImp<UserDetails> all_IN_OneDAOImp;

	@Override
	public void addUser(UserDetails ud) {
		all_IN_OneDAOImp.add(ud);
	}

	@Override
	public void updateUserDetails(UserDetails ud) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(ud);
		session.saveOrUpdate(ud);

	}

	@Override
	public List<UserDetails> listUserDetails() {

		Session session = this.sessionFactory.getCurrentSession();
		List<UserDetails> uds = session.createQuery("from UserDetails where isuser=true", UserDetails.class).getResultList();
		return uds;
	}

	@Override
	public boolean removeUserDetails(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails ud = session.get(UserDetails.class, email);
		if (ud == null)
			return false;
		session.delete(ud);
		return true;
	}

	@Override
	public UserDetails getByUsrnameandpassword(UserDetails ud) {
		Session session = this.sessionFactory.getCurrentSession();

		Query<UserDetails> query = session
				.createQuery("from UserDetails	 where email=:usrname and password=:pass", UserDetails.class);
		query.setParameter("usrname", ud.getEmail());
		query.setParameter("pass", ud.getPassword());
		System.out.println("--->" + query);
		List<UserDetails> uds = query.list();

		if (uds.size() > 0) {
			for (UserDetails userDetails : uds) {
				if (userDetails.getEmail().equals(ud.getEmail())
						&& userDetails.getPassword().equals(ud.getPassword())) {
					return userDetails;

				}
			}
		}
		return null;
	}

	@Override
	public UserDetails getbyId(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails ud = session.get(UserDetails.class, id);
		return ud;
	}

}
