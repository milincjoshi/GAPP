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
         <li role="presentation"><a href="adminhome.html">Home</a></li>
		 <li role="presentation"  class="active"><a href="adddepartment.html">Department</a></li>
		 <li role="presentation"><a href="addprogram.html">Program</a></li>
		 <li role="presentation"><a href="addadditionalinfo.html">Additional Info</a></li>
			 <li role="presentation"><a href="login.html">Logout</a></li>
   
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<header class="page-header">
	<h3>Department</h3>
</header>
<form action="adddepartment.html" method="POST">
			
<div class="row">
	<div class="col-lg-12">
			<div class="col-lg-6">
			<h4><strong>Add a New Department</strong></h4>
				<div style="margin-top:2%;"  class="col-lg-12">
					<div class="col-lg-6">
						Department Name :	
					</div>
					<div class="col-lg-6">
						<input class="form-control" name="departmentName" type="text"/>
					</div>
				
				</div>
				<div style="margin-top:2%;"  class="col-lg-12">
					<input class="btn btn-primary pull-right" type="Submit" value="Submit"/>
				</div>
				
			</div>
			<div class="col-lg-6">
			<h4><strong>Manage</strong></h4>
				<table class="table">
				<tr>
					<th>
						Department Name
					</th>
					<th>
					No of Programs
					</th>
					<th>
						Operation
					</th>
					
				</tr>
				
				<c:forEach var="dept" items="${department}">
			   		<tr>
						<td>
							 <c:out value="${dept.departmentName}"/><p>
						</td>
						<td>
						<c:set var="pro" value="0" />
						<c:forEach var="dept" items="${dept.programs}">
							<c:set var="pro" value="${ pro+1 }"/>
						</c:forEach>
						${pro }	
						</td>
						<td>
					   		 <a href="editdepartment.html?departmentId=${dept.departmentId }">Edit</a>
						</td>
					</tr>
				</c:forEach>
			
				</table>
				
			</div>
			
			
			
				
				
		</div>
</div>
</form>	

</body>
</html>