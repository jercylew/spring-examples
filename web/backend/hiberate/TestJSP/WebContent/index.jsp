<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome friend</title>
</head>
<body>
	<h2>The first JSP page</h2>

	<form action="welcome" method="post">
		<input type="text" name="uname">
		<input type="submit"
			value="go"><br />
	</form>

	<%
		out.println("<h3>This is from java code</h3>");
	%>
</body>
</html>