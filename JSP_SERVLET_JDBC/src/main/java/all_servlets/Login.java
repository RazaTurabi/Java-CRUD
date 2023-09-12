package all_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseRelated.DatabaseConnection;

public class Login extends HttpServlet {

	public static void main(String[] args) {}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		
		Connection connection = DatabaseConnection.connectToDb();
		ResultSet rs;
		
		String query = "select * from emp where name=? and password=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			if(rs.next()==false) {
				pw.println("user with this creadentials does not exist");
			}
			else {
				resp.sendRedirect("home.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
