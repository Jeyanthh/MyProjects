package com.projectazure.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import com.projectazure.struts.beans.TourRequestBean;



public class XMLJavaConverter {

	ByteArrayOutputStream os = new ByteArrayOutputStream();
	byte[] xmlBytes;

	public String javaToXML(TourRequestBean tpRequest) {
		try {
			JAXBContext jAXBContext = JAXBContext.newInstance(TourRequestBean.class);
			Marshaller jaxbMarshaller = jAXBContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(tpRequest, os);
		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return os.toString();
	}
	public TourRequestBean XMLToJava(String xmlString) {
		TourRequestBean tpRequest = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TourRequestBean.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(xmlString.getBytes());
			tpRequest = (TourRequestBean) jaxbUnmarshaller.unmarshal(byteArrayIS);
			
		} catch(Exception exce) {
			exce.printStackTrace();
		}
		
		return tpRequest;
	}
}
