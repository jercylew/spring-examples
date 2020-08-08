<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= "Welcome "+ request.getParameter("uname") %>
</title>
</head>
<body>
	<%  //Scriptlet Tag
		String name = request.getParameter("uname");  
		out.print("<h1>Welcome " + name + "</h1>");
	%>
	
	<%! //Declaration Tag
		int cube(int n) {
			return n*n*n;
		}
	%>

	<!-- Expression Tag -->
	<%= "Cube of 3 is<h2>" + cube(3) + "</h2>" %>

	<!-- Config -->
	<% 
	String driverConf = config.getInitParameter("dname");  
	out.print("driver name is = " + driverConf);
	%>
	<br>
	
	<!-- Application -->
	<%
	out.print("Welcome " + request.getParameter("uname") + "<br>"); 
	String driverApp = application.getInitParameter("dname");  
	out.print("driver name is=" + driverApp);
	%>

</body>
</html>