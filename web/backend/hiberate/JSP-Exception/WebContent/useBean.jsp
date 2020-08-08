<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="obj" class="com.javatpoint.Calculator"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsp:useBean demo</title>
</head>
<body>
	<%  
	int m = obj.cube(5);  
	out.print("cube of 5 is "+m);  
	%>
</body>
</html>