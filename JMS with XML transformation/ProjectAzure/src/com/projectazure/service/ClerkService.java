package com.projectazure.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.projectazure.dao.ClerkDao;
import com.projectazure.dao.UserDao;
import com.projectazure.hibernate.beans.VehicleBean;
import com.projectazure.struts.beans.TourRequestBean;


public class ClerkService {
	ClerkDao dao=new ClerkDao();
	
	
	public String findVehicleType(int numberOfPassengers) {
		String vehicleType="Indica";
		if(numberOfPassengers<=4)
		{
			vehicleType="Indica";
		}
		else if (numberOfPassengers<=6) {
			vehicleType="Innova";
		}
		else{
			vehicleType="Tempo";
		}
		return vehicleType;
	}
	
	/*public void getSelectedVehicles(String vehicleType ) {
		
	List<VehicleBean> sel=	dao.getTypeSelectedVehicles(vehicleType);
	for (Iterator iterator = sel.iterator(); iterator.hasNext();) {
		VehicleBean vehicleBean = (VehicleBean) iterator.next();
		System.out.println(vehicleBean);
	}
		

	
	}*/
	
	

	
	
	public void getVehicles(int tpRequestId) {
		ClerkService clerkService=new ClerkService();
		UserDao userDao=new UserDao();
		TourRequestBean tpRequest=userDao.viewUpdatePackage(tpRequestId);
		
		
	String vehicleType=clerkService.findVehicleType(tpRequest.getPassengerCount());
	String packageType=dao.getPackageType(tpRequest.getPackageId());
	System.out.println(vehicleType);
System.out.println(packageType);
System.out.println(tpRequest.getDateofTravel());
//	clerkService.getSelectedVehicles(vehicleType);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try {
	Date convertedDateOfTravel = sdf.parse(tpRequest.getDateofTravel());
	System.out.println("Star date:  "+convertedDateOfTravel);
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(convertedDateOfTravel);
	calendar.add(Calendar.DATE, 4);
	Date endDate=calendar.getTime();
	System.out.println("end date:  " +endDate);
	
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
		
		
	}
	
	
	
}
