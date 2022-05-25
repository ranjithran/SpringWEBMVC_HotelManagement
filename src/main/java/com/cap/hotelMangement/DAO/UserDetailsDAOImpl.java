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
		session.saveOrUpdate(ud);

	}

	@Override
	public List<UserDetails> listUserDetails() {

		Session session = this.sessionFactory.getCurrentSession();
		List<UserDetails> uds = session.createQuery("from UserDetails where isuser=true", UserDetails.class).getResultList();
		return uds;
	}

	@Override
	public boolean removeUserDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails ud = session.get(UserDetails.class, id);
		if (ud == null)
			return false;
		session.delete(ud);
		return true;
	}

	@Override
	public UserDetails getByUsrnameandpassword(UserDetails ud) {
		Session session = this.sessionFactory.getCurrentSession();

		Query<UserDetails> query = session
				.createQuery("from UserDetails	 where username=:usrname and password=:pass", UserDetails.class);
		query.setParameter("usrname", ud.getUsername());
		query.setParameter("pass", ud.getPassword());
		System.out.println("--->" + query);
		List<UserDetails> uds = query.list();

		if (uds.size() > 0) {
			for (UserDetails userDetails : uds) {
				if (userDetails.getUsername().equals(ud.getUsername())
						&& userDetails.getPassword().equals(ud.getPassword())) {
					return userDetails;

				}
			}
		}
		return null;
	}

	@Override
	public UserDetails getbyId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails ud = session.get(UserDetails.class, id);
		return ud;
	}

}
