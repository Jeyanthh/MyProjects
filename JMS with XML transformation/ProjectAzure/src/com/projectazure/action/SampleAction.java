package com.projectazure.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@Namespaces(value={@Namespace("/module3/customer/pages"),@Namespace("/")})
public class SampleAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "viewSample", results = {
			@Result(name = "viewSample", location = "sample.page", type ="tiles"),
			 })
	public String viewSample() {
		return "viewSample";
	}
	
	

}
