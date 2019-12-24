package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCONNECTON {
	
	public DBCONNECTON() {
		// TODO Auto-generated constructor stub
	}


	public static void initConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DirverLoading Success! ");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
										//해당주소는 DB의 properties - driverproperties 에 주소가있음.
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.26:1521:xe", "hr", "hr");
			System.out.println("DB CONnection success!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	
	

}
