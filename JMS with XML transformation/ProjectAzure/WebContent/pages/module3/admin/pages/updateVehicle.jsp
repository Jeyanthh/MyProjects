<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ page import="com.projectazure.struts.beans.VehicleBean ,java.util.HashMap,java.util.List, java.util.ArrayList"%>
<form action="update">
<% VehicleBean vehicleBean =  (VehicleBean)session.getAttribute("updateVehicle");%>
		<table>
		<tr>
				<td><label> Vehicle Id </label></td>
				<td><input type="text" name="vehicleId" id="vehicleId" required
					title="Enter the registered Vehicle ID" value="<%=vehicleBean.getVehicleId()%>"/></td>
			</tr>
			<tr>
				<td><label> Vehicle Number </label></td>
				<td><input type="text" name="vehicleNo" id="vehicleNo" required
					title="Enter the registered Vehicle Number" value="<%=vehicleBean.getVehicleNo()%>"/></td>
			</tr>
			<tr>
				<td><label> Vehicle Type </label></td>
				<td><input type="text" name="vehicleType" id="vehicleType" required
					title="Enter the registered Vehicle Type" value="<%=vehicleBean.getVehicleType()%>"/></td>
			</tr>
			
			
			<tr>
				<td><label> Committed Date </label></td>
				<td><input type="date" name="committedDate" id="committedDate"
					required
					title="Enter the date till the vehicle is in contact with CheeryBrown" value="<%=vehicleBean.getCommittedDate()%>"/>
				</td>
			</tr>
			<tr>
			<td><input type = "submit" value="submit"></td>
			</tr>

		</table>
	</form>
