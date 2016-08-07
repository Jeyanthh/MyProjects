/**
 * 
 *//*
package com.projectazure.util;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.projectazure.constants.GenericConstants;
import com.projectazure.struts.beans.TourPackageBookingRequest;

*//**
 * @author 734345
 *
 *//*
public class BookTourPackageJMSClient {

This method is used to send the message to the queue.	
	public void bookTourPackage(TourPackageBookingRequest tpRequest)
	{
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
            ObjectMessage objMsg = session.createObjectMessage();
            
            
           
            objMsg.setObject(tpRequest);
            sender.send(objMsg);
           
 
            session.close();
        }catch(Exception e){e.printStackTrace();}
	}
}
*/