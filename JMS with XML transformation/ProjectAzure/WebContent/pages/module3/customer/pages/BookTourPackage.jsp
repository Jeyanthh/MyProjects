<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.projectazure.struts.action.TourPackageAdminAction"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tour Package Booking </title>
</head>
<body>
<form action = "bookTourPackage">


<ol>

<li>
        	<label>Package Id</label>
        	<input type = "text" name = "packageId" value="<%=request.getParameter("packageId")%>">
        	
        </li>


      <li>
        	<label>User Id</label>
        	<input type="text" name="userId"  />
        </li>
        
      <li>
        	<label>Date Of Travel</label>
        	<input type = "date" name = "dateofTravel" required >
        </li>
        
         <li>
        	<label>No of Passengers</label>
        	<input type = "text" name = "passengerCount" required >
        </li>
        
         <li>
        	<label>Requirements</label>
        	<select name = "requirements" >
          <option value="food">Food</option>
          <option value="accommodation">Accommodation</option>
          <option value="foodandaccommodation">FoodandAccommodation</option></select>
        </li>
        
         <li>
        	<label>Avail Discount</label>
        	<input type = "radio" name  = "availDiscount" value = "yes">Yes
        	<input type = "radio" name = "availDiscount" value = "no">No
        </li>
        
          <li >
        <center>
        	<input type= "submit" name = "submit" value = "BookTourPackage" id = "formbutton">
            <input type= "reset" name = "reset" value = "reset" id = "formbutton">
        	
        	</center>
        </li>
     </ol>   


</form>
</body>
</html>



<!-- <tr>
<td>PackageId</td>
<td><input type = "text" name = "packageId"  ></td>
</tr>

<tr>
<td>UserId</td>
<td><input type = "text" name = "userId" ></td>
</tr>

<tr>
<td>Date Of Travel</td>
<td><input type = "date" name = "dateofTravel" required ></td>
</tr>


<tr>
<td>No of Passengers</td>
<td><input type = "text" name = "passengerCount" required ></td>
</tr>

<tr>
<td>requirements</td>
<td><select name = "requirements" >
<option value="food">Food</option>
<option value="accommodation">Accommodation</option>
<option value="foodandaccommodation">FoodandAccommodation</option></select>
</td>
<input type= "text" name = "requirements"></td>
</tr>
<tr>
<td>Avail Discount</td>
<td><input type = "radio" name  = "availDiscount" value = "yes">Yes</td>
<td><input type = "radio" name = "availDiscount" value = "no">No</td>
</tr>

<tr>
<td colspan = "2">
<input type= "submit" name = "submit" value = "BookTourPackage" id = "formbutton">
<input type= "reset" name = "reset" value = "reset" id = "formbutton"></td>
</tr>
</table>
 -->


