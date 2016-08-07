package com.projectazure.hibernate.beans;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.projectazure.hibernate.beans.TourPackage;



@Entity
@Table(name="TOURPACKAGEBOOKINGALLOCATION")
public class TourBooking {
    
	@Id
	@GeneratedValue
	@Column(name = "TPBOOKID")
	private int tpBookId;
	
	/*@Column(name = "PACKAGEID")
	private int packageId;
	*/
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

	
	public TourBooking(int tpBookId, int userId,
			Date dateofTravel, Date dateofBooking, int totalAmount,
			int passengerCount, String requirements, String availDiscount,
			String status, String remark) {
		super();
		this.tpBookId = tpBookId;
		//this.packageId = packageId;
		this.userId = userId;
		this.dateofTravel = dateofTravel;
		this.dateofBooking = dateofBooking;
		this.totalAmount = totalAmount;
		this.passengerCount = passengerCount;
		this.requirements = requirements;
		this.availDiscount = availDiscount;
		this.status = status;
		this.remark = remark;
	}

	public TourBooking() {
		super();
	}

	@Override
	public String toString() {
		return "TourBooking [tpBookId=" + tpBookId + ", userId=" + userId
				+ ", dateofTravel=" + dateofTravel + ", dateofBooking="
				+ dateofBooking + ", totalAmount=" + totalAmount
				+ ", passengerCount=" + passengerCount + ", requirements="
				+ requirements + ", availDiscount=" + availDiscount
				+ ", status=" + status + ", remark=" + remark
				+ ", tourPackage=" + tourPackage + "]";
	}

	



	
	
	
	
	
	
	/*@ManyToOne(optional=false,cascade = {CascadeType.ALL})
    @NotNull
    @JoinTable(name="TOURPACKAGE",joinColumns=@JoinColumn(name="PACKAGEID"))*/
	
	/*private TourPackage tourPackage;*/

	
}
