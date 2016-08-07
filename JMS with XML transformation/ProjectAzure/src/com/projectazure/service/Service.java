package com.projectazure.service;

import com.projectazure.struts.beans.ServiceBean;
import com.projectazure.struts.beans.User;
import com.projectazure.dao.LoginDao;
import com.projectazure.dao.ServiceDao;




public class Service {

	
	public void insertUser(User user)
	{
		LoginDao logindao=new LoginDao();
		logindao.insetUser(user);
	}
	
	
	public void addService(ServiceBean servicebean)
	{
		ServiceDao servicedao=new ServiceDao();
		servicedao.addService(servicebean);
	}
	
}
