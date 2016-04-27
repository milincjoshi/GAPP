<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<link href='https://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet' type='text/css'>


</head>
<body style="font-family: 'Josefin Sans', sans-serif;font-size:2em;" class="container">
<div class="page-header">
	<h3> View Applications</h3>
</div>
<div class="col-lg-12">
	<div class="col-lg-6">
		<h3>
			<strong>
				Application Details
			</strong>
		</h3>
		<!-- 
		<div class="col-lg-12">
			<div class="col-lg-4">Application Id</div>
			<div class="col-lg-8">${application.applicationId }</div>
		</div>
		 -->
		<div class="col-lg-12">
			<div class="col-lg-4">Term</div>
			<div class="col-lg-8">${application.termSeason}</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Year</div>
			<div class="col-lg-8">${application.termYear }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Program Name</div>
			<div class="col-lg-8">${application.programId.programName }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Department Name</div>
			<div class="col-lg-8">${ application.programId.department.departmentName}</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Status</div>
			<div class="col-lg-8">
				<c:forEach var="appStatus" varStatus="index" items="${ application.applicationStatus }">
						<c:out value="${ appStatus.applicationStatus}"/>
				</c:forEach>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Attachment</div>
			<div class="col-lg-8">
			<a href="downloadFile.html?name=${application.transcript}">Display Attachment</a>
			</div>
		</div>
	</div>
	<div class="col-lg-6">
			<h3>
				<strong>
					User Details
				</strong>
			</h3>
			<div class="col-lg-12">
			<!-- 
			<div class="col-lg-4">User Id</div>
			<div class="col-lg-8">${application.userId.userId }</div>
		 	-->
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">First Name</div>
			<div class="col-lg-8">${application.userId.userFirstName }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Last Name</div>
			<div class="col-lg-8">${application.userId.userLastName }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Email</div>
			<div class="col-lg-8">${application.userId.userEmail }</div>
		</div>
		
		<div class="col-lg-12">
			<div class="col-lg-4">CIN</div>
			<div class="col-lg-8">${application.userId.userCIN }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Birthdate</div>
			<div class="col-lg-8">${application.userId.dateOfBirth }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Phone Number</div>
			<div class="col-lg-8">${application.userId.phoneNumber }</div>
		</div>
		<div class="col-lg-12">
			<div class="col-lg-4">Citizenship</div>
			<div class="col-lg-8">${application.userId.citizenship }</div>
		</div>
		
	</div>
	<div class="col-lg-12">
		<h3>
			<strong>
				Student Background
			</strong>
		</h3>
		<table class="table">
		<tr>
			<th>University</th>
			<th>Degree</th>
			<th>From</th>
			<th>To</th>
			<th>Major</th>
		</tr>
		<c:forEach var="studentbg" items="${application.userId.studentBackgroundId}">
		
		<tr>
			<td>
				${studentbg.studentUniversity}
			</td>
			<td>
				${studentbg.studentDegree}
			</td>
			<td>
				${studentbg.studentDegreeFrom}
			</td>
			<td>
				${studentbg.studentDegreeTo}
			</td>
			<td>
				${studentbg.studentMajor}
			</td>
			
		</tr>
		</c:forEach>
		</table>
		
	</div>
</div>


	
	
	
	
	




</body>
</html>