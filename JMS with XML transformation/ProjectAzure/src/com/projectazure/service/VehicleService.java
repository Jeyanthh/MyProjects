package com.projectazure.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.projectazure.dao.VehicleDAO;
import com.projectazure.hibernate.beans.VehicleBean;
import com.projectazure.struts.beans.DealerBean;

public class VehicleService {
	VehicleBean vehicle = new VehicleBean();
	VehicleDAO dao = new VehicleDAO();

	/*
	 * public void addVehicle(com.projectazure.struts.beans.VehicleBean bean) {
	 * 
	 * try { SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	 * Date date = formatter.parse(bean.getCommittedDate());
	 * vehicle.setCommittedDate(new java.sql.Date(date.getTime()));
	 * 
	 * //vehicle.setDealerId(bean.getDealerId());
	 * vehicle.setVehicleNo(bean.getVehicleNo());
	 * vehicle.setVehicleType(bean.getVehicleType());
	 * 
	 * dao.addVehicle(vehicle); } catch (ParseException e) {
	 * e.printStackTrace(); }
	 * 
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	/*
	 * public List<com.projectazure.struts.beans.VehicleBean> viewVehicle() {
	 * 
	 * 
	 * List<com.projectazure.hibernate.beans.VehicleBean> vehicleList = new
	 * ArrayList<com.projectazure.hibernate.beans.VehicleBean>();
	 * List<com.projectazure.struts.beans.VehicleBean> vehicle = new
	 * ArrayList<com.projectazure.struts.beans.VehicleBean>(); vehicleList =
	 * dao.getVehicle(); for (int i = 0; i < vehicleList.size(); i++) {
	 * com.projectazure.struts.beans.VehicleBean strutVehicle = new
	 * com.projectazure.struts.beans.VehicleBean();
	 * 
	 * vehicle.add(i, strutVehicle);
	 * vehicle.get(i).setVehicleId(vehicleList.get(i).getVehicleId());
	 * vehicle.get(i).setVehicleNo(vehicleList.get(i).getVehicleNo());
	 * vehicle.get(i).setVehicleType(vehicleList.get(i).getVehicleType());
	 * //vehicle.get(i).setDealerId(vehicleList.get(i).getDealerId()); String
	 * date1 = new SimpleDateFormat("dd-MM-yyyy")
	 * .format(vehicleList.get(i).getCommittedDate());
	 * vehicle.get(i).setCommittedDate(date1);
	 * 
	 * }
	 * 
	 * return vehicle;
	 * 
	 * }
	 */

	/*
	 * This method is used to pass the id of the vehicle which need to be
	 * deleted to database
	 */
	public void deleteVehicle(int id) {
		// TODO Auto-generated method stub

		dao.delete(id);

	}

	/*
	 * This method is used to update the details of vehicle (i.e) It converts
	 * strut bean to hibernate bean
	 */
	public void updateVehicle(com.projectazure.struts.beans.VehicleBean bean,
			int id) {
		try {
			vehicle.setVehicleId(bean.getVehicleId());
			vehicle.setVehicleNo(bean.getVehicleNo());
			vehicle.setVehicleType(bean.getVehicleType());

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = formatter.parse(bean.getCommittedDate());
			vehicle.setCommittedDate(new java.sql.Date(date.getTime()));

			vehicle.setCommittedDate(new java.sql.Date(date.getTime()));

			dao.updateVehicle(vehicle, id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method is used to get the details of selected vehicle from view page
	 * to update page
	 */
	public com.projectazure.struts.beans.VehicleBean updateVehicleForm(int id) {
		com.projectazure.struts.beans.VehicleBean bean = dao
				.updateVehicleForm(id);
		return bean;
	}
}
