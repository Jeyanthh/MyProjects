<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ page import="com.projectazure.hibernate.beans.DealerBean, com.projectazure.service.VehicleandDealerService ,java.util.HashMap,java.util.List, java.util.ArrayList, java.util.Iterator"%>

<form action="vehicle">

	<p>Send us your comments and feedback:</p>

	<ol>
        
        <li>
        	<label for="vehicleNo">Vehicle Number</label>
        	<input type="text"  name="vehicleNo"  />
        </li>
        
        <li>
        	<label for="vehicleType">Vehicle Type</label>
        	<!-- <input type="text" name="vehicleType"  /> -->
        	<select name="vehicleType">
        	<option value="Indica">Indica</option>
        	<option value="Innova">Innova</option>
        	<option value="Tempo">Tempo</option>
        	
        	</select>
        </li>
        
        <li>
        	<label for="dealerId">Dealer Name</label>
        	<select name="dealerId" >
        	<%
				    VehicleandDealerService service=new VehicleandDealerService();
					ArrayList serviceList = (ArrayList) service.viewTransport();
					Iterator itr = serviceList.iterator();
					int i = 0;
					while (itr.hasNext()) {

						DealerBean dealerBean = (DealerBean) itr.next();
				%>
                   <option value=<%=dealerBean.getDealerId()%>><%=dealerBean.getDealerName()%></option>

				
				<%
					}
				%>
        	</select>
        </li>
        
        <li>
        	<label for="committedDate">Committed Date</label>
        	<input type="date" name="committedDate" />
        </li>
        
                <li >
        <center>
        	<input id="formbutton" type="submit" value="Add Vehicle"/>
        	
        	</center>
        </li>
	
    </ol>
    </form>

