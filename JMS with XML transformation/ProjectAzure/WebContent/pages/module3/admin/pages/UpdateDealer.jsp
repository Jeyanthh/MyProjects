<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ page import="com.projectazure.struts.beans.DealerBean ,java.util.HashMap,java.util.List, java.util.ArrayList"%>


<form action="updateDealer">
<% DealerBean dealerBean =  ( DealerBean)session.getAttribute("updateDealer");%>
		<ol>
        <li>
        	<label for="dealerId">Dealer Id</label>
        	<input type="text"  name="dealerId" value="<%=dealerBean.getDealerId()%>"  />
        </li>
        <li>
        	<label for="dealername">Dealer Name</label>
        	<input type="text"  name="dealerName"  value="<%=dealerBean.getDealerName()%>" />
        </li>
        
        <li>
        	<label for="dealerContact">Contact Number</label>
        	<input type="text" name="dealerContact"  value="<%=dealerBean.getDealerContact()%>" />
        </li>
        
         <li>
        	<label for="dealerAddress">Address</label>
        	<textarea name="dealerAddress" id="message" value="<%=dealerBean.getDealerAddress()%>"></textarea>
        </li>
       
        
                <li >
        <center>
        	<input id="formbutton" type="submit" value="Update Dealer"/>
        	
        	</center>
        </li>
	
    </ol>
	</form>
