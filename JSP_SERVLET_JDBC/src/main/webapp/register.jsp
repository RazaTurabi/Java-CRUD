<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome and Register</h1>
<form action="Register" method="post">
<table>
<tr><td>UserName :</td> <td><input type="text" name="username" value=""> </td> </tr>
<tr><td>Phone :</td> <td><input type="tel" name="phone" value=""> </td> </tr>
<tr><td>Password :</td> <td><input type="text" name="password" value=""> </td> </tr>
<tr><td>Confirm password :</td> <td><input type="text" name="cpassword" value=""> </td> </tr>
<tr><td><input type="reset"> </td></tr>  <tr><td><input type="submit"></td></tr>
</table>
</form>

</body>
</html>