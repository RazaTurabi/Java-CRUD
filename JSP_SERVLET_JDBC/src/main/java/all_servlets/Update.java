package all_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseRelated.DatabaseConnection;

public class Update extends HttpServlet {

	public static void main(String[] args) {}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1><centre><b> Updated Sucessfully </b></centre></h1>");
		String name = req.getParameter("username");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		int id=Integer.parseInt(req.getParameter("idd"));
		
		out.println(name);
		out.println(phone);
		out.println(password);
		out.println(id);
		
		ResultSet rs;
		try {
			Connection connection=DatabaseConnection.connectToDb();
			PreparedStatement ps = connection.prepareStatement("update emp set name=?,phone=?,password=? where id=?");
			
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, password);
			ps.setInt(4, id);
			ps.executeUpdate();
			resp.sendRedirect("home.jsp");
			
		}catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    out.println(e.getMessage());
		}
	}
	
	

}
