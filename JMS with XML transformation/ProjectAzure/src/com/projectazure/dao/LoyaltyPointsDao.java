package com.projectazure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.projectazure.hibernate.beans.LoyaltyPoints;
import com.projectazure.hibernate.beans.TourPackage;
import com.projectazure.struts.beans.TourAddPackage;
import com.projectazure.util.HibernateUtil;

//import com.projectazure.util.HibernateUtil;

public class LoyaltyPointsDao {
	private static Logger logger = Logger.getLogger(LoyaltyPointsDao.class);

	SessionFactory sf = new AnnotationConfiguration().configure()
			.buildSessionFactory();
	Session session = sf.openSession();

	public void editLoyaltyPoints(LoyaltyPoints loyaltyPoints) {

		logger.info("Transaction begins to edit loyalty points");

		session.beginTransaction();
		session.save(loyaltyPoints);
		session.getTransaction().commit();

		logger.info("Transaction to edit loyalty pointss is closed");

	}

	@SuppressWarnings("unchecked")
	public List<com.projectazure.struts.beans.LoyaltyPoints> viewLoyaltyPoints() {

		logger.info("Transaction begins to view loyalty points");

		Transaction tx = session.beginTransaction();
		List<LoyaltyPoints> loyaltyPoints = new ArrayList<LoyaltyPoints>();
		loyaltyPoints = session.createQuery("from LoyaltyPoints").list();
		// tx.commit();
		// session.close();
		List<com.projectazure.struts.beans.LoyaltyPoints> loyaltyPointsList = new ArrayList<com.projectazure.struts.beans.LoyaltyPoints>();

		for (Iterator iterator = loyaltyPoints.iterator(); iterator.hasNext();) {
			LoyaltyPoints loyaltyPoints2 = (LoyaltyPoints) iterator.next();

			com.projectazure.struts.beans.LoyaltyPoints loyaltyPointsObj = new com.projectazure.struts.beans.LoyaltyPoints();

			loyaltyPointsObj.setLoyaltyPointsId(loyaltyPoints2
					.getLoyaltyPointsId());
			loyaltyPointsObj
					.setLoyaltyPoints(loyaltyPoints2.getLoyaltyPoints());
			loyaltyPointsObj.setAchievedBy(loyaltyPoints2.getAchievedBy());
			Date utilDate = new java.sql.Date(loyaltyPoints2.getAchievedDate()
					.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String text = sdf.format(utilDate);

			loyaltyPointsObj.setAchievedDate(text);
			Date utilDate2 = new java.sql.Date(loyaltyPoints2.getExpiryDate()
					.getTime());
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String text2 = sdf2.format(utilDate2);

			loyaltyPointsObj.setExpiryDate(text2);
			loyaltyPointsObj.setUserId(loyaltyPoints2.getUserId());
			loyaltyPointsList.add(loyaltyPointsObj);

		}
		logger.info("Transaction to view loyalty points is closed");
		return loyaltyPointsList;

	}

	public com.projectazure.struts.beans.LoyaltyPoints viewUpdateLoyaltyPoints(
			int loyaltyPointsId) {
		logger.info("Transaction begins to  loyalty points update form");
		session.beginTransaction();

		LoyaltyPoints loyaltyPoints = (LoyaltyPoints) session.get(
				LoyaltyPoints.class, loyaltyPointsId);
		com.projectazure.struts.beans.LoyaltyPoints loyaltyPoints1 = new com.projectazure.struts.beans.LoyaltyPoints();
		loyaltyPoints1.setLoyaltyPointsId(loyaltyPoints.getLoyaltyPointsId());
		loyaltyPoints1.setLoyaltyPoints(loyaltyPoints.getLoyaltyPoints());
		loyaltyPoints1.setAchievedBy(loyaltyPoints.getAchievedBy());

		Date utilDate = new java.sql.Date(loyaltyPoints.getAchievedDate()
				.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String text = sdf.format(utilDate);
		loyaltyPoints1.setAchievedDate(text);

		Date utilDate2 = new java.sql.Date(loyaltyPoints.getExpiryDate()
				.getTime());
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String text2 = sdf2.format(utilDate2);
		loyaltyPoints1.setExpiryDate(text2);
		loyaltyPoints1.setUserId(loyaltyPoints.getUserId());
		logger.info("Transaction to loyalty points update form is closed");
		return loyaltyPoints1;
	}

	public void updateLoyaltyPoints(
			com.projectazure.hibernate.beans.LoyaltyPoints loyaltyBean) {

		logger.info("Transaction begins to update loyalty points");

		session.beginTransaction();
		LoyaltyPoints updateBean = (LoyaltyPoints) session.get(
				LoyaltyPoints.class, loyaltyBean.getLoyaltyPointsId());

		updateBean.setLoyaltyPointsId(loyaltyBean.getLoyaltyPointsId());
		updateBean.setLoyaltyPoints(loyaltyBean.getLoyaltyPoints());
		updateBean.setAchievedBy(loyaltyBean.getAchievedBy());
		/*
		 * updateBean.setAchievedDate(loyaltyBean.getAchievedDate());
		 * updateBean.setExpiryDate(loyaltyBean.getExpiryDate());
		 */
		updateBean.setUserId(loyaltyBean.getUserId());
		session.update(updateBean);
		session.getTransaction().commit();
		System.out.println("Updated");
		logger.info("Transaction to update loyalty points is closed");

	}

	public List<com.projectazure.hibernate.beans.LoyaltyPoints> generateLoyaltyPoints(
			int loyaltyPoints) {

		logger.info("Transaction begins to generate loyalty points report view");
		List<LoyaltyPoints> loyaltyPointsList = new ArrayList<LoyaltyPoints>();
		Transaction tx = session.beginTransaction();
		if (loyaltyPoints <= 300) {
			Query query = session
					.createQuery("FROM LoyaltyPoints WHERE loyaltyPoints<=:loyaltyPoints ");

			query.setParameter("loyaltyPoints", loyaltyPoints);
			loyaltyPointsList = query.list();
		} else if (loyaltyPoints > 300 && loyaltyPoints < 600) {
			Query query = session
					.createQuery("FROM LoyaltyPoints WHERE loyaltyPoints>:loyaltyPoints");

			query.setParameter("loyaltyPoints", loyaltyPoints);
			loyaltyPointsList = query.list();
		} else if (loyaltyPoints >= 600) {
			Query query = session
					.createQuery("FROM LoyaltyPoints WHERE loyaltyPoints>=:loyaltyPoints ");

			query.setParameter("loyaltyPoints", loyaltyPoints);
			loyaltyPointsList = query.list();
		} else {
			Query query = session.createQuery("FROM LoyaltyPoints");

			query.setParameter("loyaltyPoints", loyaltyPoints);
			loyaltyPointsList = query.list();
		}

		tx.commit();
		session.close();
		logger.info("Transaction to generate loyalty points report view is closed");
		return loyaltyPointsList;

	}

	public void addLoyaltyPoints(LoyaltyPoints loyaltyPoints) {
		logger.info("Transaction begins to add loyalty points");

		session.beginTransaction();

		session.save(loyaltyPoints);

		session.getTransaction().commit();
		session.close();
		logger.info("Transaction to add loyalty points is closed");

	}

	public void updateLoyaltyPointsValue(
			com.projectazure.hibernate.beans.LoyaltyPoints loyaltyBean) {
		logger.info("Transaction begins to update loyalty points");
		session.beginTransaction();
		LoyaltyPoints updateBean = (LoyaltyPoints) session.get(
				LoyaltyPoints.class, loyaltyBean.getLoyaltyPointsId());

		updateBean.setLoyaltyPointsId(loyaltyBean.getLoyaltyPointsId());
		int newValue = updateBean.getLoyaltyPoints() + 200;

		updateBean.setLoyaltyPoints(newValue);
		updateBean.setAchievedBy(loyaltyBean.getAchievedBy());

		updateBean.setAchievedDate(loyaltyBean.getAchievedDate());
		updateBean.setExpiryDate(loyaltyBean.getExpiryDate());

		updateBean.setUserId(loyaltyBean.getUserId());
		session.update(updateBean);
		session.getTransaction().commit();
		System.out.println("Updated");
		logger.info("Transaction to update loyalty points is closed");
	}

	public boolean isAvailable(int userId) {
		logger.info("Transaction begins to determine if userId is available");
		boolean present = false;
		List<LoyaltyPoints> loyaltyPoints = new ArrayList<LoyaltyPoints>();
		loyaltyPoints = session.createQuery("from LoyaltyPoints").list();
		Iterator iltr = loyaltyPoints.iterator();

		while (iltr.hasNext()) {

			LoyaltyPoints loyaltyPoints2 = (LoyaltyPoints) iltr.next();
			if (loyaltyPoints2.getUserId() == userId) {

				present = true;
				break;

			}
		}
		logger.info("Transaction to determine if userId is available is closed");
		return present;

	}

	public int findLoyaltyPointId(int userId) {
		logger.info("Transaction begins to find loyalty point ID ");
		int present = 0;
		List<LoyaltyPoints> loyaltyPoints = new ArrayList<LoyaltyPoints>();
		loyaltyPoints = session.createQuery("from LoyaltyPoints").list();
		Iterator iltr = loyaltyPoints.iterator();

		while (iltr.hasNext()) {

			LoyaltyPoints loyaltyPoints2 = (LoyaltyPoints) iltr.next();
			if (loyaltyPoints2.getUserId() == userId) {

				present = loyaltyPoints2.getLoyaltyPointsId();
				break;

			}

		}
		logger.info("Transaction to find loyalty point ID is closed");
		return present;

	}

}
