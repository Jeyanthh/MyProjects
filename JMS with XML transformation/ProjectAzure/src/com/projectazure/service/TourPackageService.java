package com.projectazure.service;

import java.util.List;

import com.projectazure.dao.TourPackageAdminDao;
import com.projectazure.hibernate.beans.TourPackage;
import com.projectazure.struts.beans.TourAddPackage;

import freemarker.core.ParseException;

public class TourPackageService {
	TourPackage tourpackage=new TourPackage();
	TourPackageAdminDao packageDao=new TourPackageAdminDao();
	

	public void addPackage(TourAddPackage addPackage) {
		// TODO Auto-generated method stub
		
		tourpackage.setPackageName(addPackage.getPackageName());
		tourpackage.setPackageType(addPackage.getPackageType());
		tourpackage.setLocation(addPackage.getTourPlace());
		tourpackage.setPricePerHead(addPackage.getPricePerHead());
		 packageDao.addPackage(tourpackage);
	}
	
public List<TourAddPackage> retrieveTourPackage()
{
	return packageDao.retrieveTourPackage();
}






public TourPackage getUpdatePackage(
		int selectPackageId) {
	// TODO Auto-generated method stub
	int packageId=selectPackageId;
	return packageDao.getUpdatePackage(packageId );
}

public void updatePackage(com.projectazure.struts.beans.TourAddPackage addpack) {
	// TODO Auto-generated method stub
	try{
		
	tourpackage.setPackageId(addpack.getPackageId());
	tourpackage.setPackageName(addpack.getPackageName());
	tourpackage.setPackageType(addpack.getPackageType());
	tourpackage.setLocation(addpack.getTourPlace());
	tourpackage.setPricePerHead(addpack.getPricePerHead());
	packageDao.updatePackage(tourpackage);
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}

public void deletePackage(Integer packageId) {
	// TODO Auto-generated method stub
	packageDao.deletePackage(packageId);
	
}

public List<TourAddPackage> viewTourPackage() {
	return packageDao.viewTourPackage();
}



public List<TourAddPackage> retrieveTourPackageName() {
	// TODO Auto-generated method stub
	return packageDao.retrievePackageName();
}

/*public int viewPackageId(int packageId) {
	
	return packageDao.viewPackageId(packageId);
	
}
*/



}



