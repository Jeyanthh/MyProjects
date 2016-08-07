package com.projectazure.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.projectazure.struts.beans.User;
import com.projectazure.util.HibernateUtil;



public class LoginDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public void insetUser(User user)
	{
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		
	}
}
