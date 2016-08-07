<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, java.util.Iterator, com.projectazure.struts.beans.LoyaltyPoints" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="viewUpdateLoyaltyPoints">
Search<select name="menu"><option value="loyaltyPointsId">Loyalty Points ID </option><option value="userId">User ID </option><option value="loyaltyPoints">Loyalty Points</option><option value="achievedBy">Achieved By </option><option value="achievedDate">Achieved Date</option><option value="expirtDate"> Expiry Date  </option></select><input type="text" ><br>
<table border="3">

<tr><th>Loyalty Points ID</th><th>Loyalty Points</th><th>Achieved By</th><th>Achieved Date</th><th>Expiry Date</th><th>User ID</th></tr>

<%

				ArrayList loyaltyList = (ArrayList)session.getAttribute("loyaltyPointsList");
				Iterator iltr = loyaltyList.iterator();
				
				while(iltr.hasNext()) {
					
				LoyaltyPoints loyaltyPoints = (LoyaltyPoints) iltr.next();
				
			%>
			

					<tr>
						 <td><%=loyaltyPoints.getLoyaltyPointsId()%></td>
							<td><%=loyaltyPoints.getLoyaltyPoints() %></td>
							<td><%=loyaltyPoints.getAchievedBy()%></td>
							<td><%=loyaltyPoints.getAchievedDate() %></td>
							<td><%=loyaltyPoints.getExpiryDate() %></td>
							<td><%=loyaltyPoints.getUserId() %></td>
						<td><input type="radio"  value="<%=loyaltyPoints.getLoyaltyPointsId()%>" name="validate"></td>
 						</tr>
					<%} %>
					
					</table>
		<input id="formbutton" type = "submit" name ="update" value= "update">			
	</form>	

</body>
</html>