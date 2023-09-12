<%@page import="DatabaseRelated.DatabaseConnection"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Home</h1>
<%
Connection connection = DatabaseConnection.connectToDb();
ResultSet rs;
String query = "select * from emp";
try{
	Statement s = connection.createStatement();
	PrintWriter pw = response.getWriter();
	rs = s.executeQuery(query);%>
	
	<table border="1" cellspacing=0; cellpadding="10" align="center">
	  <thead>
	     <tr>
	        <th>ID</th>
	        <th>NAME</th>
	        <th>PHONE</th>
	        <th colspan="2">ACTION</th>
	     </tr>
	  </thead>
	  <tbody>
	  <%
	  while(rs.next()) {%>
		  
		   <tr>
	        <th><%= rs.getInt(1) %></th>
	        <th><%= rs.getString(2) %></th>
	        <th><%= rs.getString(3) %></th>
	        <th><a href="update.jsp?id=<%=rs.getInt(1)  %>">edit</a></th>
	        <th><a href="delete.jsp?id=<%=rs.getInt(1)%>">delete</a></th>
	     </tr>
	 <% } %> 
	  
	  </tbody>
	</table>
	
<% }catch(Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>