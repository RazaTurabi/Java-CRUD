package all_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseRelated.DatabaseConnection;

public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("username");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		
		if(password.equals(cpassword)) {
			Connection connection = DatabaseConnection.connectToDb();
			String query = "insert into emp(name,phone,password) values(?,?,?)";
			
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, phone);
				ps.setString(3, cpassword);

				ps.executeUpdate();
				resp.sendRedirect("index.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			pw.println("Password Not Matching.");
		}
		
	}

	
	
}
