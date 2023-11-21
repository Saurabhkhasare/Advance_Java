package DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    
	private static Connection cn;
	
	//add a method to open connection i.e fixed connection
	
	public static Connection openConnection() throws SQLException {
		// optional : load JDBC driver class
		//	Class.forName("com.mysql.cj.jdbc.Driver");
		
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
       
		return cn;
		
	}
	
	// add a method to close DB Connection
	
	public static void closeConnection() throws SQLException {
		if(cn != null)
			cn.close();
	}
   
	//add a getter to connection
	public static Connection getCn() {
		return cn;
	}

	
	
}
