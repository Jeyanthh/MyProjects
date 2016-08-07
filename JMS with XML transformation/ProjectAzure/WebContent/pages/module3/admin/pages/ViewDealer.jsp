<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.projectazure.struts.beans.DealerBean, com.projectazure.service.DealerService ,java.util.HashMap,java.util.List, java.util.ArrayList, java.util.Iterator"%>



<form action="request1">
			<table border="2">
				<tr background="gray">
					<th>DealerId</th>
					<th>Dealer Name</th>
					<th>Contact No</th>
					<th>Address</th>
					
				</tr>
				<%
				    DealerService service=new DealerService();
					ArrayList serviceList = (ArrayList) service.viewVehicle();
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
					
					
					<td><input type="checkbox" name="selectservice" value="<%=i%>"></td>
					<%
						i++;
					%>
				</tr>
				<%
					}
				%>
				<input type="Submit" value="request">
			</table>
			</form>
 
 
 
 
 
 



