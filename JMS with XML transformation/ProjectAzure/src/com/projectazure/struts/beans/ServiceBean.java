package com.projectazure.struts.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SERVICES")
public class ServiceBean {
	@Id
	@GeneratedValue
	@Column(name = "SERVICEID")
	private long serviceID;
	
	@Column(name = "SERVICETYPE")
	private String serviceType;
	
	@Column(name = "SERVICEPRICE")
	private String servicePrice;
	
	@Column(name="DESCRIPTION")
	private String description;

	public long getServiceID() {
		return serviceID;
	}
	public void setServiceID(Long serviceID) {
		this.serviceID = serviceID;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



}
