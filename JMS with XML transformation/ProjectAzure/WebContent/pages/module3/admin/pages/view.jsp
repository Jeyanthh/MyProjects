<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="java.util.Set,java.util.Iterator,com.projectazure.hibernate.beans.VehicleBean"%>



<form action="viewVehicle">
			<table border="2">
				<tr background="gray">
					<th>VehicleId</th>
					<th>VehicleType</th>
					<th>VehicleNO</th>
					<th>CommittedDate</th>
				</tr>
				<%
				Set<VehicleBean> vehicleSet = (Set<VehicleBean>)session.getAttribute("viewVehicle");
					Iterator itr = vehicleSet.iterator();
					int i = 0;
					while (itr.hasNext()) {

						VehicleBean vehicleBean = (VehicleBean) itr.next();
				%>


				<tr>
					<td><%=vehicleBean.getVehicleId()%></td>
					<td><%=vehicleBean.getVehicleNo()%></td>
					<td><%=vehicleBean.getVehicleType()%></td>
					<td><%=vehicleBean.getCommittedDate()%></td>
					
					
					<td><input type="radio" name="vehicleId" value="<%=vehicleBean.getVehicleId()%>"></td>
					<%
						i++;
					%>
				</tr>
				<%
					}
				%>
				<input type="Submit" value="vehicleUpdate">
			</table>
			</form>
 
 
 
 
 
 



