package com.projectazure.struts.beans;

public class TourPackageUpdateRequest {
	private int bookingId;
	public TourPackageUpdateRequest() {
		super();
	}
	@Override
	public String toString() {
		return "TourPackageUpdateRequest [bookingId=" + bookingId
				+ ", packageId=" + packageId + ", customerId=" + customerId
				+ ", dateofTravel=" + dateofTravel + ", dateofBooking="
				+ dateofBooking + ", noofPassengers=" + noofPassengers
				+ ", requirements=" + requirements + ", availDiscount="
				+ availDiscount + "]";
	}
	public TourPackageUpdateRequest(int bookingId, int packageId,
			int customerId, String dateofTravel, String dateofBooking,
			int noofPassengers, String requirements, boolean availDiscount) {
		super();
		this.bookingId = bookingId;
		this.packageId = packageId;
		this.customerId = customerId;
		this.dateofTravel = dateofTravel;
		this.dateofBooking = dateofBooking;
		this.noofPassengers = noofPassengers;
		this.requirements = requirements;
		this.availDiscount = availDiscount;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getNoofPassengers() {
		return noofPassengers;
	}
	public void setNoofPassengers(int noofPassengers) {
		this.noofPassengers = noofPassengers;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public boolean isAvailDiscount() {
		return availDiscount;
	}
	public void setAvailDiscount(boolean availDiscount) {
		this.availDiscount = availDiscount;
	}
	private int packageId;
	private int customerId;
	private String dateofTravel;
	private String dateofBooking;
	private int noofPassengers;
	private String requirements;
	private boolean availDiscount;


}
