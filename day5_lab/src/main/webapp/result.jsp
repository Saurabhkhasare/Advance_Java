<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">Hello,${sessionScope.student_details}</h4>
	<%
	session.invalidate();
	%>
	<h5>Addmission Successfull</h5>
	<h5>
	 <a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>