package com.projectazure.hibernate.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	
	
		@Id
		@Column(name = "USERID")
		private int userId;
		@Column(name = "PASSWORD")
		private String password;
		@Column(name = "NAME")
		private String name;
		@Column(name = "AGE")
		private int age;
		@Column(name = "GENDER")
		private String gender;
		@Column(name = "LOCATION")
		private String location;
		@Column(name = "EMAILID")
		private String emailId;
		@Column(name = "CONTACTNUMBER")
		private long contactNumber;
		
		@OneToMany(mappedBy = "customer")
		private Set<TourPackageBookingAllocation> tourpackageallocation;
		

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public long getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(long contactNumber) {
			this.contactNumber = contactNumber;
		}

	}



