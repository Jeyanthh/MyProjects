package com.projectazure.dao;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.projectazure.hibernate.beans.TourBooking;
import com.projectazure.struts.beans.TourRequestBean;

/*
Description:In Dao Layer we save the data's succesfully in session for all manipulations done and are executed successfully
*/

@SuppressWarnings("deprecation")
public class UserDao {
	
	private static Logger logger = Logger.getLogger(UserDao.class);
	
	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session = sf.openSession();
	
	@SuppressWarnings("unchecked")
	public List<TourBooking> viewAllBookedPackages(){
		
		logger.info("Transaction begins to view all booked packages");
		
		session.beginTransaction();
	    
		List<TourBooking> bookList = new ArrayList<TourBooking>();
	    bookList = session.createQuery( "from TourBooking").list();
		
	    session.getTransaction().commit();
	    session.close();
	    logger.info("Transaction to view all booked packages is closed");
	    return bookList;
	    
	    }
	
	

	public TourRequestBean viewUpdatePackage(int tpBookId) {
		
		logger.info("Transaction begins to view the booked package to be updated");
		session.beginTransaction();
	    
		TourBooking updateBean =(TourBooking) session.get(TourBooking.class,
				tpBookId);
	    
	    TourRequestBean tpRequest = new TourRequestBean();
	    tpRequest.setTpBookId(updateBean.getTpBookId());
	    tpRequest.setUserId(updateBean.getUserId());
	    tpRequest.setPackageId(updateBean.getTourPackage().getPackageId());
	    Date utilDate=new java.sql.Date(updateBean.getDateofTravel().getTime());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String text=sdf.format(utilDate );
	    tpRequest.setDateofTravel(text);
	    tpRequest.setPassengerCount(updateBean.getPassengerCount());
	    tpRequest.setRequirements(updateBean.getRequirements());
	    tpRequest.setAvailDiscount(updateBean.getAvailDiscount()); 
	    session.getTransaction().commit();
	    session.close();
	    logger.info("Transaction to view the booked packages is closed");
	    
	    
		return tpRequest;
	    
	    }



	public void updateBookedPackage(TourBooking tpallocation , int id) {
	
		
		session.beginTransaction();
		
		TourBooking oldBean =(TourBooking) session.get(TourBooking.class,
				tpallocation.getTpBookId());
		oldBean.setUserId(tpallocation.getUserId());
		oldBean.getTourPackage().setPackageId(id);
		oldBean.setTpBookId(tpallocation.getTpBookId());
		oldBean.setPassengerCount(tpallocation.getPassengerCount());
		oldBean.setRequirements(tpallocation.getRequirements());
		oldBean.setAvailDiscount(tpallocation.getAvailDiscount());
		oldBean.setDateofTravel(tpallocation.getDateofTravel());
		session.update(oldBean);
		System.out.println("Updated");
		session.getTransaction().commit();
		session.close();
		 logger.info("Transaction to update booked packages is closed");
		
		}



	public void deleteBookedPackage(int tpBookId) {
	
		
		logger.info("Transaction begins to delete the booked package");
		session.beginTransaction();
		
		TourBooking deleteBean =(TourBooking) session.get(TourBooking.class,
				tpBookId);
		session.delete(deleteBean);

		session.getTransaction().commit();
		session.close();

		logger.info("Transaction  to delete the booked package is closed");
		
	}



	public List<TourBooking> generateReport(int menu) {
		// TODO Auto-generated method stub
		logger.info("Transaction begins to generate report");
		session.beginTransaction();
	   
	    
			Query query = session
					.createQuery("FROM TourBooking WHERE packageId=:menu ");

			query.setParameter("menu", menu);
	
		List results = query.list();
		
		session.getTransaction().commit();
		session.close();
		logger.info("Transaction to generate report is closed");
		return results;
	}
}
	 
	    
	  
