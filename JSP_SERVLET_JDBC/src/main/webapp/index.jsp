<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP_SERVLET_JDBC</title>
</head>
<body>
<h1>Login Here</h1>
<form action="Login" method="post">
<table>
<tr><td>UserName :</td> <td><input type="text" name="username" value=""></td> </tr>
<tr><td>Password :</td> <td><input type="password" name="password" value=""></td> </tr>
<tr><td><input type="reset"> </td><td><input type="submit"></td> </tr>
</table>
<p>New User? <a href="register.jsp">click here </a> to register.</p>
</form>
</body>
</html>