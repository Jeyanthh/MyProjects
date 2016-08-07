package com.projectazure.hibernate.beans;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@SuppressWarnings("deprecation")
@Entity
@Table(name = "VEHICLE")
public class VehicleBean {
	@Id
	@GeneratedValue
	@Column(name = "VEHICLEID")
	private int vehicleId;
	@Column(name = "VEHICLENO")
	private String vehicleNo;
	@Column(name = "VEHICLETYPE")
	private String vehicleType;
	@Column(name = "COMMITTEDDATE")
	private Date committedDate;
	@ManyToOne(cascade = CascadeType.ALL 
			 )
	@JoinColumn(name = "DEALERID")
	private DealerBean dealerBean;
	
	@OneToMany(mappedBy="vehicleBean",fetch = FetchType.LAZY
			
			 )
    private Set<VehicleAllocationBean> vehicleAllocationBeans;

	
	public Set<VehicleAllocationBean> getVehicleAllocationBeans() {
		return vehicleAllocationBeans;
	}

	public void setVehicleAllocationBeans(
			Set<VehicleAllocationBean> vehicleAllocationBeans) {
		this.vehicleAllocationBeans = vehicleAllocationBeans;
	}

	public DealerBean getDealerBean() {
		return dealerBean;
	}

	public void setDealerBean(DealerBean dealerBean) {
		this.dealerBean = dealerBean;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getCommittedDate() {
		return committedDate;
	}

	public void setCommittedDate(Date committedDate) {
		this.committedDate = committedDate;
	}



}
