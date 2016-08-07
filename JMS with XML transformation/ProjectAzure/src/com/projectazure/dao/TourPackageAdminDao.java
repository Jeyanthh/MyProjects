package com.projectazure.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.projectazure.hibernate.beans.TourPackage;
import com.projectazure.service.TourPackageService;
import com.projectazure.struts.beans.TourAddPackage;






public class TourPackageAdminDao {
	
	private static Logger logger = Logger.getLogger(TourPackageAdminDao.class);
	SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session = sf.openSession();
   
   
	public boolean addPackage(TourPackage tourPackage) {
		logger.info("Transaction begins to add package");
		
		// TODO Auto-generated method stub
      boolean result=false;
		try{
         session.beginTransaction();
  
        session.save(tourPackage);
        
    	session.getTransaction().commit();
        session.close();
        return true;
        
		}
		catch (Exception e) {
			// TODO: handle exception
			
			logger.info("Transaction to add package is closed");
		return result;
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<TourAddPackage> retrieveTourPackage(){
		logger.info("Transaction begins to retrieve tour package");
		
		session.beginTransaction();
	     List<TourPackage> tourPackage= session.createQuery("from TourPackage").list();
	     List<com.projectazure.struts.beans.TourAddPackage> tourpack=new ArrayList<com.projectazure.struts.beans.TourAddPackage>();
	     

	    for (Iterator iterator = tourPackage.iterator(); iterator.hasNext();) {
			TourPackage tourPackage2 = (TourPackage) iterator.next();
		     com.projectazure.struts.beans.TourAddPackage tourObj=new com.projectazure.struts.beans.TourAddPackage();
			tourObj.setPackageId(tourPackage2.getPackageId());
			tourObj.setPackageName(tourPackage2.getPackageName());
			tourObj.setPackageType(tourPackage2.getPackageType());
			tourObj.setPricePerHead(tourPackage2.getPricePerHead());
			tourObj.setTourPlace(tourPackage2.getLocation());
	    	
			tourpack.add(tourObj);
			
		}
	    /* {
	    	 tourpack.add(i,tourObj);
	    	 tourpack.get(i).setPackageId(tourPackage.get(i).getPackageId());
	    	 tourpack.get(i).setPackageName(tourPackage.get(i).getPackageName());
	    	 tourpack.get(i).setPackageType(tourPackage.get(i).getPackageType());
	    	 tourpack.get(i).setPricePerHead(tourPackage.get(i).getPricePerHead());
	    	 tourpack.get(i).setLocation(tourPackage.get(i).getLocation());
	     }*/
	    logger.info("Transaction to retrieve tour package is closed");
	     return tourpack; 
	}
	
	public TourPackage getUpdatePackage(
			int packageId) {
		logger.info("Transaction begins to retrieve update tour package form");
		// TODO Auto-generated method stub
		session.beginTransaction();
		
		 TourPackage tourPackage= (TourPackage)session.get(TourPackage.class,packageId);
		/*TourAddPackage packagetour= new TourAddPackage();
		packagetour.setPackageId(tourPackage.getPackageId());
		packagetour.setPackageName(tourPackage.getPackageName());
		packagetour.setPackageType(tourPackage.getPackageType());
		packagetour.setTourPlace(tourPackage.getLocation());
		packagetour.setPricePerHead(tourPackage.getPricePerHead());*/
		 logger.info("Transaction to retrieve update tour package form is closed");
		return tourPackage;
	}
	public void updatePackage(TourPackage tourpackage) {
		
		logger.info("Transaction begins to update tour package ");
		// TODO Auto-generated method stub
		session.beginTransaction();
		TourPackage packagetour=(TourPackage) session.get(TourPackage.class,tourpackage.getPackageId());
		packagetour.setPackageId(tourpackage.getPackageId());
		packagetour.setPackageName(tourpackage.getPackageName());
		packagetour.setPackageType(tourpackage.getPackageType());
		packagetour.setLocation(tourpackage.getLocation());
		packagetour.setPricePerHead(tourpackage.getPricePerHead());
		session.update(packagetour);
		System.out.println("Updated");
		session.getTransaction().commit();
		session.close();
		logger.info("Transaction to update tour package is closed");
		 
	}
	public void deletePackage(Integer packageId) {
		// TODO Auto-generated method stub
		logger.info("Transaction begins to delete tour package ");

		session.beginTransaction();
		TourPackage tourbean = (TourPackage) session.get(TourPackage.class, packageId);
		session.delete(tourbean);

		session.getTransaction().commit();
		session.close();

		logger.info("Transaction to delete tour package is closed");

	}
	
	public List<TourAddPackage> retrievePackageName() {
		logger.info("Transaction begins to retrieve tour package ");
		// TODO Auto-generated method stub
		session.beginTransaction();
	     List<TourPackage> tourPackage= session.createQuery("from TourPackage").list();
	     List<com.projectazure.struts.beans.TourAddPackage> tourpack=new ArrayList<com.projectazure.struts.beans.TourAddPackage>();
	     List<TourPackage> packageTour=new ArrayList<TourPackage>();

	    for (Iterator iterator = tourPackage.iterator(); iterator.hasNext();) {
			TourPackage tourPackage2 = (TourPackage) iterator.next();
		     com.projectazure.struts.beans.TourAddPackage tourObj=new com.projectazure.struts.beans.TourAddPackage();
			tourObj.setPackageId(tourPackage2.getPackageId());
			tourObj.setPackageName(tourPackage2.getPackageName());
			
	    	
			tourpack.add(tourObj);
			logger.info("Transaction to retrieve tour package is closed");	
		}
	   
	     return tourpack; 

	}
	public List<TourAddPackage> viewTourPackage() {
		logger.info("Transaction begins to view tour package ");
	
		session.beginTransaction();
	     List<TourPackage> tourPackage= session.createQuery("from TourPackage").list();
	     List<com.projectazure.struts.beans.TourAddPackage> tourpack=new ArrayList<com.projectazure.struts.beans.TourAddPackage>();
	     

	    for (Iterator iterator = tourPackage.iterator(); iterator.hasNext();) {
			TourPackage tourPackage2 = (TourPackage) iterator.next();
		     com.projectazure.struts.beans.TourAddPackage tourObj=new com.projectazure.struts.beans.TourAddPackage();
			tourObj.setPackageId(tourPackage2.getPackageId());
			tourObj.setPackageName(tourPackage2.getPackageName());
			tourObj.setPackageType(tourPackage2.getPackageType());
			tourObj.setPricePerHead(tourPackage2.getPricePerHead());
			tourObj.setTourPlace(tourPackage2.getLocation());
	    	
			tourpack.add(tourObj);
	    }logger.info("Transaction to  view tour package is closed");
			 return tourpack; 

	}
	public List<TourAddPackage> viewPackageId(int packageId) {
		logger.info("Transaction begins to view package ID ");
		
		session.beginTransaction();
	     List<TourPackage> tourPackage= session.createQuery("from TourPackage").list();
	     List<com.projectazure.struts.beans.TourAddPackage> tourpack=new ArrayList<com.projectazure.struts.beans.TourAddPackage>();
	     List<TourPackage> packageTour=new ArrayList<TourPackage>();

	    for (Iterator iterator = tourPackage.iterator(); iterator.hasNext();) {
			TourPackage tourPackage2 = (TourPackage) iterator.next();
		     com.projectazure.struts.beans.TourAddPackage tourObj=new com.projectazure.struts.beans.TourAddPackage();
			
			tourObj.setPackageName(tourPackage2.getPackageName());
			tourObj.setPackageId(tourPackage2.getPackageId());
	    	
			tourpack.add(tourObj);
			logger.info("Transaction to  view package ID is closed");	
			
	}
	    return tourpack;
}
}
	
	

	
