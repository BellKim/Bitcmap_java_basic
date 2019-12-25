package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public DBConnection() {
	
	}
	
	public static void initConnection() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DBCONNECTION initconnection success! \n initconnection");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();

		}finally {
			
		}
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.10:1521:xe","hr","hr");
			System.out.println("DBCONNECTION SUCCESS!! \n getConnection()");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
}//end class
