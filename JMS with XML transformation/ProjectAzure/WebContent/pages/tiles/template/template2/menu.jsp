<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="/struts-tags"%>
	<div class="gadget">
		<h2 class="star"><span>College Menu</span></h2>
		<div class="clr"></div>

			<ul class="sb_menu" id="sidebarmenu1">
				<li class="active">
					<html:a href="addCollegePage">Add College</html:a>
				</li>
				<li>
					<html:a href="viewCollegeAction">View College</html:a>
				</li>
				<li>
					<html:a href="deleteCollegePage">Delete College</html:a>
				</li>
				<li>
					<html:a href="editCollegePage">Update College</html:a>
				</li>
			</ul>
	</div>
