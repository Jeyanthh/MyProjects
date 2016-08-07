<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.projectazure.hibernate.beans.DealerBean,com.projectazure.hibernate.beans.VehicleBean, com.projectazure.service.VehicleandDealerService ,java.util.HashMap,java.util.List, java.util.ArrayList, java.util.Iterator"%>



<form action="updateForm">
			<table border="2">
				<tr background="gray">
					<th>DealerId</th>
					<th>DealerName</th>
					<th>DealerContact</th>
					<th>DealerAddress</th>
					<th>Vehicle</th>
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
					<td><%=dealerBean.getDealerId()%></td>
					<td><%=dealerBean.getDealerName()%></td>
					<td><%=dealerBean.getDealerContact()%></td>
					<td><%=dealerBean.getDealerAddress()%></td>
					<td><a href="vehicleView"><%=dealerBean.getVehicleBeans().size()%></a></td>
					
					
					<td><input type="radio" name="dealerId" value="<%=dealerBean.getDealerId()%>"></td>
					<%
						i++;
					%>
				</tr>
				<%
					}
				%>
				<input type="Submit" value="Add Dealer" name="dealerAction">
				<input type="Submit" value="Update Dealer" name="dealerAction">
				<input type="Submit" value="Delete Dealer" name="dealerAction">
			</table>
			</form>
 
 
 
 
 
 



