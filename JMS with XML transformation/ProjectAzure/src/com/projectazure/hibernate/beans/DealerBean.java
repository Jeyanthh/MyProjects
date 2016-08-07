package com.projectazure.hibernate.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEALERS")
public class DealerBean {

	@Id
	@GeneratedValue
	@Column(name = "DEALERID")
	
	private int dealerId;
	@Column(name = "DEALERNAME")
	private String dealerName;
	@Column(name = "DEALERCONTACT")
	private int dealerContact;
	@Column(name = "DEALERADDRESS")
	private String dealerAddress;
	

	@OneToMany(mappedBy="dealerBean",
			cascade = CascadeType.ALL
			 )
    private Set<VehicleBean> vehicleBeans;
	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public int getDealerContact() {
		return dealerContact;
	}

	public void setDealerContact(int dealerContact) {
		this.dealerContact = dealerContact;
	}

	public String getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}
	
	 public Set<VehicleBean> getVehicleBeans() {
			return vehicleBeans;
		}

		public void setVehicleBeans(Set<VehicleBean> vehicleBeans) {
			this.vehicleBeans = vehicleBeans;
		}

}
