<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Options</h1>
	<form action="<%= request.getContextPath() %>/CustomerTransactionServlet">
		<input type="submit" value="Transaction"/><br><br>
	</form>
	<form action="<%= request.getContextPath() %>/BalanceServlet">
		<input type="submit" value="Balance"/><br><br>
	</form>
	<form action="<%= request.getContextPath() %>/customer.jsp">
		<input type="submit" value="Transfer"/><br><br>
	</form>
</body>
</html>