<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="/struts-tags"%>
    <head>
    

    <link href="<%=request.getContextPath()%>/css/template1/homepage.css"
	rel="stylesheet" type="text/css" />
	
    </head>
    <br/><br/>
    
    <div id="wholepage">
   <div id="topportion">
   <div id="topleft">
   <fieldset id="field">
		<legend>Login</legend>
		<form action="login" class="pure-form pure-form-aligned" method="post">
		
		<label >UserName</label>	
		<input  type="text" name="userName" placeholder="Username"> <br>
		<label >Password</label>
	    <input  type="password" name="password" placeholder="Password"><br>
		<input  type="submit" id="formbutton" value="Sign In">
		
		</form>
		<br>
		<br>
		<div style="font-size: 13px"><html:a href="changePassword">Change Password</html:a> | <html:a>Forget Password</html:a></div>
		<br>
		<form action="signup" id="login-form">
		
		<input type="Submit" value="Sign Up">
		</form>
		</fieldset>
		<br>
		<br>
   
   </div>
      <div id="topright"></div>
   </div>

   
    </div>
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<%-- <div style="padding:1px;height:350px;">
		<fieldset style="width: 225px; border-radius:25px">
		<legend></legend>
		<form action="login" id="login-form" style="width: 217px; " method="post">
		
				
		<input type="text" name="userName" placeholder="Username"> <br><br>
		<input type="password" name="password" placeholder="Password"><br><br>
		<input type="submit" value="Sign In" style="width: 117px;">
		<!-- <s:submit name="submit" value="Sign In"/> -->
		<!-- <s:submit name="submit" label	="Sign In"style="width: 117px;"/> -->
		</form>
		<br>
		<br>
		<div style="font-size: 13px"><html:a href="changePassword">Change Password</html:a> | <html:a>Forget Password</html:a></div>
		<br>
		<form action="signup" id="login-form">
		
		<input type="Submit" value="Sign Up"style="width: 117px; ">
		</form>
		</fieldset>
		<br>
		<br>
	<!-- 	<div style="height: 230px; width: 247px;border-left-width: thick;
	border-left-style: solid;
	border-left-color: #E5E5E5;
	border-right-width: thick;
	border-right-style: solid;
	border-right-color: #E5E5E5;
	
	border-top-width: thick;
	border-top-style: solid;
	border-top-color: #E5E5E5;
	
	border-bottom-width: thick;
	border-bottom-style: solid;
	border-bottom-color: #E5E5E5;
	border-radius:35px;
	 "><br>
				<marquee direction="up"><a href="">Goa Package 3N/2D with Discount</a><br><br><br>
		<a href="">Thirupathi Package 3N/2D with Discount</a><br><br><br>
		<a href="">Simla Package 3N/2D with Discount</a></marquee></div> -->
		<div style="width: 869px; "><dl style="color: green;">Thought of The Day</dl><dt>Millions long for immortality
who don’t know what to do with themselves
on a rainy Sunday afternoon</dt></div>
<a href="viewBookTourPackage"> book package</a>

<a href="ViewAllTourPackage">ViewAllTourPackage </a>
<a href="VieweditLoyaltyPoints">Edit LoyaltyPoints</a>
		<!-- <h1>Your are in College Home Page. Please select the link to perform actions on College</h1> -->		
</div> --%>