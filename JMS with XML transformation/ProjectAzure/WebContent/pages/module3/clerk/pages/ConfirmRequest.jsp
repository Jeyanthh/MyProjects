<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="java.util.ArrayList,java.util.Iterator,com.projectazure.hibernate.beans.TourBooking"%>


<form action = "allocateVehicle">
		<h3>Booked Package Details</h3>
<table border="2">
					<tr background="gray">
						<th>UserId</th>
						<th>PackageId</th>
						<th>BookingId</th>
						<th>DateOfBooking</th>
						<th>DateOfTravel</th>
						<th>Requirements</th>
						<th>No of Passengers</th>
						<th>Avail Discount</th>
						<th>Status</th>
						<th>Remark</th>
						<th>TotalAmount</th>
						</tr>		
				
 	<%
									ArrayList bookList = (ArrayList) session
												.getAttribute("viewList");
										Iterator itr = bookList.iterator();

										while (itr.hasNext()) {

											TourBooking tourBooking = (TourBooking) itr.next();
								%>


			<tr>
				<td><%=tourBooking.getUserId()%></td>
				<td><%=tourBooking.getPackageId()%></td>
				<td><%=tourBooking.getTpBookId()%></td>
			     <td><%=tourBooking.getDateofBooking()%></td>
				<td><%=tourBooking.getDateofTravel()%></td>
			    <td><%=tourBooking.getRequirements()%></td>
			     <td><%=tourBooking.getPassengerCount()%></td>
				<td><%=tourBooking.getAvailDiscount()%></td>
				<td><%=tourBooking.getStatus()%></td>
				<td><%=tourBooking.getRemark()%></td>
				<td><%=tourBooking.getTotalAmount()%></td>
				
			
				
				
				<td><input type = "radio" name = "tpBookId" value = "<%=tourBooking.getTpBookId()%>"></td>
				
				
			</tr>
		
			<%
				}
			%>
		</table>	
		<input type = "submit" name = "submit" value = "Allocate">
		</form>
	