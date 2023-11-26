<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addmission.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter FirstName</td>
          <td><input type="text" name="fnm" /></td>
        </tr>
        <tr>
          <td>Enter LastName</td>
          <td><input type="text" name="lnm" /></td>
        </tr>
         <tr>
          <td>Enter Score</td>
          <td><input type="number" name="score" /></td>
        </tr>
         <tr>
          <td>Enter Course</td>
          <td><input type="text" name="course" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Login" /></td>
        </tr>
      </table>
    </form>
</body>
</html>