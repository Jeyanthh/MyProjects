package com.projectazure.struts.beans;



public class LoyaltyPoints {

	
	private int loyaltyPointsId;
	
	private int userId;
	
	
	private int loyaltyPoints;
	

	private String achievedBy;

	private String  achievedDate;
	
	
	private String expiryDate;

	public int getLoyaltyPointsId() {
		return loyaltyPointsId;
	}

	public void setLoyaltyPointsId(int loyaltyPointsId) {
		this.loyaltyPointsId = loyaltyPointsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getAchievedBy() {
		return achievedBy;
	}

	public void setAchievedBy(String achievedBy) {
		this.achievedBy = achievedBy;
	}

	public String getAchievedDate() {
		return achievedDate;
	}

	public void setAchievedDate(String achievedDate) {
		this.achievedDate = achievedDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

	public LoyaltyPoints() {
	}

	public LoyaltyPoints(int loyaltyPointsId, int userId, int loyaltyPoints,
			String achievedBy, String achievedDate, String expiryDate) {
		this.loyaltyPointsId = loyaltyPointsId;
		this.userId = userId;
		this.loyaltyPoints = loyaltyPoints;
		this.achievedBy = achievedBy;
		this.achievedDate = achievedDate;
		this.expiryDate = expiryDate;

	}

	
	
	
}
