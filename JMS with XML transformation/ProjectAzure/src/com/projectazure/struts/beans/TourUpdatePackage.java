package com.projectazure.struts.beans;


public class TourUpdatePackage {
	
	private int packageId;
	private String packageName;
	private String packageType;
	private String location;
	private int pricePerHead;
	
    public TourUpdatePackage(){}
	public TourUpdatePackage(int packageId, String packageName,
			String packageType, String location, int pricePerHead) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageType = packageType;
		this.location = location;
		this.pricePerHead = pricePerHead;
	}
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
