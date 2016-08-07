<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList, java.util.Iterator, com.projectazure.struts.beans.LoyaltyPoints"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditLoyaltyPoints</title>
</head>
<body>
	<form action="updateLoyaltyPoints">
		<%

			
					
LoyaltyPoints loyaltyPoints=(LoyaltyPoints)session.getAttribute("updateObject");
				
			%>

		<p>Please Enter the Required Details</p>

		<ol>

			<li><label>Loyalty Points ID</label> <input type="number"
				name="loyaltyPointsId"
				value="<%=loyaltyPoints.getLoyaltyPointsId()%>" /></li>

			<li><label>Loyalty Points</label> <input type="number"
				name="loyaltyPoints" value="<%=loyaltyPoints.getLoyaltyPoints() %>" />
			</li>

			<li><label>Achieved By</label> <input type="text"
				name="achievedBy" value="<%=loyaltyPoints.getAchievedBy()%>" /></li>

			<li><label>Achieved Date</label> <input type="text"
				name="achievedDate" value="<%=loyaltyPoints.getAchievedDate() %>" disabled>
			</li>
			<li><label>Expiry Date</label> <input type="text"
				name="expiryDate" value="<%=loyaltyPoints.getExpiryDate() %>" disabled /></li>

			<li><label>User ID</label> <input type="number" name="userId"
				value="<%=loyaltyPoints.getUserId() %>" /></li>



			<li><input id="formbutton" type="submit" value="Send" /></li>

		</ol>
	</form>
</body>

</html>