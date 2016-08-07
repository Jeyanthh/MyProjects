<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page
	import="java.util.ArrayList,java.util.Iterator,com.projectazure.hibernate.beans.LoyaltyPoints"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loyaltyGenerateReport">
	<table>
		<tr>
			<td><h2>Select Criteria</h2></td>
		
			<td><select name="loyaltyPoints">
					<option>Loyalty Points</option>
					<option value="299">50-300</option>
					<option value="301">300-600</option>
					<option value="601">Above 600</option>
			</select></td>
		</tr>
		<br>
			<td><input type="submit" name="Generate Report"> <input
				type="reset" name="reset"></td>
		</tr>
	</table>
</form>
<h2>LoyaltyPoints</h2>
<form>

	<table border="2">

<tr>
			<td><a href="exportAsPDF">Export To PDF</a> <a href="exportAsEXCEL">Export To EXCEL</a></td>
		</tr>
		<tr>
			<th>LOYALTYPOINTSID</th>
			<th>LOYALTY POINTS</th>
			<th>ACHIEVEDBY</th>
			<th>ACHIEVEDDATE</th>
			<th>EXPIRYDATE</th>
			<th>USERID</th>
		</tr>
		<%
			ArrayList loyaltyPointsList = (ArrayList) session
					.getAttribute("loyaltyPointsReportList");
			Iterator itr = loyaltyPointsList.iterator();
			while (itr.hasNext()) {
				LoyaltyPoints loyaltyPoints = (LoyaltyPoints) itr.next();
		%>
		<tr>
			<td><%=loyaltyPoints.getLoyaltyPointsId()%></td>
			<td><%=loyaltyPoints.getLoyaltyPoints()%></td>
			<td><%=loyaltyPoints.getAchievedBy()%></td>
			<td><%=loyaltyPoints.getAchievedDate()%></td>
			<td><%=loyaltyPoints.getExpiryDate()%></td>
			<td><%=loyaltyPoints.getUserId()%></td>
		</tr>
		<%
			}
		%>
	
	</table>
</form>
</body>
</html> --%>