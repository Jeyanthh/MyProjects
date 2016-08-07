package com.projectazure.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projectazure.struts.beans.ServiceBean;
import com.projectazure.service.Service;

public class ServiceAction extends ActionSupport implements ModelDriven<ServiceBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServiceBean servicebean=new ServiceBean();
	
	
	
	
	@Action(value = "addServices", results = { @Result(name = "success", location = "success.page", type = "tiles") })
	public String addServices() {
		Service service=new Service();
		service.addService(servicebean);
		return "success";
	}
	
	public ServiceBean getModel() {
		// TODO Auto-generated method stub
		return servicebean;
	}

}
