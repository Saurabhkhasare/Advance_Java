<%@page import="pojo.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation page</title>
</head>
<%!
//JSP declaration block to add variables and methods(implicit scope: private)
HashMap<String,User> userMap;
//override jspInit
public void jspInit()
{
	System.out.println("in init"+Thread.currentThread());
	//create n populate map
	userMap= new HashMap<>();
	userMap.put("Rama Vaidya", new User("Rama Vaidya","1234",30));
	userMap.put("Mihir Rao", new User("Mihir Rao","4567",34));
}
%>
<body>
<%
System.out.println("in scriplet"+Thread.currentThread());
//read request paramaters
String name = request.getParameter("em");
String password = request.getParameter("pass");
int age = Integer.parseInt(request.getParameter("age"));

//hashmap vallidation(get,checkpassword)

User users=userMap.get(name);
if(users != null)
{
	//name exist, now check for passsword
	if(users.getPassword().equals(password)){
		//login sucessful--. store all users details(age) under session scxope
		session.setAttribute("user_details", users);
		//redirect
		response.sendRedirect("details.jsp");
	}else{
		//invalid password,retry link
		%>
		<h4 style ="color:red;">
		Invalid Password !!!! pls a<a href="login.jsp">Retry</a>
		</h4>
		<% 	
	}
}else{
	//new user : register link
		%>
	<h4 style ="color:red;">
	New user !!! Do you want to <a href="register.jsp">Register</a>
	</h4>
	<% 
}
//new user(no name--> register link)
//invalid password-->retry link
//successfull login--> store user pojo in session scope
//redirect
%>
</body>
<%!
public void jspDestroy()
{
	System.out.println("in destroy"+Thread.currentThread());
}
%>
</html>