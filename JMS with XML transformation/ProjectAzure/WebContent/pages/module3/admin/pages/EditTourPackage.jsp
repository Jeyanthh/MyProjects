<%@page import="java.util.Date"%>

<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.projectazure.hibernate.beans.TourPackage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ page import="java.util.ArrayList, java.util.Iterator,com.projectazure.hibernate.beans.TourBooking,com.projectazure.struts.beans.TourAddPackage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="editTourPackage">
<% 
TourPackage  tourPackage=(TourPackage)session.getAttribute("updateForm");
TourBooking tourPackage1 = new TourBooking();

 Set<TourBooking> tourPackagesSet=new HashSet<TourBooking>();
	tourPackagesSet=tourPackage.getTourBooking();
  Iterator iterator = tourPackagesSet.iterator(); 
      boolean packageBooked=false;
      // check values
      while (iterator.hasNext()){
       TourBooking tourBooking=(TourBooking)iterator.next();

Date date= tourBooking.getDateofTravel();
Date presentDate=new Date();
int diffInDays = (int)( (date.getTime() - presentDate.getTime()) 
        / (1000 * 60 * 60 * 24) );
      
      
      if(diffInDays<0)
      {
    	  
    	  packageBooked=true;
      }
      }
      
      

%>
	

	<ol><li>
        <lable>Package Id</lable><input type="text" name="packageId" value=<%=tourPackage.getPackageId()%>> </li>
        <li>
        	<label >Package Name</label>
        	<input type="text" name="packageName" value=<%=tourPackage.getPackageName()%>>
        </li>
   		<li>
        	<label >Package Type</label>
        	<input type="text" name="packageType" value=<%=tourPackage.getPackageType()%>>
        </li>
		<li>
        	<label >Tour Place</label>
        	<input type="text" name="tourPlace" value=<%=tourPackage.getLocation()%>>
        </li>
		<li>
        	<label >Price Per Head</label>
        	<input type="text" name="pricePerHead" value=<%=tourPackage.getPricePerHead()%>>
        </li>

		 <li >
        <center>
        	<input id="formbutton" type="submit" value=" Submit"/>
        	<input id="formbutton" type="reset" value="Reset"/>
        	
        	</center>
        </li>

</ol>


			
 </form>