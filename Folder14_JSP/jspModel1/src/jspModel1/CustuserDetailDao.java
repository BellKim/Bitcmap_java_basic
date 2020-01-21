package jspModel1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustuserDetailDao {
	private static CustuserDetailDao dao = null;
	private CustuserDetailDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CustuserDetailDao getInstance() {
		if(dao==null) {
			dao = new CustuserDetailDao();
		}
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String password="hr";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	
	
	
	
	
	
	
	public CustUserDto getUserInfo(String id){
		String sql = " SELECT ID, NAME, ADDRESS "
				+ " FROM CUSTUSER "
				+ " WHERE id= ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		CustUserDto dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String _id = rs.getString("ID");
				String _name = rs.getString("NAME");
				String _address = rs.getString("ADDRESS");
				dto = new CustUserDto(_id, _name, _address);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
		return dto;
	}//end getUserInfo();;;
	
	
	public boolean DeleteUser(String id){
		String sql = " DELETE custuser " + 
					 " WHERE id= ? ";
		
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			
			count = psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, psmt, null);
			
		}
		return count>0?true:false;
		
	}//end getUserInfo();;;
	
	

	public boolean setUpdate(String id, String address){
		String sql = " DELETE custuser " + 
					 " WHERE id= ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			
			count = psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, psmt, null);
			
		}
		return count>0?true:false;
		
	}//end getUserInfo();;;
	
	
	
	
	
	
	
	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
			try {
				if(conn!=null) {				
					conn.close();
					}
				if(psmt!=null) {				
					psmt.close();
					}
				if(rs!=null) {				
					rs.close();
					}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

}//end classs
