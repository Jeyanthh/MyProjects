<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="addLoyaltyPointsAction">

	

	<ol>
        
        <li>
        	<label >Loyalty Points</label>
        	<input type="number" name="loyaltyPoints" value="" required />
        </li>
   		<li>
        	<label >Achieved By</label>
        	<input type="text" name="achievedBy" value="" required />
        </li>
		<li>
        	<label >Achieved Date</label>
        	<input type="date" name="achievedDate" value="" required / >
        </li>
		<li>
        	<label >Expiry Date</label>
        	<input type="date" name="expiryDate" value="" required />
        </li>
        
        <li>
        	<label >User ID</label>
        	<input type="number" name="userId" value="" required />
        </li>

		 <li >
        <center>
        	<input id="formbutton" type="submit" value="addLoyaltyPoints"/>
        	<input id="formbutton" type="reset" value="Reset"/>
        	
        	</center>
        </li>

</ol>


			
 </form>