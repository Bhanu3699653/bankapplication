<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>

	<form action="<%= request.getContextPath() %>/CustomerTransactionServlet" method="post">
		Enter the Account Number: <input type="text" name="acno"/><br><br>
		
		<input type="submit" value="submit"/>
		</form>
</body>
</html>