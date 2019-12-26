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
	
	public int Insert(String id, String name, int age) {
		// createStatement, preparedStatement
		String sql = "INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE)" + 
					"VALUES('" + id + "','" + name + "'," + age+", SYSDATE)";
		Connection conn = this.getConnection();
		Statement stmt = null; // DB관련

		int count = 0; /// 데이터가 몇개 변경되었는지 확인 변수

		System.out.println("sql : " + sql);
		try {

			stmt = conn.createStatement();// 연결 상태 확인.
			count = stmt.executeUpdate(sql);
			System.out.println("성공적으로 추가되었습니다. ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	
}//end of class
