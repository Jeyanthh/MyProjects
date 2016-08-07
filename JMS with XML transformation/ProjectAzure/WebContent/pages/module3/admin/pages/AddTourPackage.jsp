<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form action="addTourPackage">

	

	<ol>
        
        <li>
        	<label >Package Name</label>
        	<input type="text" name="packageName" value="" required />
        </li>
   		<li>
        	<label >Package Type</label>
        	<input type="text" name="packageType" value="" required />
        </li>
		<li>
        	<label >Tour Place</label>
        	<input type="text" name="tourPlace" value="" required / >
        </li>
		<li>
        	<label >Price Per Head</label>
        	<input type="number" name="pricePerHead" value="" required />
        </li>

		 <li >
        <center>
        	<input id="formbutton" type="submit" value="Add Tour Package"/>
        	<input id="formbutton" type="reset" value="Reset"/>
        	
        	</center>
        </li>

</ol>


			
 </form>

