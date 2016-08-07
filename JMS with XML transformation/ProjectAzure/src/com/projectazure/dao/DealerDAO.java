package com.projectazure.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.projectazure.hibernate.beans.DealerBean;
import com.projectazure.util.HibernateUtil;

public class DealerDAO {

	private static final Logger logger = Logger.getLogger(DealerDAO.class);

	/* This method is used to insert dealer details into database */
	public void addDealer(DealerBean dealer) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try {
			logger.info("Add dealer transaction started");
			session.beginTransaction();
			session.save(dealer);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {

			session.close();
			logger.info("Add Dealer transaction ended");
		}

	}

	/* This method is used to get the details of dealer from database */
	public ArrayList<com.projectazure.hibernate.beans.DealerBean> getDealer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		logger.info("View dealer transaction started");
		@SuppressWarnings("unchecked")
		ArrayList<DealerBean> list = (ArrayList<DealerBean>) session
				.createQuery("from DealerBean").list();
		logger.info("View Dealer transaction ended");
		return list;

	}

	/* This method is used to update the details of dealer in database */
	public void updateDealer(com.projectazure.hibernate.beans.DealerBean bean,
			int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			logger.info("Update dealer transaction started");
			DealerBean updateBean = (DealerBean) session.get(DealerBean.class,
					id);
			updateBean.setDealerAddress(bean.getDealerAddress());
			updateBean.setDealerContact(bean.getDealerContact());
			updateBean.setDealerName(bean.getDealerName());
			session.update(updateBean);
			System.out.println("Updated");
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {

			session.close();
			logger.info("Update Dealer transaction ended");
		}

	}

	/* This method is used to auto-populate update dealer form */
	public com.projectazure.struts.beans.DealerBean updateForm(int id) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		logger.info("Auto population of update dealer started");
		session.beginTransaction();
		DealerBean updateBean = (DealerBean) session.get(DealerBean.class, id);
		com.projectazure.struts.beans.DealerBean dealerBean = new com.projectazure.struts.beans.DealerBean();
		dealerBean.setDealerId(updateBean.getDealerId());
		dealerBean.setDealerAddress(updateBean.getDealerAddress());
		dealerBean.setDealerContact(updateBean.getDealerContact());
		dealerBean.setDealerName(updateBean.getDealerName());
		session.getTransaction().commit();
		session.close();
		logger.info("Auto populated");
		return dealerBean;

	}

}
