package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBCLOSE;
import DB.DBCONNECTON;

public class UpdateTest {
	public UpdateTest() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Update(String id, int age) {
		String sql = "UPDATE USERDTO"
				+ " SET AGE = " + age+ " "
				+ " WHERE ID = '"+id+"' ";
		
		
		Connection conn = DBCONNECTON.getConnection();
		PreparedStatement stmt = null;
		
		int count = 0;
		System.out.println("작성된 sql : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			
			count = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCLOSE.close(stmt, conn, null);
		}
		
		
		return count>0?true:false;
		
	}
	
	
	
	
}//end updateTest class
