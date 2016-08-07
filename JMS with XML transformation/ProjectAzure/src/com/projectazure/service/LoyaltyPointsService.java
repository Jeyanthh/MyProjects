package com.projectazure.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.projectazure.dao.LoyaltyPointsDao;

import com.projectazure.struts.beans.LoyaltyPoints;

public class LoyaltyPointsService {

	LoyaltyPointsDao loyaltyPointsDao = new LoyaltyPointsDao();

	/*
	 * public void addLoyaltyPoints(LoyaltyPoints loyaltyPointsAddRequest) {
	 * 
	 * com.projectazure.hibernate.beans.LoyaltyPoints loyaltyPoints = new
	 * com.projectazure.hibernate.beans.LoyaltyPoints();
	 * loyaltyPoints.setUserId(loyaltyPointsAddRequest.getUserId());
	 * loyaltyPoints.setLoyaltyPoints(loyaltyPointsAddRequest
	 * .getLoyaltyPoints());
	 * loyaltyPoints.setAchievedBy(loyaltyPointsAddRequest.getAchievedBy());
	 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); Date
	 * date = formatter.parse(bean.getCommittedDate());
	 * vehicle.setCommittedDate(new java.sql.Date(date.getTime()));
	 * loyaltyPoints.setAchievedDate(loyaltyPointsAddRequest.getAchievedDate());
	 * loyaltyPoints.setExpiryDate(loyaltyPointsAddRequest.getExpiryDate());
	 * 
	 * loyaltyPointsDao.addLoyaltyPoints(loyaltyPoints);
	 * 
	 * }
	 */
	public List<LoyaltyPoints> viewLoyaltyPoints() {
		return loyaltyPointsDao.viewLoyaltyPoints();
	}

	public com.projectazure.struts.beans.LoyaltyPoints viewUpdateLoyaltyPoints(
			int validate) {

		int loyaltyPointsId = validate;

		return loyaltyPointsDao.viewUpdateLoyaltyPoints(loyaltyPointsId);

	}

	public void updateLoyaltyPoints(
			com.projectazure.struts.beans.LoyaltyPoints loyaltyPoints, int loyal) {
		com.projectazure.hibernate.beans.LoyaltyPoints loyaltyBean = new com.projectazure.hibernate.beans.LoyaltyPoints();
		loyaltyBean.setLoyaltyPointsId(loyaltyPoints.getLoyaltyPointsId());
		loyaltyBean.setLoyaltyPoints(loyaltyPoints.getLoyaltyPoints());
		loyaltyBean.setAchievedBy(loyaltyPoints.getAchievedBy());
		/*
		 * loyaltyBean.setAchievedDate(loyaltyPoints.getAchievedDate());
		 * loyaltyBean.setExpiryDate(loyaltyPoints.getExpiryDate());
		 */
		loyaltyBean.setUserId(loyaltyPoints.getUserId());

		loyaltyPointsDao.updateLoyaltyPoints(loyaltyBean);

	}

	public List<com.projectazure.hibernate.beans.LoyaltyPoints> generateLoyaltyPoints(
			int loyaltyPoints) {

		return loyaltyPointsDao.generateLoyaltyPoints(loyaltyPoints);

	}

	/*
	 * public void
	 * updateLoyaltyPointsValue(com.projectazure.struts.beans.LoyaltyPoints
	 * loyaltyPoints,int newLoyatyPointsValue){
	 * 
	 * 
	 * com.projectazure.hibernate.beans.LoyaltyPoints loyaltyBean = new
	 * com.projectazure.hibernate.beans.LoyaltyPoints();
	 * loyaltyBean.setLoyaltyPointsId(loyaltyPoints.getLoyaltyPointsId());
	 * loyaltyBean.setLoyaltyPoints(loyaltyPoints.getLoyaltyPoints());
	 * loyaltyBean.setAchievedBy(loyaltyPoints.getAchievedBy());
	 * loyaltyBean.setAchievedDate(loyaltyPoints.getAchievedDate());
	 * loyaltyBean.setExpiryDate(loyaltyPoints.getExpiryDate());
	 * loyaltyBean.setUserId(loyaltyPoints.getUserId());
	 * 
	 * 
	 * 
	 * loyaltyPointsDao.updateLoyaltyPointsValue(loyaltyBean,newLoyatyPointsValue
	 * );
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	public void addMyLoyaltyPoints(int userId) {

		com.projectazure.hibernate.beans.LoyaltyPoints loyaltyPoints = new com.projectazure.hibernate.beans.LoyaltyPoints();
		if (loyaltyPointsDao.isAvailable(userId)) {
			int loyaltyPointsId = loyaltyPointsDao.findLoyaltyPointId(userId);
			loyaltyPoints.setUserId(userId);
			loyaltyPoints.setLoyaltyPointsId(loyaltyPointsId);
			loyaltyPoints.setAchievedBy("Tour");
			loyaltyPoints.setAchievedDate(new java.sql.Date(new Date()
					.getTime()));
			Calendar todayPlusYear = Calendar.getInstance();
			todayPlusYear.add(Calendar.YEAR, 1);
			Date expiryDate = todayPlusYear.getTime();
			java.sql.Date expDate = new java.sql.Date(expiryDate.getTime());
			loyaltyPoints.setExpiryDate(expDate);
			loyaltyPointsDao.updateLoyaltyPointsValue(loyaltyPoints);
		} else {
			loyaltyPoints.setUserId(userId);
			loyaltyPoints.setAchievedBy("Tour");
			loyaltyPoints.setAchievedDate(new java.sql.Date(new Date()
					.getTime()));
			loyaltyPoints.setLoyaltyPoints(200);
			Calendar todayPlusYear = Calendar.getInstance();
			todayPlusYear.add(Calendar.YEAR, 1);
			Date expiryDate = todayPlusYear.getTime();
			java.sql.Date expDate = new java.sql.Date(expiryDate.getTime());
			loyaltyPoints.setExpiryDate(expDate);
			loyaltyPointsDao.addLoyaltyPoints(loyaltyPoints);

		}

	}

}
