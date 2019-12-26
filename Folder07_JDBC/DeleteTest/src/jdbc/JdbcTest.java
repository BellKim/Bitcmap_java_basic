package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	
	public JdbcTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DirverLoading Success! ");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Connection getConnection() {
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

	
	public int Delete(String id) {
		String sql = "DELETE FROM USERDTO"
				+ " WHERE ID = '"+id+"'";
		Connection conn = getConnection();
		Statement stmt = null;
		
		int count = 0;
		System.out.println("sql  : " + sql );
		
		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(stmt !=null) {
					stmt.close();
					}
					if(conn !=null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
		
	}//end delete
	
	public int Update(String id, int age) {
		String sql = "Update USERDTO SET"
				+ " age = "+ age
				+ "WHERE  ID ='"+id+"'";
		Connection conn = getConnection();
		Statement stmt = null;
		
		int count = 0;
		System.out.println("sql  : " + sql );
		
		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(stmt !=null) {
					stmt.close();
					}
					if(conn !=null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
		
	}//end delete
	
	
}//end of class
