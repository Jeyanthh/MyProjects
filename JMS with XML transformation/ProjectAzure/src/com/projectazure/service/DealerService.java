package com.projectazure.service;

import java.util.ArrayList;

import java.util.List;

import com.projectazure.dao.DealerDAO;
import com.projectazure.dao.VehicleDAO;
import com.projectazure.struts.beans.DealerBean;

public class DealerService {

	DealerDAO dao = new DealerDAO();
	com.projectazure.hibernate.beans.DealerBean dealer = new com.projectazure.hibernate.beans.DealerBean();

	/*This method is used to add the details of dealer to database*/
	public void addDealer(DealerBean bean) {
		try {

			dealer.setDealerAddress(bean.getDealerAddress());
			dealer.setDealerContact(bean.getDealerContact());
			dealer.setDealerName(bean.getDealerName());

			dao.addDealer(dealer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
/*This method is used to get the list of vehicle details from dao and convert it into strut bean*/
	public List<com.projectazure.struts.beans.DealerBean> viewVehicle() {
		DealerDAO dao = new DealerDAO();

		List<com.projectazure.hibernate.beans.DealerBean> dealerList = new ArrayList<com.projectazure.hibernate.beans.DealerBean>();
		List<com.projectazure.struts.beans.DealerBean> dealer = new ArrayList<com.projectazure.struts.beans.DealerBean>();
		dealerList = dao.getDealer();
		for (int i = 0; i < dealerList.size(); i++) {
			com.projectazure.struts.beans.DealerBean strutDealer = new com.projectazure.struts.beans.DealerBean();

			dealer.add(i, strutDealer);
			dealer.get(i)
					.setDealerAddress(dealerList.get(i).getDealerAddress());
			dealer.get(i)
					.setDealerContact(dealerList.get(i).getDealerContact());
			dealer.get(i).setDealerName(dealerList.get(i).getDealerName());
			dealer.get(i).setDealerId(dealerList.get(i).getDealerId());

		}

		return dealer;

	}
	/*This method is used to convert the strut vehicle bean to hibernate vehicle bean to update the details in database*/

	public void updateDealer(DealerBean bean, int id) {

		dealer.setDealerId(bean.getDealerId());
		dealer.setDealerAddress(bean.getDealerAddress());
		dealer.setDealerContact(bean.getDealerContact());
		dealer.setDealerName(bean.getDealerName());
		dao.updateDealer(dealer, id);
	}
	
	/*This method is used to pass the id of the selected vehicle to auto-populate the update vehicle form*/

	public DealerBean updateForm(int id) {

		DealerBean bean = dao.updateForm(id);
		return bean;
	}

}
