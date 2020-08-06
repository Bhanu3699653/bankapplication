<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=lightblue>
<h1>Fund Transfer</h1>
<form action="<%= request.getContextPath() %>/CustomerServlet" method="get">
		Enter your Account Number: <input type="text" name="acno"/><br><br> 
		Enter the Person's Account Number: <input type="text" name="acno1"/><br><br>
		Enter the Date: <input type="text" name="dateoftx"/><br><br>
		Enter the Credit: <input type="text" name="credit"/><br><br>
		Enter the Withdrawl: <input type="text" name="withdrawl"/><br><br>
		
								<input type="submit" value="submit"/>		
	</form>
</body>
</html>