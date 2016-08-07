package com.projectazure.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.projectazure.dao.VehicleandDealerDAO;
import com.projectazure.hibernate.beans.DealerBean;
import com.projectazure.struts.beans.VehicleBean;

public class VehicleandDealerService {

	com.projectazure.hibernate.beans.VehicleBean vehicle = new com.projectazure.hibernate.beans.VehicleBean();
	com.projectazure.hibernate.beans.DealerBean dealer = new com.projectazure.hibernate.beans.DealerBean();
	VehicleandDealerDAO dao = new VehicleandDealerDAO();

	/*
	 * This method is used to convert the strut vehicle bean to hibernate
	 * vehicle bean to add it in database
	 */
	public void addVehicle(VehicleBean bean, int id)

	{
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(bean.getCommittedDate());
			vehicle.setCommittedDate(new java.sql.Date(date.getTime()));
			vehicle.setVehicleNo(bean.getVehicleNo());
			vehicle.setVehicleType(bean.getVehicleType());
			dao.addVehicleandDealer(vehicle, id);
		} catch (ParseException e) {
			e.printStackTrace();

		}

	}

	/*
	 * This method is used to get the transport details from dao and the view of
	 * transport details by user can be modified here
	 */
	public List<DealerBean> viewTransport() {
		List<DealerBean> list = dao.viewTransport();
		return list;
	}

	/*
	 * This method is used to pass the id of the transport which need to be
	 * deleted
	 */
	public void deleteTransport(Integer id) {
		// TODO Auto-generated method stub

		dao.deleteTransport(id);

	}

	/*
	 * This method is used to get the set of vehicles owned by a particular
	 * dealer
	 */
	public Set<com.projectazure.hibernate.beans.VehicleBean> vehicleView(
			com.projectazure.struts.beans.DealerBean bean, int id) {
		dealer.setDealerId(bean.getDealerId());
		dealer.setDealerAddress(bean.getDealerAddress());
		dealer.setDealerContact(bean.getDealerContact());
		dealer.setDealerName(bean.getDealerName());
		Set<com.projectazure.hibernate.beans.VehicleBean> vehicleSet = dao
				.vehicleView(dealer, dealer.getDealerId());
		return vehicleSet;
	}

	/*
	 * This method is used to pass the details of dealer which need to be
	 * updated
	 */
	public void updateDealer(DealerBean bean, int id) {

		dealer.setDealerId(bean.getDealerId());
		dealer.setDealerAddress(bean.getDealerAddress());
		dealer.setDealerContact(bean.getDealerContact());
		dealer.setDealerName(bean.getDealerName());
		dao.updateTransport(dealer, dealer.getDealerId());
	}

	/* This method is used to get the list of unallocated vehicles */
	public void searchVehicle(String type) {
		dao.searchVehicle(type);
	}

}
