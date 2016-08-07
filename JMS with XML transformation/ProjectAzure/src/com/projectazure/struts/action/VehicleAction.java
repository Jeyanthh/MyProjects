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
import com.projectazure.service.VehicleService;
import com.projectazure.service.VehicleandDealerService;
import com.projectazure.struts.beans.DealerBean;
import com.projectazure.struts.beans.VehicleBean;

@Namespaces(value = { @Namespace("/module3/admin/pages"),
		@Namespace("/pages/module3/admin/pages"), @Namespace("/"),
		@Namespace("/view") })
public class VehicleAction extends ActionSupport implements
		ModelDriven<VehicleBean>,SessionAware {

	private static final long serialVersionUID = 1L;
	private String vehicleAction;
	private Map vehicleMap;
	public Map getVehicleMap() {
		return vehicleMap;
	}

	public void setVehicleMap(Map vehicleMap) {
		this.vehicleMap = vehicleMap;
	}
	public void setSession(Map map) {
		this.vehicleMap = map;
	}

	public String getVehicleAction() {
		return vehicleAction;
	}

	public void setVehicleAction(String vehicleAction) {
		this.vehicleAction = vehicleAction;
	}

	VehicleBean bean = new VehicleBean();

	List<com.projectazure.struts.beans.VehicleBean> list = new ArrayList<com.projectazure.struts.beans.VehicleBean>();
	
	VehicleandDealerService service = new VehicleandDealerService();
	VehicleService vehicleService=new VehicleService();

	@Action(value = "addVehicle", results = { @Result(name = "addVehicle", location = "addVehicle.page", type = "tiles"), })
	public String addVehicle() {
		return "addVehicle";
	}
	
	@Action(value = "vehicleView", results = { @Result(name = "vehicleView", location = "vehicleView.page", type = "tiles"), })
	public String vehicleView() {
		return "vehicleView";
	}

	@Action(value = "updateVehicle", results = { @Result(name = "updateVehicle", location = "updateVehicle.page", type = "tiles"), })
	public String updateVehicle() {
		return "updateVehicle";
	}

	/*@Action(value = "deleteDealer", results = { @Result(name = "deleteDealer", location = "deleteDealer.page", type = "tiles"), })
	public String deleteDealer() {
		return "deleteDealer";
	}*/

	@Action(value = "transport", results = { @Result(name = "success", location = "result.page", type = "tiles"), })
	public String transport() {
		return "success";
	}

	@Action(value = "vehicle", results = {
			@Result(name = "success", location = "/module3/admin/pages/success.jsp"),
			@Result(name = "failure", location = "/module3/admin/pages/failure.jsp") })
	public String addVehicletoDB() {
		try {
			service.addVehicle(bean, bean.getDealerId());
			return "success";
		} catch (Exception e) {

		}

		return "failure";
	}
	

	@Action(value = "update", results = {
			@Result(name = "success", location = "/admin/pages/success.jsp"),
			@Result(name = "failure", location = "/admin/pages/failure.jsp") })
	public String update() {
		try {
			vehicleService.updateVehicle(bean,bean.getVehicleId());
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	
	@Action(value = "allocate", results = {
			@Result(name = "success", location = "/admin/pages/success.jsp"),
			@Result(name = "failure", location = "/admin/pages/failure.jsp") })
	public String allocate() {
		try {
			service.searchVehicle(bean.getVehicleType());
			return "success";
		} catch (Exception e) {

		}

		return "failure";
	}
	@Action(value = "updateVehicleForm", results = {
			@Result(name = "update", location = "updateVehicle.page",type="tiles"),
			@Result(name = "addVehicle", location = "addVehicle", type = "redirect"),
			@Result(name = "delete", location = "success.page", type = "tiles"), })
	public String updateDealerForm() {
		VehicleService service=new VehicleService();

		if ("Add Vehicle".equalsIgnoreCase(vehicleAction)) {
			
			return "addVehicle";
		} else if ("Update Vehicle".equalsIgnoreCase(vehicleAction)) {
			com.projectazure.struts.beans.VehicleBean vehicleBean = service.updateVehicleForm(bean.getVehicleId());
			vehicleMap.put("updateVehicle", vehicleBean);
			return "update";
		} else {
			service.deleteVehicle(bean.getVehicleId());
			return "delete";
		}

	}

	public VehicleBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

}
