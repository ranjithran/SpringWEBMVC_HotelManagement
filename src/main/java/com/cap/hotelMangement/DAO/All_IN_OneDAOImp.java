package com.cap.hotelMangement.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class All_IN_OneDAOImp<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public void add(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
	}

	
	public void update(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);

	}

//	@Override
//	public List<T> listALl() {
//
//		Session session = this.sessionFactory.getCurrentSession();
//		List<T> uds = session.createQuery("from UserDetails", T.class).getResultList();
//		return uds;
//	}
//
//	
//	public boolean removeUserDetails(int id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		UserDetails ud = session.get(UserDetails.class, id);
//		if (ud != null)
//			return false;
//		session.delete(ud);
//		return true;
//	}
//
//	@Override
//	public UserDetails getByUsrnameandpassword(UserDetails ud) {
//		Session session = this.sessionFactory.getCurrentSession();
//
//		Query<UserDetails> query = session
//				.createQuery("from UserDetails	 where username=:usrname and password=:pass", UserDetails.class);
//		query.setParameter("usrname", ud.getUsername());
//		query.setParameter("pass", ud.getPassword());
//		System.out.println("--->" + query);
//		List<UserDetails> uds = query.list();
//
//		if (uds.size() > 0) {
//			for (UserDetails userDetails : uds) {
//				if (userDetails.getUsername().equals(ud.getUsername())
//						&& userDetails.getPassword().equals(ud.getPassword())) {
//					return userDetails;
//
//				}
//			}
//		}
//		return null;
//	}

}
