package com.projectazure.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projectazure.struts.beans.User;
import com.projectazure.service.Service;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	String message = new String();
	String color = new String();

	/*
	 * @Action(value = "updateCollegeAction", results = {
	 * 
	 * @Result(name = "success", location = "success.page", type = "tiles"),
	 * 
	 * @Result(name = "failure", location = "failure.page", type = "tiles") })
	 */

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/************* Sign Up Form ******************/
	@Action(value = "signup", results = { @Result(name = "signup", location = "signUp.page", type = "tiles") })
	public String signUp() {
		return "signup";
	}

	/****************** Change Password ************/

	@Action(value = "changePassword", results = { @Result(name = "changepassword", location = "changePassword.page", type = "tiles") })
	public String changePassword() {
		return "changepassword";
	}

	@Action(value = "login", results = {
			@Result(name = "login", location = "success.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	@Override
	public String execute() throws Exception {
		/* System.out.print(user.getUserName()); */
		message = user.getPassword();// /user.getUserName();
		color = "red";
		/*if(user.getUserName()==null && user.getPassword()==null)
		{
			message="enter username and password";
			return "failure";
		}
		else*/
		{
		/*if (user.getUserName().equals(user.getPassword()))*/
		Service service=new Service();
		service.insertUser(user);
		
			return "login";
		}
		/*else
			return "failure";*/

	}

	@Action(value = "cherryHome", results = { @Result(name = "cherryHome", location = "cherryHome.page", type = "tiles") })
	public String cherryHome() {
		color = "#FAC011";
		return "cherryHome";
	}

	@Action(value = "roomService", results = { @Result(name = "roomService", location = "roomService.page", type = "tiles") })
	public String roomService() {
		color = "#FAC011";
		return "roomService";
	}

	@Action(value = "inService", results = { @Result(name = "inService", location = "inService.page", type = "tiles") })
	public String inService() {
		color = "#FAC011";
		return "inService";
	}
	
	@Action(value = "addService", results = { @Result(name = "addService", location = "addService.page", type = "tiles") })
	public String addService() {
		color = "#FAC011";
		return "addService";
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Action(value = "addCollegePage", results = { @Result(name = "addCollegePage", location = "addCollege.page", type = "tiles") })
	public String addCollegePage() {
		return "addCollegePage";
	}

	@Action(value = "editCollegePage", results = { @Result(name = "editCollegePage", location = "editCollege.page", type = "tiles") })
	public String editCollegePage() {
		return "editCollegePage";
	}

	@Action(value = "deleteCollegePage", results = { @Result(name = "deleteCollegePage", location = "deleteCollege.page", type = "tiles") })
	public String deleteCollegePage() {
		return "deleteCollegePage";
	}
*/
	
	
}
