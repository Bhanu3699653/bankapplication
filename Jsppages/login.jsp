<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=lightblue>
<h1>Login</h1>
	<form action="<%= request.getContextPath() %>/CustomerTransactionServlet">
		Enter the Account Number: <input type="text" name="acno"/><br><br>
		<input type="submit" value="submit"/>
		</form>
</body>
</html>
