package all_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseRelated.DatabaseConnection;

public class Delete extends HttpServlet {

	public static void main(String[] args) {}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
resp.setContentType("text/html");
PrintWriter out = resp.getWriter();
out.println("<h1><centre><b> Delete Succesfully</b></centre></h1>");

String name= req.getParameter("username");
String phone= req.getParameter("phone");
String password=req.getParameter("password");

ResultSet rs;

try {
	
	Connection connection=DatabaseConnection.connectToDb();
	Statement sr =connection.createStatement();
	sr.executeUpdate("delete from emp where id=?");
	resp.sendRedirect("home.jsp");
	
} catch (Exception p) {
	p.printStackTrace();
	out.println(p.getMessage());
      
     }
	
   }

}
	
	
