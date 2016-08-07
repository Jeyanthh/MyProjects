package com.projectazure.struts.beans;


public class TourAddPackage {
	
	private String packageName;
	private String packageType;
	private String tourPlace;
	private int pricePerHead;
	private int packageId;
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
	public String getTourPlace() {
		return tourPlace;
	}
	public void setTourPlace(String tourPlace) {
		this.tourPlace = tourPlace;
	}
	public int getPricePerHead() {
		return pricePerHead;
	}
	public void setPricePerHead(int pricePerHead) {
		this.pricePerHead = pricePerHead;
	}
	
	
	

}
