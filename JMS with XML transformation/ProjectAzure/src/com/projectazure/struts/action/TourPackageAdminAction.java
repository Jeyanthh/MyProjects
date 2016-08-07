package com.projectazure.struts.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projectazure.service.TourPackageService;
import com.projectazure.struts.beans.TourAddPackage;
import com.projectazure.struts.beans.TourPackage;
@Namespaces(value={@Namespace("/module3/admin/pages"),@Namespace("/")})
public class TourPackageAdminAction extends ActionSupport implements ModelDriven<TourAddPackage>,SessionAware {
    
	private static final long serialVersionUID = 1L;
	TourPackageService service=new TourPackageService();
     TourAddPackage addpack=new TourAddPackage();
     public String selectpackageId;
     String select;
     
  

	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public TourAddPackage getAddpack() {
		return addpack;
	}
	public void setAddpack(TourAddPackage addpack) {
		this.addpack = addpack;
	}
	public String getSelectPackageId() {
		return selectpackageId;
	}
	public void setSelectPackageId(String selectpackageId) {
		this.selectpackageId = selectpackageId;
	}
	public TourAddPackage getUpdateObject() {
		return updateObject;
	}
	public void setUpdateObject(TourAddPackage updateObject) {
		this.updateObject = updateObject;
	}

	TourAddPackage updateObject=new TourAddPackage();
     
    

	List<TourAddPackage> tourList = new ArrayList<TourAddPackage>();
    

	public List<TourAddPackage> getTourList() {
		return tourList;
	}
	public void setTourList(List<TourAddPackage> tourList) {
		this.tourList = tourList;
	}

	private Map sessionMap;
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TourPackageService getService() {
		return service;
	}
	public void setService(TourPackageService service) {
		this.service = service;
	}
	
	
	public Map getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

     String message = new String();
	@Action(value = "addTourPackage", results = {
			@Result(name = "success", location = "AllTourPackage.page",type="tiles" ),
			@Result(name = "failure", location = "AllTourPackage.page" ,type="tiles") })
	public String addTourPackage() {

		try {
			service.addPackage(addpack);
			message = "TourPackage has been added successfully";
			return "success";
		} catch (Exception e) {

		}
		message = "TourPackage could not be registered due to some issues. Please check the data you have entered .";

		return "failure";
	}
	@Action(value = "ViewAddTourPackage", results = {
			@Result(name = "viewAddTourPackage", location = "AddTourPackage.page", type="tiles")
		 })
	public String ViewAddTourPackage() {

		try {
			
			return "viewAddTourPackage";
		} catch (Exception e) {

		}
		message = "TourPackage could not be registered due to some issues. Please check the data you have entered .";

		return "failure";
	}
	@Action(value = "ViewAllPackage", results = {
			@Result(name = "ViewAllTourPackage", location = "AllTourPackage.page", type="tiles"),
			@Result(name = "failure", location = "failure.page" ,type="tiles")
		 })
	public String ViewAllTourPackage() {

		try {
			
			
			tourList = service.retrieveTourPackage();
			sessionMap.put("tourPackageList", tourList);
			System.out.println(tourList.toString());
			
			
			return "ViewAllTourPackage";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		//message = "TourPackage could not be registered due to some issues. Please check the data you have entered .";

		
	}
	public TourAddPackage getModel() {
		// TODO Auto-generated method stub
		return addpack;
	}
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		this.sessionMap=map;
	}
	
	
	/*@Action(value = "viewUpdate", results = {
			@Result(name = "updateFormPage", location = "updateFormPage.page", type="tiles"),
			@Result(name = "failure", location = "failure.page" ,type="tiles")
		 })
	
	public String viewUpdatePackage(){
		
		System.out.println("up"+getSelectPackageId());
		int packid=Integer.parseInt(selectpackageId);
		updateObject=service.getUpdatePackage(packid);
	     sessionMap.put("updateForm", updateObject);
	    return "updateFormPage";
	
	}*/
	@Action(value = "editTourPackage", results = {
			@Result(name = "success", location = "AllTourPackage.page",type="tiles" ),
			@Result(name = "failure", location = "AllTourPackage.page" ,type="tiles") })
	public String UpdatePackage(){
		
		try{
			service.updatePackage(addpack);
			return "success";
			
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
		
		
	
	}
	
	
	/*@Action(value = "deleteAction", results = {
			@Result(name = "success", location = "AllTourPackage.page",type="tiles" ),
			@Result(name = "failure", location = "AllTourPackage.page" ,type="tiles") })
	public String delete() {
		try {
			System.out.println(selectpackageId);
			int packid=Integer.parseInt(selectpackageId);
			service.deletePackage(packid);
			return "success";
		} catch (Exception e) {
return "failure";
		}
	}*/
	
	
	@Action(value = "viewBookTourPackage", results = {
			@Result(name = "ViewTourPackage", location = "viewbookTourPackage.page", type="tiles"),
			@Result(name = "failure", location = "failure.page" ,type="tiles")
		 })
	public String ViewTourPackage() {

		try {
			
			
			tourList = service.retrieveTourPackage();
			sessionMap.put("tourPackageList", tourList);
			System.out.println(tourList.toString());
			
			return "ViewTourPackage";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
}
	@Action(value = "ViewPackageName", results = {
			@Result(name = "ViewTourPackageName", location = "TourPackageName.page", type="tiles"),
			@Result(name = "failure", location = "failure.page" ,type="tiles")
		 })
	public String viewPackageName() {

		try {
			
			
			tourList = service.retrieveTourPackageName();
			sessionMap.put("tourPackageList", tourList);
			System.out.println(tourList.toString());
			
			return "ViewTourPackageName";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
}
	
	@Action(value = "selectAction", results = {
			@Result(name = "addpackage", location = "ViewAddTourPackage", type="redirect"),
			@Result(name = "updateFormPage", location = "updateFormPage.page" ,type="tiles"),
			@Result(name = "success", location = "AllTourPackage.page" ,type="tiles")
		 })
	public String selectAction() {

		try {
			
			
			if("Add Tour Package" .equalsIgnoreCase(select)){
				return "addpackage";
			}
			else if ("Edit Tour Package".equalsIgnoreCase(select)) {
				System.out.println("up"+getSelectPackageId());
				int packid=Integer.parseInt(selectpackageId);
				com.projectazure.hibernate.beans.TourPackage tourPack=new com.projectazure.hibernate.beans.TourPackage();
				tourPack=service.getUpdatePackage(packid);
			     sessionMap.put("updateForm", tourPack);
			    return "updateFormPage";
			}
			else {
				System.out.println(selectpackageId);
				int packid=Integer.parseInt(selectpackageId);
				service.deletePackage(packid);
				return "success";}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "ViewAllPackage";
		}}
}
