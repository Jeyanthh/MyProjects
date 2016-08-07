package com.projectazure.struts.action;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projectazure.service.DealerService;
import com.projectazure.service.VehicleandDealerService;
import com.projectazure.struts.beans.DealerBean;

@Namespaces(value = { @Namespace("/module3/admin/pages"),
		@Namespace("/pages/module3/admin/pages"), @Namespace("/"), })
public class DealerAction extends ActionSupport implements
		ModelDriven<DealerBean>, SessionAware {

	private static final long serialVersionUID = 1L;
	
	DealerBean bean = new DealerBean();
	DealerService service = new DealerService();
	VehicleandDealerService servicedealer = new VehicleandDealerService();
	
	private Map dealerMap;
	private String dealerAction;
	
/*Getters and Setters of Map and Action*/
	public String getDealerAction() {
		return dealerAction;
	}

	public void setDealerAction(String dealerAction) {
		this.dealerAction = dealerAction;
	}

	public void setSession(Map map) {
		this.dealerMap = map;
	}

	public Map getDealerMap() {
		return dealerMap;
	}

	public void setDealerMap(Map dealerMap) {
		this.dealerMap = dealerMap;
	}

	@Action(value = "addDealer", results = { @Result(name = "addDealer", location = "addDealer.page", type = "tiles"), })
	public String addVehicle() {
		return "addDealer";
	}

	@Action(value = "updateDealers", results = { @Result(name = "updateDealers", location = "updateDealers.page", type = "tiles"), })
	public String updateDealer() {
		return "updateDealers";
	}

	@Action(value = "dealer", results = {
			@Result(name = "success", location = "/module3/admin/pages/success.jsp"),
			@Result(name = "failure", location = "/module3/admin/pages/failure.jsp") })
	public String addVehicletoDB() {
		try {
			service.addDealer(bean);
			return "success";
		} catch (Exception e) {

		}

		return "failure";
	}

	@Action(value = "updateDealer", results = {
			@Result(name = "success", location = "/module3/admin/pages/success.jsp"),
			@Result(name = "failure", location = "/module3/admin/pages/failure.jsp") })
	public String updateVehicletoDB() {
		try {
			service.updateDealer(bean, bean.getDealerId());
			return "success";
		} catch (Exception e) {

		}

		return "failure";
	}

	@Action(value = "updateForm", results = {
			@Result(name = "update", location = "updateDealers.page", type = "tiles"),
			@Result(name = "addDealer", location = "addDealer", type = "redirect"),
			@Result(name = "delete", location = "result.page" +
					"", type = "tiles"), })
	public String updateDealerForm() {

		if ("Add Dealer".equalsIgnoreCase(dealerAction)) {
			return "addDealer";
		} else if ("Update Dealer".equalsIgnoreCase(dealerAction)) {
			DealerBean dealerBean = service.updateForm(bean.getDealerId());
			dealerMap.put("updateDealer", dealerBean);
			return "update";
		} else {
			servicedealer.deleteTransport(bean.getDealerId());
			return "delete";
		}

	}

	@Action(value = "viewDealer", results = { @Result(name = "success", location = "dealer.page", type = "tiles"), })
	public String transport() {
		return "success";
	}

	public DealerBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

}
