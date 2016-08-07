package com.projectazure.hibernate.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="TOURPACKAGEBOOKINGALLOCATION")
public class TourBooking {
    
	@Id
	@GeneratedValue
	@Column(name = "TPBOOKID")
	private int tpBookId;
	
	
	@Column(name = "USERID")
	private int userId;
	
	@Column(name = "DATEOFTRAVEL")
	private Date dateofTravel;
	
	@Column(name = "DATEOFBOOKING")
	private Date dateofBooking;
	
	@Column(name = "TOTALAMOUNT")
	private int totalAmount;
	

	@Column(name = "NOOFPASSENGERS")
	private int passengerCount;
	
	@Column(name = "REQUIREMENTS")
	private String requirements;
	
	@Column(name = "AVAILDISCOUNT")
	private String availDiscount;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "REMARK")
	private String remark;
	
	@ManyToOne(cascade = CascadeType.ALL 
			 )
	@JoinColumn(name = "PACKAGEID")
	private TourPackage tourPackage;
	
	

	public TourPackage getTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

	
	
	

	

	public int getTpBookId() {
		return tpBookId;
	}

	public void setTpBookId(int tpBookId) {
		this.tpBookId = tpBookId;
	}

	/*public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}*/

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateofTravel() {
		return dateofTravel;
	}

	public void setDateofTravel(Date dateofTravel) {
		this.dateofTravel = dateofTravel;
	}

	

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getAvailDiscount() {
		return availDiscount;
	}

	public void setAvailDiscount(String availDiscount) {
		this.availDiscount = availDiscount;
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
	

	public Date getDateofBooking() {
		return dateofBooking;
	}

	public void setDateofBooking(Date dateofBooking) {
		this.dateofBooking = dateofBooking;
	}

	


	public TourBooking() {
		super();
	}

	
	}


	
	

	
	
	
	
	
	
	/*@ManyToOne(optional=false,cascade = {CascadeType.ALL})
    @NotNull
    @JoinTable(name="TOURPACKAGE",joinColumns=@JoinColumn(name="PACKAGEID"))*/
	
	/*private TourPackage tourPackage;*/

	

