<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, java.util.Iterator,com.projectazure.struts.beans.TourAddPackage" %>
<body>
<!-- <form action="viewUpdate"> -->
<!-- <form action="deleteAction"> -->
<form action="selectAction">
Search<select name="menu"><option value="packageId">Package ID </option><option value="packageName">Package Name </option><option value="packageType">Package Type </option><option value="location">Location </option><option value="pricePerHead">Price Per Head   </option></select><input type="text" ><br>
<table border="3">

<tr><th>Package ID</th><th>Package Name</th><th>Package Type</th><th>Tour Place</th><th>Price Per Head</th></tr>

<%
				ArrayList packageList = (ArrayList)session.getAttribute("tourPackageList");
				Iterator itr = packageList.iterator();
				
				while(itr.hasNext()) {
					
				TourAddPackage tourPackage = (TourAddPackage) itr.next();
			%>
			

					<tr>
						 <td><%=tourPackage.getPackageId()%></td>
							<td><%=tourPackage.getPackageName() %></td>
							<td><%=tourPackage.getPackageType() %></td>
							<td><%=tourPackage.getTourPlace() %></td>
							<td><%=tourPackage.getPricePerHead() %></td>
							<td><input type="radio" name="selectpackageId" value="<%= tourPackage.getPackageId()%>"  ></td>
					
					<% } %>
					<li >
        <center>
        	<input id="formbutton" type="submit" name="select" value="Add Tour Package"/>
        	<input id="formbutton" type="submit" name="select" value="Edit Tour Package"/>
        	<input id="formbutton" type="submit" name="select" value="Delete Tour Package"/>
        
        	
        	</center>
        		</tr>
        </li>
					</table>
					
		
</form>
</body>
