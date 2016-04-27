<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">GAPP</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav navbar-right">
         <li role="presentation"  class="active"><a href="displayApplications.html?id=${userId}">Home</a></li>
		 <li role="presentation"><a href="addNewApplication.html?id=${userId}">Add Application</a></li>
		 <li role="presentation"><a href="addStudentBackground.html?studentId=${userId}">Add Student Background</a></li>
		 <li role="presentation"><a href="login.html">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="page-header">
	<h3> Display Applications</h3>
</div>
<form action="adddepartment.html" method="POST">
<div class="row">
	<div class="col-lg-12">
	<div class="col-lg-12">
			<table class="table">
			<tr>
		   		<th>Student First Name</th>
		   		<th>Student Last Name</th>
		   		<th>Program Name</th>
		   		<th>Term Season</th>
		   		<th>Student Year</th>
	   			<th>Submit Date</th>
		   		<th>Operation</th>
		   		<th>Operation</th>
		   		<th>Application Status</th>
				
			</tr>
		<c:forEach var="app" items="${applications}">
	   		<c:if test="${student.userId == app.userId.userId }">
	   		<tr>
		   		<td><c:out value="${ app.userId.userFirstName }"/></td>
		   		<td><c:out value="${ app.programId.programName}"/></td>
		   		<td><c:out value="${ app.programId.department.departmentName}"/></td>
		   		<td><c:out value="${ app.termSeason}"/></td>
		   		<td><c:out value="${ app.termYear}"/></td>
		   		<!-- 
		   		<td>
			   		<c:forEach var="appStatus" varStatus="index" items="${ app.applicationStatus }">
							<c:if test="${ index.last }">
								<c:out value="${ appStatus.applicationStatus}"/>
							</c:if>
					</c:forEach>
		   		</td>
		   		 -->
		   		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${app.submittedDate }"/></td>
				<td><a href="viewApplication.html?id=${app.applicationId }">View</a></td>
				<c:if test="${app.isSubmitted eq false }">
					<td>
						<a href="EditApplication.html?studentId=${app.userId.userId}&applicationId=${app.applicationId}">Edit</a>
					</td>
					<td>Not Submitted
					</td>
				</c:if>
			
			</tr>
			</c:if>
		</c:forEach>
	 

		</table>
		
	</div>
	
	
	
		
		
</div>
</div>
</form>	
</body>
</html>