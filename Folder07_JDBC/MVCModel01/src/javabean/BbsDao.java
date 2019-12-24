package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBCLOSE;
import DB.DBCONNECTON;
import dto.BbsDTO;

public class BbsDao {//singleton
	


	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
	
	}
	
	public static BbsDao getInstance() {
		return dao;
	}
	
	public List<BbsDTO> getBbsList(){
		String sql = " Select SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC ";
		
		Connection conn = null;				//DBCONNECTION
		PreparedStatement psmt = null;		//SQL
		ResultSet rs = null;				//RESULT
		
		
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			conn = DBCONNECTON.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BbsDTO dto = new BbsDTO(rs.getInt(1),//seq, 
										rs.getString(2),//id, 
										rs.getString(3),//title, 
										rs.getString(4),//content, 
										rs.getString(5),//wdate, 
										rs.getInt(6),//del, 
										rs.getInt(7)//readcount
										);
				list.add(dto);        
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCLOSE.close(psmt, conn, rs);
		}
		return list;
	}
	
	
	
	

}//end class
