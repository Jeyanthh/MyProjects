package com.projectazure.struts.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TourPackage")
public class TourPackage {
	@Id
	@GeneratedValue
    @Column(name = "PACKAGEID")
	private int packageId;
	@Column(name = "PACKAGENAME")
	private String packageName;
	@Column(name = "PACKAGETYPE")
	private String packageType;
	@Column(name = "TOURPLACE")
	private String location;
	@Column(name = "PRICEPERHEAD")
	private int pricePerHead;
		
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPricePerHead() {
		return pricePerHead;
	}
	public void setPricePerHead(int pricePerHead) {
		this.pricePerHead = pricePerHead;
	}
	

}
