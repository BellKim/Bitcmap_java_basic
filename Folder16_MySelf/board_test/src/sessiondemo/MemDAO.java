package sessiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class MemDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private MemDAO() {
	}

	private static MemDAO dao = new MemDAO();

	public static MemDAO getInstance() {
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
	
	
	
	public int memCheck(MemDTO dto) { //String fid, String fpass 이런식으로 두변수로 나누지말ㄹ아라
		int cnt=0;
		
		try {
			conn=init();
			String sql = "SELECT COUNT(*) FROM memtab";
			sql+=" where fid = ? and fpass=?";//줄 바뀌면서 띄어쓰기하는거 잊지말기. 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFid());
			pstmt.setString(2, dto.getFpass());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt(1);//컬럼을 말하는것.
//				cnt=rs.getInt(1) = rs.getString("num"); 컬럼번째 숫자를 쓰기도 한다.  
//				rs.getInt(2) = rs.getString("fid");		통상적으로 가독성을 위해서 통상적으로 문자열을 쓰지만  여기선 인덱스 번호이기떄문에 그냥 번호를 넣어준다.
//				count(*)의 결과는 where 절에 나오는 값이 유일하기떄문이다.
				System.out.println("cnt=  " +cnt + " rs = " + rs + " ");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			exit();
		}
		
		
		
		return cnt;
		
	}//end memCheck()
	
	
	/*
	
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
*/
	
}//end class








