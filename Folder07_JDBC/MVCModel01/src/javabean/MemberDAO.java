package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBCLOSE;
import DB.DBCONNECTON;
import dto.MemberDTO;

//DB <->JAVA
public class MemberDAO {
	private static MemberDAO mem = null;
	
	private String loginID;
	
	public MemberDAO() {
		
	}
	
	
	
	public static MemberDAO getMem() {
		return mem;
	}



	public static void setMem(MemberDAO mem) {
		MemberDAO.mem = mem;
	}



	public String getLoginID() {
		return loginID;
	}



	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}



	public static MemberDAO getInstance() {
		if(mem == null) {
			mem = new MemberDAO();
		}
		return mem;
	}
	
	public boolean getId(String id) {
		String sql = " SELECT ID "
				+ " FROM MEMBER "
				+ " WHERE ID = ?";
		
		Connection conn = null;				//DBCONNECTION
		PreparedStatement psmt = null;		//SQL
		ResultSet rs = null;				//result
		
		boolean findid = false;
		System.out.println("sql : " + sql );
		try {
			conn = DBCONNECTON.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				findid=true;	//데이터가 있을때
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCLOSE.close(psmt, conn, rs);
		}
		return findid;
	}
	
	public boolean addMember(MemberDTO dto) {
		//db에 추가하는 작업진행
		return true;
	}



	public MemberDTO login(String id, String pwd) {
		String sql = " SELECT ID, NAME, EMAIL, AUTH "
				+ " FROM MEMBER "
				+ " WHERE ID=? AND PWD=? ";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	MemberDTO mem = null;
	
	try {
		conn = DBCONNECTON.getConnection();
	
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id.trim());
		psmt.setString(2, pwd.trim());
		
		rs = psmt.executeQuery();
		
		if(rs.next()) {
			String _id = rs.getString(1);	// id
			String _name = rs.getString(2);	// name
			String _email = rs.getString(3);// email
			int auth = rs.getInt(4);	// auth
			
			mem = new MemberDTO(_id, null, _name, _email, auth);
		}		
		
	} catch (SQLException e) {			
		e.printStackTrace();
	} finally {
		DBCLOSE.close(psmt, conn, rs);			
	}
	return mem;
	}
	

}//end of class
