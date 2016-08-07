package com.projectazure.struts.beans;



public class VehicleBean {
	private String vehicleNo;
	private String vehicleType;
	private String committedDate;
	private int dealerId;
	private int vehicleId;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getCommittedDate() {
		return committedDate;
	}

	public void setCommittedDate(String committedDate) {
		this.committedDate = committedDate;
	}

	
}
