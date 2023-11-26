<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%--transfer clnt's conversation state to JB 
 invoke all matching setters--%>
<jsp:setProperty property="*" name="user" />

</head>

<body>

	<%--Invoke B.L from JB --%>
	<h4>Status : ${sessionScope.user.registerVoter()}</h4>
</body>
</html>