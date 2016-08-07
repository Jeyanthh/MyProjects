package com.projectazure.struts.beans;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class TourRequestBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private int packageId;
	private int userId;
	private String dateofTravel;
	private int passengerCount;
	private String requirements;
	private String availDiscount;
	public int getPackageId() {
		return packageId;
	}
	
	@XmlElement
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public int getUserId() {
		return userId;
	}
	@XmlElement
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDateofTravel() {
		return dateofTravel;
	}
	@XmlElement
	public void setDateofTravel(String dateofTravel) {
		this.dateofTravel = dateofTravel;
	}
	public int getPassengerCount() {
		return passengerCount;
	}
	@XmlElement
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public String getRequirements() {
		return requirements;
	}
	@XmlElement
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getAvailDiscount() {
		return availDiscount;
	}
	@XmlElement
	public void setAvailDiscount(String availDiscount) {
		this.availDiscount = availDiscount;
	}
	public TourRequestBean(int packageId, int userId, String dateofTravel,
			int passengerCount, String requirements, String availDiscount) {
		super();
		this.packageId = packageId;
		this.userId = userId;
		this.dateofTravel = dateofTravel;
		this.passengerCount = passengerCount;
		this.requirements = requirements;
		this.availDiscount = availDiscount;
	}
	public TourRequestBean() {
		super();
	}
	@Override
	public String toString() {
		return "TourRequestBean [packageId=" + packageId + ", userId=" + userId
				+ ", dateofTravel=" + dateofTravel + ", passengerCount="
				+ passengerCount + ", requirements=" + requirements
				+ ", availDiscount=" + availDiscount + "]";
	}
	
	
}
