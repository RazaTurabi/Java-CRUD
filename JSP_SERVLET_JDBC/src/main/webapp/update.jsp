<%@page import="DatabaseRelated.DatabaseConnection"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int idd=0;
String name="";
String phone="";
String password="";

int id = Integer.parseInt(request.getParameter("id"));
out.println(id);

Connection connection = DatabaseConnection.connectToDb();
ResultSet rs;
String query = "select * from emp where id=?";
PreparedStatement ps = connection.prepareStatement(query);
ps.setInt(1, id);
rs = ps.executeQuery();

while(rs.next()) {
	
	idd=rs.getInt(1);
	name = rs.getString(2);
	phone = rs.getString(3);
	password = rs.getString(4);
	
	
	
	out.println(rs.getInt(1));
	out.println(rs.getString(2));
	out.println(rs.getString(3));
	out.println(rs.getString(4));

}



%>

<h1>Welcome To Update</h1>
<form action="Update" method="post">
<table>
<tr><td>Id :</td> <td><input type="number" name="idd" value="<%= idd%>"></td></tr>
<tr><td>UserName :</td> <td><input type="text" name="username" value="<%= name%>"></td></tr>
<tr><td>Phone :</td> <td><input type="tel" name="phone" value="<%= phone%>"></td></tr>
<tr><td>Password :</td> <td><input type="password" name="password" value="<%= password%>"></td></tr>
<tr><td><input type="reset"></td> <td><input type="submit"></td></tr>
</table>
</form>


</body>
</html>