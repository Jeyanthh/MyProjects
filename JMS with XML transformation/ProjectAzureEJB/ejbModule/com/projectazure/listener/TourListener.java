package com.projectazure.listener;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


import com.projectazure.dao.TourDao;
import com.projectazure.helper.XMLJavaConverter;
import com.projectazure.hibernate.beans.TourBooking;
import com.projectazure.struts.beans.TourRequestBean;


/**
 * Message-Driven Bean implementation class for: TourListener
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/MyQueue")})
public class TourListener implements MessageListener {

    /**
     * Default constructor. 
     */
    public TourListener() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	/*ObjectMessage msg = (ObjectMessage) message;
    	TourRequestBean tourRequest;
	     TourBooking tourBooking = new TourBooking();
    	TourDao tourDao = new TourDao();
    	
    	
		try {
			
			tourRequest = (TourRequestBean)msg.getObject();
			Date date = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(tourRequest
					.getDateofTravel());
			tourBooking.setDateofTravel(date);
			tourBooking.setPassengerCount(tourRequest.getPassengerCount());
	    	tourBooking.setAvailDiscount(tourRequest.getAvailDiscount());
	    	tourBooking.setRequirements(tourRequest.getRequirements());
	    	tourBooking.setPackageId(tourRequest.getPackageId());
	    	tourBooking.setUserId(tourRequest.getUserId());
	    tourDao.bookTourPackage(tourBooking);
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
    	*/
    	TextMessage msg = (TextMessage) message;
    
    	XMLJavaConverter converter = new XMLJavaConverter();
    	TourDao tourDao = new TourDao();
    	  
    	 TourBooking tourBooking = new TourBooking();
    	 try {
 			
    		 TourRequestBean tourRequest = converter.XMLToJava(msg.getText());
 			
    		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 			Date date = formatter.parse(tourRequest.getDateofTravel());
 		    tourBooking.setDateofTravel(new java.sql.Date(date.getTime()));
 		    Date bookingDate=new Date();
 		    tourBooking.setDateofBooking(new java.sql.Date(bookingDate.getTime()));
 			tourBooking.setPassengerCount(tourRequest.getPassengerCount());
 	    	tourBooking.setAvailDiscount(tourRequest.getAvailDiscount());
 	    	tourBooking.setRequirements(tourRequest.getRequirements());
 	    	tourBooking.setUserId(tourRequest.getUserId());
 	    	int id = tourRequest.getPackageId();
 	    	int totalAmount = (tourRequest.getPassengerCount() * (tourBooking.getTourPackage().getPricePerHead()));
 	    	tourBooking.setTotalAmount(totalAmount);
 	        tourDao.bookTourPackage(tourBooking,id);
 	    	
 		} catch (Exception e) {
 			// TODO Auto-generated catch blocks
 			e.printStackTrace();
 		}
    	
    	
    	
    	
    }

}
