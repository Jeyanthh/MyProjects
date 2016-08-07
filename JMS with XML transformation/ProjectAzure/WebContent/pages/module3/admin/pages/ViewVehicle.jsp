<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.projectazure.hibernate.beans.DealerBean,com.projectazure.hibernate.beans.VehicleBean, com.projectazure.service.VehicleandDealerService ,java.util.HashMap,java.util.List, java.util.ArrayList, java.util.Iterator"%>



<form action="updateVehicleForm">
			<table border="2">
				<tr background="gray">
					<th>Vehicle Id</th>
					<th>Vehicle No</th>
					<th>Vehicle Type</th>
					<th>Committed Date</th>
					
				</tr>
				<%
				    VehicleandDealerService service=new VehicleandDealerService();
					ArrayList serviceList = (ArrayList) service.viewTransport();
					Iterator itr = serviceList.iterator();
					int i = 0;
					while (itr.hasNext()) {

						DealerBean dealerBean = (DealerBean) itr.next();
				%>


				<tr>
					
					<% 
					    Iterator iter1=dealerBean.getVehicleBeans().iterator();
					while (iter1.hasNext())
					{
			VehicleBean bean=(VehicleBean)iter1.next();
					%>
					<td><%=bean.getVehicleId()%></td>
					<td><%=bean.getVehicleNo()%></td>
					<td><%=bean.getVehicleType()%></td>
					<td><%=bean.getCommittedDate()%></td>
					
					
					<td><input type="radio" name="vehicleId" value="<%=bean.getVehicleId()%>"></td>
					<%
					}
				%>
				</tr>
				<%
					}
				%>
				<input type="Submit" value="Add Vehicle" name="vehicleAction">
				<input type="Submit" value="Update Vehicle" name="vehicleAction">
				<input type="Submit" value="Delete Vehicle" name="vehicleAction">
			</table>
			</form>
 
 
 
 
 
 



