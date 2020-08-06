<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=lightblue>
<h1>Options</h1>
	<form action="<%= request.getContextPath() %>/CustomerTransactionServlet">
	<input type="submit" value="Transaction"/>
	</form>
	<br>
	<form action="<%= request.getContextPath() %>/BalanceServlet">
	<input type="submit" value="Balance"/>
	</form>
	<br>
	<form action="<%= request.getContextPath() %>/customer.jsp">
	<input type="submit" value="Fund Transfer"/>
	</form>
</body>
</html>