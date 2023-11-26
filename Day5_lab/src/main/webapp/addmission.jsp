<%@page import="java.util.HashMap"%>
<%@ page import="pojos.Student" %>
<%@ page import="pojos.Course" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!
//JSP declaration block to add variables and methods(implicit scope: private)
HashMap<String,Student> studentMap;
//override jspInit
public void jspInit()
{
	System.out.println("in init"+Thread.currentThread());
	//create n populate map
	studentMap= new HashMap<>();
	studentMap.put("Rama", new Student("Rama","Vaidya",75,Course.valueOf("DAC")));
	studentMap.put("Mihir", new Student("Mihir","Rao",80,Course.valueOf("DITISS")));
}
%>
<body>
<%
System.out.println("in scriplet"+Thread.currentThread());
//read request paramaters
String Firstname = request.getParameter("fnm");
String Lastname = request.getParameter("lnm");
Course course = Course.valueOf(request.getParameter("course").toUpperCase());
int Score = Integer.parseInt(request.getParameter("score"));
   
Student students= studentMap.get(Firstname);
if(students != null){
	
	if(students.getMarks() > course.getMinMarks())
	{
		session.setAttribute("student_details", students);
		response.sendRedirect("result.jsp");
	}else{
		//less score,retry link
		%>
		<h4 style ="color:red;">
		Sorry you have a less Score.. Addmission Rejected..!!!
		<a href="login.jsp">Addmission Form</a>
		</h4>
		<% 	
	}
}
   %>
</body>
<%!
public void jspDestroy()
{
	System.out.println("in destroy"+Thread.currentThread());
}
%>
</html>