package com.projectazure.struts.beans;

public class ViewPackageBean {

	
	private int userId;
	private String userName;
	private int packageId;
	private String packageName;
	private String dateofTravel;
	private String dateofBooking;
	private String vehicleNo;
	private int dealerContact;
	private int loyalityPoints;
	private int totalAmount;
	private String status;
	private String remark;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getDateofTravel() {
		return dateofTravel;
	}
	public void setDateofTravel(String dateofTravel) {
		this.dateofTravel = dateofTravel;
	}
	public String getDateofBooking() {
		return dateofBooking;
	}
	public void setDateofBooking(String dateofBooking) {
		this.dateofBooking = dateofBooking;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public int getDealerContact() {
		return dealerContact;
	}
	public void setDealerContact(int dealerContact) {
		this.dealerContact = dealerContact;
	}
	public int getLoyalityPoints() {
		return loyalityPoints;
	}
	public void setLoyalityPoints(int loyalityPoints) {
		this.loyalityPoints = loyalityPoints;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ViewPackageBean(int userId, String userName, int packageId,
			String packageName, String dateofTravel, String dateofBooking,
			String vehicleNo, int dealerContact, int loyalityPoints,
			int totalAmount, String status, String remark) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.packageId = packageId;
		this.packageName = packageName;
		this.dateofTravel = dateofTravel;
		this.dateofBooking = dateofBooking;
		this.vehicleNo = vehicleNo;
		this.dealerContact = dealerContact;
		this.loyalityPoints = loyalityPoints;
		this.totalAmount = totalAmount;
		this.status = status;
		this.remark = remark;
	}
	public ViewPackageBean() {
		super();
	}
	@Override
	public String toString() {
		return "ViewPackageBean [userId=" + userId + ", userName=" + userName
				+ ", packageId=" + packageId + ", packageName=" + packageName
				+ ", dateofTravel=" + dateofTravel + ", dateofBooking="
				+ dateofBooking + ", vehicleNo=" + vehicleNo
				+ ", dealerContact=" + dealerContact + ", loyalityPoints="
				+ loyalityPoints + ", totalAmount=" + totalAmount + ", status="
				+ status + ", remark=" + remark + "]";
	}
	
	
	
	
	
}
