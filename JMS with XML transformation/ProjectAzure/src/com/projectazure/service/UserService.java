package com.projectazure.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


import com.projectazure.constants.GenericConstants;
import com.projectazure.dao.UserDao;
import com.projectazure.helper.XMLJavaConverter;
import com.projectazure.hibernate.beans.TourBooking;
import com.projectazure.struts.beans.TourRequestBean;

/*import com.projectazure.dao.UserDao;
import com.projectazure.hibernate.beans.TourPackageBookingAllocation;*/


public class UserService {
	
	
	TourBooking tpallocation = new TourBooking();
	UserDao dao = new UserDao();
	
	
	public void bookTourPackage(TourRequestBean tpRequest)
	
	
	{
		/*tpallocation.setPackageId(tpRequest.getPackageId());
		tpallocation.setUserId(tpRequest.getUserId());
		tpallocation.setDateofTravel(tpRequest.getDateofTravel());
		tpallocation.setDateofBooking(tpRequest.getDateofBooking());
		tpallocation.setRequirements(tpRequest.getRequirements());
		tpallocation.setNoofPassengers(tpRequest.getNoofPassengers());
		tpallocation.setAvailDiscount(tpRequest.isAvailDiscount());
		userDao.bookTourPackage(tpallocation);
	}*/

	
		
		
		try{
            Context context = new InitialContext();
            QueueConnectionFactory factory =
                (QueueConnectionFactory)context.lookup(GenericConstants.CONNECTION_FACTORY);
            QueueConnection connection = factory.createQueueConnection();
            QueueSession session =
                connection.createQueueSession(false,
                    QueueSession.AUTO_ACKNOWLEDGE);
 
            Queue queue = (Queue)context.lookup(GenericConstants.QUEUE_LOOKUP);
            QueueSender sender = session.createSender(queue);
           
            TextMessage message = session.createTextMessage();
            
            
            String xmlString = new XMLJavaConverter().javaToXML(tpRequest);
            System.out.println(xmlString);
			message.setText(xmlString);
			sender.send(message);
			System.out.println("1. Sent TextMessage to the Queue");

            
            
            
            
          /*  ObjectMessage objMsg = session.createObjectMessage();
            objMsg.setObject(tpRequest);
            sender.send(objMsg);
           */
 
            session.close();
        }catch(Exception e){e.printStackTrace();}
	
		
	}

	
	public List viewAllBookedPackages() {
		
		List viewList = dao.viewAllBookedPackages();
	    return viewList;
	}

     public TourRequestBean viewUpdatePackage(int tpBookId) {
		
		return dao.viewUpdatePackage(tpBookId);
			
		}
	
	public void updateBookedPackage(TourRequestBean tprequest, int id) throws ParseException {
	
	
		tpallocation.setTpBookId(tprequest.getTpBookId());
		tpallocation.setUserId(tprequest.getUserId());
		tpallocation.setRequirements(tprequest.getRequirements());
		tpallocation.setPassengerCount(tprequest.getPassengerCount());
		tpallocation.setAvailDiscount(tprequest.getAvailDiscount());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = formatter.parse(tprequest.getDateofTravel());
		tpallocation.setDateofTravel(new java.sql.Date(date.getTime()));
		dao.updateBookedPackage(tpallocation,id);
		
		
	}
	
	
	

	public void deleteBookedPackage(int tpBookId) {
		
		dao.deleteBookedPackage(tpBookId);
		
		
	}

	public List<TourBooking> generateReport(int menu) {
		// TODO Auto-generated method stub
		
		return dao.generateReport(menu);
		
		
		
		
		
		
	}

}
			
			/* List<com.projectazure.hibernate.beans.TourBooking> viewList = new ArrayList<com.projectazure.hibernate.beans.TourBooking>();
				List<com.projectazure.struts.beans.TourRequestBean> strutsList = new ArrayList<com.projectazure.struts.beans.TourRequestBean>();
				
				for(int i=0;i<viewList.size();i++)
				{
					TourRequestBean strutBean=new TourRequestBean();
				     
				
					strutsList.add(i,strutBean);
					strutsList.get(i).setPackageId(viewList.get(i).getUserId());
					strutsList.get(i).setUserId(viewList.get(i).getUserId());
					strutsList.get(i).setPassengerCount(viewList.get(i).getPassengerCount());
					strutsList.get(i).setRequirements(viewList.get(i).getRequirements());
					strutsList.get(i).setAvailDiscount(viewList.get(i).getAvailDiscount());
					
					
					
				}
				
				
				
				for (Iterator iterator = viewList.iterator(); iterator
						.hasNext();) 
				{
					TourBooking tourBean = (TourBooking) iterator
							.next();
					
					TourRequestBean bean=new TourRequestBean();
					bean.setUserId(tourBean.getUserId());
					strutsList.add(bean);
					
					
					
				}
				
			
				
				
				
				
			
				return  strutsList;

		}*/
	

