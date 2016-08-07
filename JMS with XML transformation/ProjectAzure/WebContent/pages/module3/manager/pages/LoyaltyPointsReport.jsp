<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loyaltyReport">
	<table>
		<tr>
			<td><h2>Select Criteria</h2></td>
		</tr>
		<tr>
			<td><select name="loyaltyReportPoints">
					<option>Loyalty Points</option>
					<option value="299">50-300</option>
					<option value="301">300-600</option>
					<option value="601">>600</option>
			</select></td>
		</tr>



		<br>


		<tr>
			<td><input id="formbutton"  type="submit" name="Generate Report"> 
			<input id="formbutton" type="reset" name="reset"></td>
		</tr>
	</table>
</form>

</body>
</html>