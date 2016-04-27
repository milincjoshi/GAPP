<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form:form modelAttribute="students">

	<header class="page-header text-center">
		<h3>Sign Up <small> Welcome to GAPP</small></h3>
	</header>

<div class="row">
	<div class="col-lg-6 col-lg-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">
				Sign Up
			</div>
			<div class="panel-body">
				<div style="margin-top:2%;"  class="col-lg-12">
					<div class="col-lg-4">
						Email
					</div>
					<div class="col-lg-8">
						<form:input class="form-control" path="userEmail" type="email"/><form:errors path="userEmail"/>
					</div>
				</div>
				<div  style="margin-top:2%;" class="col-lg-12">
					<div class="col-lg-4">
						Password
					</div>
					<div class="col-lg-8">
						<form:input type="password" class="form-control"  path="userPassword"/><form:errors path="userPassword"/>
					</div>
				</div>
				<div  style="margin-top:2%;" class="col-lg-12">
					<div class="col-lg-4">
						First Name
					</div>
					<div class="col-lg-8">
						<form:input  class="form-control" path="userFirstName" type="text"/><form:errors path="userFirstName"/>
					</div>
				</div>
				<div  style="margin-top:2%;" class="col-lg-12">
					<div class="col-lg-4">
						Last Name
					</div>
					<div class="col-lg-8">
						<form:input  class="form-control" path="userLastName" type="text"/><form:errors path="userLastName"/>
					</div>
				</div>
				<div  style="margin-top:2%;" class="col-lg-12">
					<a href="login.html" class="btn btn-primary">Login</a>
			
						<input class="btn btn-primary  pull-right" type="Submit" value="Sign up"/>
				</div>
			</div>
		</div>	
	</div>
</div>

</form:form>
</body>
</html>