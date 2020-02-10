/*package pictureview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import multicheckdemo.MemberDAO;
import multicheckdemo.MemberDTO;

public class TestDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private TestDAO() {
		
	}
	private static TestDAO dao = new TestDAO();
	
	public static TestDAO getInstance() {
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}//end init();
	
	private void exit() throws SQLException {
		if(rs != null)
			rs.close();
		if(stmt != null)
			stmt.close();
		if(pstmt != null)
			pstmt.close();
		if(conn != null)
			conn.close();
		
	}//end exit();
	
	
	public void insertMethod(String filepath) {
			try {
				conn=init();
				String sql = "insert into preview"
						+" values(preview_num_seq.nextval,?) ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, filepath);
				pstmt.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					exit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
	}//end insertMethod()
	

	public ArrayList<TestDTO> selectMethod(){
		ArrayList<TestDTO> aList = new ArrayList<TestDTO>();
			try {
				conn=init();
				String sql ="SELECT * FROM preview order by num desc";
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					TestDTO dto = new TestDTO();
					dto.setNum(rs.getInt("num"));
					dto.setFilepath(rs.getString("filepath"));
					aList.add(dto);
					
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					exit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return aList;	
	}//end insertMethod()
}//end class 
*/


package pictureview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private TestDAO() {
	}

	private static TestDAO dao = new TestDAO();

	public static TestDAO getInstance() {
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}// end start()

	private void exit() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end exit( )
	
	public void insertMethod(String filepath) {
		try {
			conn=init();
			String sql = "insert into preview "
					+ "values(preview_num_seq.nextval,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filepath);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			exit();
		}
		
	}//end insertMethod()
	
	public ArrayList<TestDTO> selectMethod() {
		ArrayList<TestDTO> aList = new ArrayList<TestDTO>();
		try {
			conn = init();
		String sql = "select * from preview order by num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestDTO dto = new TestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setFilepath(rs.getString("filepath"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			exit();
		}

		return aList;
	}// end selectMethod( )
	
	public List<String> fileList(String chk[]){//삭제하기전 불러오기... 
		List<String> aList = new ArrayList<String>();
		
		try {
			conn=init();
			String sql = "select filepath from preview where num=?";
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<chk.length; i++) {
				pstmt.setInt(1, Integer.parseInt(chk[i]));
				rs=pstmt.executeQuery();
				if(rs.next()) {
					aList.add(rs.getString("filepath"));
				}//if
			}//for
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			exit();
		}
		
		
		
//		return init();
		return aList;
	}//end fileList;;////////
	
	
	
	
/*
	public void deleteMethod(int chk) {
		System.out.println(chk);
		
		try {
			conn=init();
			stmt=conn.createStatement();
			String sql = "delete form preview where num = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, chk);
			rs = pstmt.executeQuery();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	
	public void deleteMethod(String chk[]) {
		System.out.println(chk);
		
		try {
			conn=init();
			stmt=conn.createStatement();
			String sql="delete from preview where num=?";
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<chk.length;i++) {
				pstmt.setInt(1, Integer.parseInt(chk[i]));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			exit();
		}
		
		
	}
	
}//end class








