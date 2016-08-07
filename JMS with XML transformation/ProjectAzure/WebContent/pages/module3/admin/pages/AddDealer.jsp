<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<form action="dealer">

	<p>Send us your comments and feedback:</p>

	<ol>
        
        <li>
        	<label for="dealername">Dealer Name</label>
        	<input type="text"  name="dealerName"  />
        </li>
        
        <li>
        	<label for="dealerContact">Contact Number</label>
        	<input type="text" name="dealerContact"  />
        </li>
        
         <li>
        	<label for="dealerAddress">Address</label>
        	<textarea name="dealerAddress" id="message"></textarea>
        </li>
        
                <li >
        <center>
        	<input id="formbutton" type="submit" value="Add Dealer"/>
        	
        	</center>
        </li>
	
    </ol>
    </form>

