package com.projectazure.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.projectazure.hibernate.beans.DealerBean;
import com.projectazure.hibernate.beans.VehicleBean;
import com.projectazure.util.HibernateUtil;

public class VehicleDAO {
	private static final Logger logger = Logger.getLogger(VehicleDAO.class);

	/* This method is used to delete the details of Vehicle */
	public void delete(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			logger.info("Delete Vehicles Transaction begun");
			VehicleBean bean = (VehicleBean) session.get(VehicleBean.class, id);
			session.delete(bean);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {

			session.close();
			logger.info("Deleted Vehicles");
		}

	}

	/* This method is used to update the details of vehicle */
	public void updateVehicle(
			com.projectazure.hibernate.beans.VehicleBean bean, int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			logger.info("Updating Vehicle Details");
			session.beginTransaction();
			VehicleBean updateBean = (VehicleBean) session.get(
					VehicleBean.class, id);
			updateBean.setVehicleNo(bean.getVehicleNo());
			updateBean.setVehicleType(bean.getVehicleType());
			updateBean.setCommittedDate(bean.getCommittedDate());
			session.update(updateBean);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {

			session.close();
			logger.info("Updated Vehicles");
		}

	}

	/* This method is used to auto-populate the update vehicle form */
	public com.projectazure.struts.beans.VehicleBean updateVehicleForm(int id) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		logger.info("Auto population of update vehicles began");
		session.beginTransaction();
		VehicleBean updateBean = (VehicleBean) session.get(VehicleBean.class,
				id);
		com.projectazure.struts.beans.VehicleBean vehicleBean = new com.projectazure.struts.beans.VehicleBean();
		vehicleBean.setVehicleId(updateBean.getVehicleId());
		vehicleBean.setVehicleNo(updateBean.getVehicleNo());
		vehicleBean.setVehicleType(updateBean.getVehicleType());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		vehicleBean.setCommittedDate(df.format(updateBean.getCommittedDate()));
		vehicleBean.setDealerId(updateBean.getDealerBean().getDealerId());
		session.getTransaction().commit();
		session.close();
		logger.info("Auto population of update vehicle successful");
		return vehicleBean;
	}

}
