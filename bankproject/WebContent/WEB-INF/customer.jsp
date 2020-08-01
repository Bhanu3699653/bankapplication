<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Fund Transfer</h1>
	<form action="<%= request.getContextPath() %>/CustomerServlet" method="post">
		Enter your Account Number: <input type="text" name="acno"/><br><br> 
		Enter the Person's Account Number: <input type="text" name="acno1"/><br><br>
		Enter the Date: <input type="text" name="dateoftx"/><br><br>
		Enter the Credit: <input type="text" name="credit"/><br><br>
		Enter the Withdrawl: <input type="text" name="withdrawl"/><br><br>
		
								<input type="submit" value="submit"/>		
	</form>
</body>
</html>