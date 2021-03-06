package jspModel1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustUserDao {
	private static CustUserDao dao = null;
	
	private CustUserDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CustUserDao getInstance() {
		if(dao == null) {
			dao = new CustUserDao();
		}
		return dao;
		
	}//CustUserDao
		public Connection getConnection() throws SQLException{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String password="hr";
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		}
		
		public List<CustUserDto> getCustUserList(){
			String sql = " SELECT ID, NAME, ADDRESS "
					+ " FROM CUSTUSER "
					+ " ORDER BY ID DESC ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			List<CustUserDto> list = new ArrayList<CustUserDto>();
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("ID");
					String name = rs.getString("NAME");
					String address = rs.getString("ADDRESS");
					list.add(new CustUserDto(id, name, address));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn, psmt, rs);
				
			}
			return list;
			
		}//end getCustUserList()
		
		public boolean addCustUser(String id, String name, String address) {
			String sql = " INSERT INTO CUSTUSER(ID, NAME, ADDRESS) "
					+ " VALUES(?, ?, ?) ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			int count = 0;
			
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, name);
				psmt.setString(3, address);
				
				count = psmt.executeUpdate();
				
				
			} catch (SQLException e) {
				
				
				e.printStackTrace();
			}finally {
				close(conn, psmt, null);	//rs는 null왜?
				
			}
			
			
			return count>0?true:false;
		}
		
		
		
		
		
		
		
		
		
		
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
		

}//end class
