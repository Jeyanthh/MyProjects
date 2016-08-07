package com.projectazure.hibernate.beans;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "VEHICLEALLOCATION")
public class VehicleAllocationBean {
	
	@Id
	@GeneratedValue
	@Column(name = "VEHICLEALLOCATIONID")
	private int vehicleAllocationId;
	
	@Column(name = "STARTDATE")
	private Date startDate;
	@Column(name = "ENDDATE")
	private Date endDate;
	
	
	

	@OneToOne
	@JoinColumn(name = "TPBOOKID")
	private TourBooking bookBean;
	
	public TourBooking getBookBean() {
		return bookBean;
	}

	public void setBookBean(TourBooking bookBean) {
		this.bookBean = bookBean;
	}

	@ManyToOne(cascade = CascadeType.ALL 
			 )
	@JoinColumn(name = "VEHICLEID")
	private VehicleBean vehicleBean;
	
	

	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}

	public void setVehicleBean(VehicleBean vehicleBean)
	{
		this.vehicleBean = vehicleBean;
	}

	public int getVehicleAllocationId() {
		return vehicleAllocationId;
	}

	public void setVehicleAllocationId(int vehicleAllocationId) {
		this.vehicleAllocationId = vehicleAllocationId;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
