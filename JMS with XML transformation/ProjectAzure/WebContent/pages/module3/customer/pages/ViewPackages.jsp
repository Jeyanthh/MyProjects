<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.ArrayList, java.util.Iterator,com.projectazure.struts.beans.TourAddPackage" %>
<form action = "bookTour">
<div>





     <%
				ArrayList packageList = (ArrayList)session.getAttribute("tourPackageList");
				Iterator itr = packageList.iterator();
				
				while(itr.hasNext()) {
					
				TourAddPackage tourPackage = (TourAddPackage) itr.next();
			%>
	<table>
			
			<tr>
						   
							<td><%=tourPackage.getPackageName() %></td>
							<td><%=tourPackage.getPackageType() %></td>
							<td><%=tourPackage.getTourPlace() %></td>
						    <td><%=tourPackage.getPricePerHead() %></td>
							<td><input type="radio" name="packageId" value="<%=tourPackage.getPackageId()%>"></td>
							</tr>
						
							
</table>		
<%} %>




</div>
        <center>
        	<input id="formbutton" type="submit" value="Book"/>
        	
        	
        	</center>	

</form>