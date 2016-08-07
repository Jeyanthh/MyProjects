<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="java.util.ArrayList,java.util.Iterator,com.projectazure.hibernate.beans.TourBooking"%>
<form action="GenerateAs">
<table border="2">
<th>UserId</th>
<th>PackageId</th></tr>

			<%
									ArrayList bookList = (ArrayList) session
												.getAttribute("ShowList");
										Iterator itr = bookList.iterator();

										while (itr.hasNext()) {

											TourBooking tourBooking = (TourBooking) itr.next();
								%>



			<tr>
				<td><%=tourBooking.getUserId()%></td>
				<td><%=tourBooking.getTourPackage().getPackageId()%></td>
					</tr>
		
			<%
				}
			%>
			<a href="ExportAsPackagePdf">Export As PDF</a>
<a href="ExportAsPackageExcel">Export As Excel</a>
		</table>	
		<input type = "submit" name = "submit" value = "Submit">
		</form>