package com.projectazure.hibernate.beans;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="LOYALTYPOINTS")
public class LoyaltyPoints {

	
	@Id
    @GeneratedValue
    @Column(name="LOYALTYPOINTSID")
	private int loyaltyPointsId;
/*	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value=""))*/
	
	@Column(name="USERID")
	private int userId;
	
	@Column(name="LOYALTYPOINTS")
	private int loyaltyPoints;
	
	@Column(name="ACHIEVEDBY")
	private String achievedBy;
	
	@Column(name="ACHIEVEDDATE")
	private Date achievedDate;
	
	@Column(name="EXPIRYDATE")
	private Date expiryDate;

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

	public Date getAchievedDate() {
		return achievedDate;
	}

	public void setAchievedDate(Date achievedDate) {
		this.achievedDate = achievedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

	public LoyaltyPoints() {
	}

	public LoyaltyPoints(int loyaltyPointsId, int userId, int loyaltyPoints,
			String achievedBy, Date achievedDate, Date expiryDate) {
		this.loyaltyPointsId = loyaltyPointsId;
		this.userId = userId;
		this.loyaltyPoints = loyaltyPoints;
		this.achievedBy = achievedBy;
		this.achievedDate = achievedDate;
		this.expiryDate = expiryDate;

	}

}
