<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Session ID<%=session.getId() %></h4>
<%--WC : seesion.getAttribute("user_details").getNAme() sent to client --%>
	<h4 align="center">Hello,${sessionScope.user_details.name}</h4>
	<%
	session.invalidate();
	%>
	<h5>You have logged out</h5>
	<h5>
	 <a href="index.jsp">Visit Again</a>
	</h5>
</body>
</html>