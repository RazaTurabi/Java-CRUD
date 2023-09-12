<%@page import="java.sql.PreparedStatement"%>
<%@page import="DatabaseRelated.DatabaseConnection"%>
<%@page import="java.sql.Connection"%>
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
int id = Integer.parseInt(request.getParameter("id"));
out.println(id);

try {
	Connection connection = DatabaseConnection.connectToDb();
	PreparedStatement ps = connection.prepareStatement("delete from emp where id=?");
	ps.setInt(1, id);
	ps.executeUpdate();
	response.sendRedirect("home.jsp");
	
}catch(Exception e) {
	e.printStackTrace();
	out.println(e.getMessage());
}

%>
</body>
</html>