package com.projectazure.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.projectazure.struts.beans.ServiceBean;
import com.projectazure.util.HibernateUtil;

public class ServiceDao {

	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public void addService(ServiceBean servicebean){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(servicebean);
		tx.commit();
		session.close();
	}
}
