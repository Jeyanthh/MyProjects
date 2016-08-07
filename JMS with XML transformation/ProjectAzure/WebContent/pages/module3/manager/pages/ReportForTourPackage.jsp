<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList, java.util.Iterator,com.projectazure.struts.beans.TourAddPackage" %>

<form action="reportTourPackage">
<ol>
<li>
        	<label >Package Name</label>
        	<select name="menu">

  	
  	

        	
        	<%
				ArrayList packageList = (ArrayList)session.getAttribute("tourPackageList");
				Iterator itr = packageList.iterator();
				int i = 0;
				while(itr.hasNext()) {
					
				TourAddPackage tourPackage = (TourAddPackage) itr.next();
			%>
                   <option value="<%= tourPackage.getPackageId()%>"><%= tourPackage.getPackageName()%> </option>

			
				<%
					}
				%>
        	
      	</select>
  	
        </li>
        
        
        
        
        
        
       
        
        
  <center>
        	<input id="formbutton" type="submit" value="Generate Report"/>
        	<input id="formbutton" type="reset" value="Reset"/>
        	
        	</center>
        </li>
  
  </ol>      
 </form>