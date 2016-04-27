<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
         <li role="presentation" ><a href="displayApplications.html?id=${userId}">Home</a></li>
		 <li role="presentation" ><a href="addNewApplication.html?id=${userId}">Add Application</a></li>
		 <li role="presentation" class="active"><a href="addStudentBackground.html?studentId=${userId}">Add Student Background</a></li>
		 <li role="presentation"><a href="login.html">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="page-header">
	<h3>Add Student Background</h3>
</div>
<form action="addStudentBackground.html" method="POST">
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-4">University</div>
		<div class="col-lg-8"><input type="text" name="studentUniversity"/></div>
	</div>
	<div class="col-lg-12">
		<div class="col-lg-4">Degree</div>
		<div class="col-lg-8"><input type="text" name="studentDegree"/></div>
	</div>
	<div class="col-lg-12">
		<div class="col-lg-4">From Year</div>
		<div class="col-lg-8"><input type="text" name="studentDegreeFrom"/></div>
	</div><div class="col-lg-12">
		<div class="col-lg-4">To Year</div>
		<div class="col-lg-8"><input type="text" name="studentDegreeTo"/></div>
	</div><div class="col-lg-12">
		<div class="col-lg-4">Major</div>
		<div class="col-lg-8"><input type="text" name="studentMajor"/></div>
	</div>
	<div class="col-lg-12">
		<button class="btn btn-primary" type="Submit">Add</button>
	</div>
</div>

<table class="table">
<tr>
	<th>University</th>
	<th>Degree</th>
	<th>From</th>
	<th>To</th>
	<th>Major</th>
</tr>
<c:forEach items="${StudentBackground}" var="studentbg">
	<tr>
		<td>
			${studentbg.studentUniversity}
		</td>
		<td>
			${studentbg.studentDegree }
		</td>
		<td>
			${studentbg.studentDegreeFrom }
		</td>
		<td>
			${studentbg.studentDegreeTo }
		</td>
		<td>
			${studentbg.studentMajor }
		</td>
		<td>
			<a href="removeStudentBackground.html?studentBackgroundId=${studentbg.studentBackgroundId }">Remove</a>
		</td>

	</tr>
</c:forEach>

</table>
</form>
</body>
</html>