package com.projectazure.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.projectazure.hibernate.beans.DealerBean;
import com.projectazure.hibernate.beans.VehicleAllocationBean;
import com.projectazure.hibernate.beans.VehicleBean;
import com.projectazure.util.HibernateUtil;

public class VehicleandDealerDAO {
	private static final Logger logger = Logger.getLogger(VehicleDAO.class);

	/* This method is used to add vehicles to the registered dealers */
	public void addVehicleandDealer(VehicleBean vehicle, int id) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			logger.info("Add vehicle transaction began");
			session.beginTransaction();
			DealerBean updateBean = (DealerBean) session.get(DealerBean.class,
					id);
			vehicle.setDealerBean(updateBean);
			session.save(vehicle);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			logger.info("Add vehicle transaction completed");
			session.close();

		}

	}

	/* This method is used to get the list of dealer details */
	public List<DealerBean> viewTransport() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("View Transport Details started");
		List<DealerBean> dealerList = session.createQuery("FROM DealerBean")
				.list();

		session.getTransaction().commit();
		return dealerList;
	}

	/*
	 * This method is used to delete the details of dealers and hence the linked
	 * vehicles
	 */
	public void deleteTransport(int id) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("Deleting the transport details");
		DealerBean dealer = (DealerBean) session.get(DealerBean.class, id);
		session.delete(dealer);
		session.getTransaction().commit();
		session.close();
	}

	/* This method is used to update the details of dealer */
	public void updateTransport(
			com.projectazure.hibernate.beans.DealerBean bean, int id) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("Updating the dealer details");
		DealerBean updateBean = (DealerBean) session.get(DealerBean.class, id);
		updateBean.setDealerAddress(bean.getDealerAddress());
		updateBean.setDealerContact(bean.getDealerContact());
		updateBean.setDealerName(bean.getDealerName());
		session.update(updateBean);
		System.out.println("Updated");
		session.getTransaction().commit();
		session.close();

	}

	/* This method is used to search the unallocated vehicles */

	public void searchVehicle(String type) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("Searching for unallocated vehicles");
		ArrayList<VehicleBean> list = (ArrayList<VehicleBean>) session
				.createQuery("from VehicleBean").list();
		ArrayList<VehicleBean> typeList = new ArrayList<VehicleBean>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getVehicleType().equals(type)) {
				typeList.add(list.get(i));
			}
		}
		for (int i = 0; i < typeList.size(); i++) {
			System.out.println(typeList.get(i).getVehicleNo());
			System.out.println(typeList.get(i).getVehicleAllocationBeans()
					.size());
			if (typeList.get(i).getVehicleAllocationBeans().isEmpty()) {
				System.out.println("not allocated");
			} else {
				Set<VehicleAllocationBean> allocSet = new HashSet<VehicleAllocationBean>();
				allocSet = typeList.get(i).getVehicleAllocationBeans();

				Iterator iter = allocSet.iterator();
				while (iter.hasNext()) {
					VehicleAllocationBean bean = (VehicleAllocationBean) iter
							.next();
					System.out.println(bean.getEndDate());
					System.out.println(new Date(2013, 12, 12).after(bean
							.getStartDate()));
					if (new Date(2013, 12, 12).after(bean.getStartDate())
							&& new Date(13, 12, 12).before(bean.getEndDate())) {
						System.out.println("betweeen");
					}

				}

				System.out.println("allocated");
			}
		}
	}

	/* This method is used to update the details of vehicle */

	public Set<VehicleBean> vehicleView(DealerBean dealer, int dealerId) {

		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("View the details of vehicle");
		DealerBean updateBean = (DealerBean) session.get(DealerBean.class,
				dealerId);
		Set<VehicleBean> vehicleSet = updateBean.getVehicleBeans();
		return vehicleSet;

	}

}
