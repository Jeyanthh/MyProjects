package com.projectazure.dao;



import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


import com.projectazure.hibernate.beans.TourBooking;
import com.projectazure.hibernate.beans.TourPackage;


public class TourDao {

	private static Logger logger = Logger.getLogger(TourDao.class);
	public void bookTourPackage(TourBooking tourBooking, int id) {
		
		
		
		//boolean result = false;
	
		
	SessionFactory sessionFactory =new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
		TourPackage tourPackage = (TourPackage) session.get(TourPackage.class,id);
		tourBooking.setTourPackage(tourPackage);
		session.save(tourBooking);
		session.getTransaction().commit();
		session.close();
		logger.info("Transaction to book tour package is closed");
		//return true;
		}
				
	}

	


