<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="removeprogram.html" method="POST">
	<select name="prog">
		<c:forEach var="pro" items="${program}">
	   		 <option>
		   		 <c:out value="${pro.programName} :-"/>  
	 		  	 <c:out value="${pro.department.departmentName}"/>
	   		 </option>
		</c:forEach>
	</select>
	<br>
	<input type="Submit" value="Remove" />
	<br>
	
	Program
	<br>
	<c:forEach var="pro" items="${program}">
   		 <c:out value="${pro.programName}"/><p>
   		  <c:out value="${pro.department.departmentName}"/><p>
   		  <br>
	</c:forEach>
</form>
</body>
</html>