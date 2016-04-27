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
	<h3> Edit Application</h3>
</div>
<form:form modelAttribute="application" enctype="multipart/form-data" >
<div class="row">
	<div class="col-lg-12">
		<!-- Application -->
		<div class="col-lg-6">
			<div class="col-lg-12">
				<div class="col-lg-8">
					<input name="applicationId" value="${application.applicationId }" type="hidden"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Department Name</div>
				<div class="col-lg-8">
					${application.programId.department.departmentName}
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Program Name</div>
				<div class="col-lg-8">
					<select name="programId">
						<c:forEach items="${programs }" var="pro">
							<option <c:if test="${application.programId.programName eq pro.programName}"> selected</c:if>  value="${pro.programId }">${pro.programName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
		</div>
		<!-- End Application -->
		<!-- User -->
		<div class="col-lg-6">
			<div class="col-lg-12">
				<div class="col-lg-4">User Email</div>
				<div class="col-lg-8">
					<input class="form-control" name="userEmail" value="${users.userEmail }" type="email"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Password:</div>
				<div class="col-lg-8">
					<input type="password" class="form-control" value="${users.userPassword }"  name="userPassword"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">First Name</div>
				<div class="col-lg-8">
					<input class="form-control" name="userFirstName" value="${users.userFirstName }" type="text"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Last Name</div>
				<div class="col-lg-8">
					<input  class="form-control" name="userLastName" value="${users.userLastName }" type="text"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Term Season</div>
				<div class="col-lg-8">
					<select name="termSeason">
						<option value="Winter" <c:if test="${application.termSeason eq 'Winter'}"> selected </c:if>>Winter</option>
						<option value="Spring" <c:if test="${application.termSeason eq 'Spring'}"> selected </c:if>>Spring</option>
						<option value="Summer" <c:if test="${application.termSeason eq 'Summer'}"> selected </c:if>>Summer</option>
						<option value="Fall" <c:if test="${application.termSeason eq 'Fall'}"> selected </c:if>>Fall</option>
					</select>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Term Year</div>
				<div class="col-lg-8">
					<select name="termYear">
						<c:forEach items="${years}" var="year">
							<option value="${year}" <c:if test="${application.termYear eq year}"> selected </c:if>> ${year} </option>
						</c:forEach>
					</select>
	
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">CIN</div>
				<div class="col-lg-8">
					<input name="userCIN" value="${application.userId.userCIN}"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Phone Number</div>
				<div class="col-lg-8">
					<input name="phoneNumber" value="${application.userId.phoneNumber}"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Birthdate</div>
				<div class="col-lg-8">
					<input name="dateOfBirth" value="${application.userId.dateOfBirth}"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Citizenship</div>
				<div class="col-lg-8">
					<input name="citizenship" value="${application.userId.citizenship}"/>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-4">Attachment</div>
				<div class="col-lg-8">
					<!-- add file -->
					<a href="downloadFile.html?name=${application.transcript}">Display Attachment</a>
					<input type="file" name="file"/>
					 <!-- add file -->
				</div>
			</div>
		</div>
		
		<!-- End User -->
	</div>
</div>
	

	<input name="userId" value="${application.userId.userId}" type="hidden"/>
	<!-- 
	<c:forEach items="${stubg }" var="sbg">
		<c:out value="${sbg.studentUniversity}"/>
		<c:out value="${sbg.studentDegree}"/>
		<c:out value="${sbg.studentDegreeFrom}"/>
		<c:out value="${sbg.studentDegreeTo}"/>
		<c:out value="${sbg.studentMajor}"/>
	</c:forEach>
	End Student Background -->
	

<br>
<button name="submit" value="Save" type="Submit">Save</button>
<button name="submit" value="Submit" type="Submit">Submit</button>


</form:form>


</body>
</html>