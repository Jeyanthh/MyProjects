package com.projectazure.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.projectazure.hibernate.beans.TourBooking;
import com.projectazure.hibernate.beans.TourPackage;
import com.projectazure.hibernate.beans.VehicleBean;

public class ClerkDao {
	
	
	/*public List getTypeSelectedVehicles(String vehicleType) {
	
	private static Logger logger = Logger.getLogger(DealerDAO.class);
	public List getTypeSelectedVehicles(String vehicleType) {
		
		logger.info("Transaction begins to get selected vehicles");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<VehicleBean> vehicleList = new ArrayList<VehicleBean>();
	    vehicleList = session.createQuery( "from VehicleBean").list();
	    List<VehicleBean> selectedVehicleList = new ArrayList<VehicleBean>();
	    for (Iterator iterator = vehicleList.iterator(); iterator
				.hasNext();) {
			VehicleBean vehicleBean = (VehicleBean) iterator.next();
			if(vehicleBean.getVehicleType().compareTo(vehicleType)==0)
			{
				selectedVehicleList.add(vehicleBean);
			
			}
			
		}
	    
		session.getTransaction().commit();
		session.close();
		logger.info("Transaction to get selected vehicles is closed");
		return selectedVehicleList;
	}*/
	
	
	public String getPackageType(int packageId) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		 TourPackage tourPackage= (TourPackage)session.get(TourPackage.class,packageId);
		 session.close();
		 return tourPackage.getPackageType();
		 
	}
	
}
