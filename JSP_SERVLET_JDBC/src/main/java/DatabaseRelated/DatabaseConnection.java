package DatabaseRelated;

import java.sql.*;

public class DatabaseConnection {
	
	static Connection con;
	
    public static Connection connectToDb() 
    {
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String username = "root";
 		   String password = "root";
 		   String url = "jdbc:mysql://localhost:3307/emp_db";
    		con = DriverManager.getConnection(url,username,password);
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return con;
    }
}
