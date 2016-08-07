<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="java.util.ArrayList,java.util.Iterator,com.projectazure.struts.beans.TourRequestBean"%>


<form action = "updateBookedPackage">

<% TourRequestBean tpRequest =  (TourRequestBean)session.getAttribute("update"); %>
<ol>
        
        <li>
        <label>Book Id</label>
        <input type= "text" value = <%= tpRequest.getTpBookId() %> name = "tpBookId">
        
        
        <li>
        <label>Package Id</label>
        <input type= "text" value = <%= tpRequest.getPackageId() %> name = "packageId">
        
        </li>
        <li>
         <label>User Id</label>
        <input type= "text" value = <%= tpRequest.getUserId() %> name = "userId">
        </li>
       <%--  <li>
       
        <label>Date of Travel</label>
        <input type= "date" value = <%= tpRequest.getDateofTravel() %>>
        </li> 
         --%>
        <li>
        <label>no of passengers</label>
        <input type= "text" value = <%= tpRequest.getPassengerCount() %> name = "passengerCount">
        </li>
        <li>
        <label>Requirements</label>
        <input type= "text" value = <%= tpRequest.getRequirements() %> name = "requirements">
        </li>
        <li>
        <label>Avail Discount</label>
        <% 
         if(tpRequest.getAvailDiscount().equalsIgnoreCase("yes")) {%>
         
        <input type= "radio" value = "yes" name = "availDiscount" checked="checked" >yes
        <input type = "radio" value = "no" name = "availDiscount">No
        <%}
        else {
        %> <input type= "radio" value = "yes" name = "availDiscount"  >yes
        <input type = "radio" value = "no" name = "availDiscount" checked="checked">No
       <%} %>
       
        </li>
        
         <li >
        <center>
        	<input id="formbutton" type="submit" value="updatePackage"/>
        		</center>
        </li>
	
    </ol>
        	
        

</form>