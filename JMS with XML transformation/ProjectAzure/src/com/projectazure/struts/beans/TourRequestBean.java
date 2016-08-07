package com.projectazure.struts.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TourRequestBean implements Serializable  {
	
	private int tpBookId;
	private static final long serialVersionUID = 1L;
	private int packageId;
	private int userId;
	private String dateofTravel;
	private int passengerCount;
	private String requirements;
	private String availDiscount;
	
	
	
	@XmlElement
	public int getTpBookId() {
		return tpBookId;
	}
	public void setTpBookId(int tpBookId) {
		this.tpBookId = tpBookId;
	}
	@XmlElement
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	@XmlElement
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@XmlElement
	public String getDateofTravel() {
		return dateofTravel;
	}
	public void setDateofTravel(String dateofTravel) {
		this.dateofTravel = dateofTravel;
	}
	@XmlElement
	public int getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	@XmlElement
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	@XmlElement
	public String getAvailDiscount() {
		return availDiscount;
	}
	public void setAvailDiscount(String availDiscount) {
		this.availDiscount = availDiscount;
	}
	
	
	public TourRequestBean() {
		super();
	}
	public TourRequestBean(int tpBookId, int packageId, int userId,
			String dateofTravel, int passengerCount, String requirements,
			String availDiscount) {
		super();
		this.tpBookId = tpBookId;
		this.packageId = packageId;
		this.userId = userId;
		this.dateofTravel = dateofTravel;
		this.passengerCount = passengerCount;
		this.requirements = requirements;
		this.availDiscount = availDiscount;
	}
	@Override
	public String toString() {
		return "TourRequestBean [tpBookId=" + tpBookId + ", packageId="
				+ packageId + ", userId=" + userId + ", dateofTravel="
				+ dateofTravel + ", passengerCount=" + passengerCount
				+ ", requirements=" + requirements + ", availDiscount="
				+ availDiscount + "]";
	}
	
	
	
	
	
}
