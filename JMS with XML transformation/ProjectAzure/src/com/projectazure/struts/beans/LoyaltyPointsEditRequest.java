package com.projectazure.struts.beans;

public class LoyaltyPointsEditRequest {

	private int userId;

	private int loyaltyPoints;

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

	public LoyaltyPointsEditRequest() {
	}

	public LoyaltyPointsEditRequest(int userId, int loyaltyPoints) {
		super();
		this.userId = userId;
		this.loyaltyPoints = loyaltyPoints;
	}

}
