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
	private BbsDTO bdto;
	
	
	private BbsDao() {
	
	}
	
	public static BbsDao getInstance() {
		return dao;
	}
	

	
	
	
	public BbsDTO getBdto() {
		return bdto;
	}

	public void setBdto(BbsDTO bdto) {
		String sql = " SELECT READCOUNT "
				+ " FROM BBS "
				+ " WHERE SEQ = ?";
		Connection conn = null;				//DBCONNECTION
		PreparedStatement psmt = null;		//SQL
		ResultSet rs = null;				//RESULT
		System.out.println( "setbdto sql = " + sql );
		System.out.println(bdto.getSeq() +" / "  +bdto.getTitle() + " / " + bdto.getContent());
		try {
			conn = DBCONNECTON.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  bdto.getSeq());
			//psmt.setString(2,  bdto.getTitle());
			
			rs = psmt.executeQuery();
			
			
//			psmt.setString(3,  bdto.getContent());
			System.out.println("1111setBdto 의 readcount 값 출력 "+rs.getInt(1));
			if(rs.next()) {
				bdto.setReadcount(rs.getInt(1));
				System.out.println("2222setBdto 의 readcount 값 출력 "+rs.getInt(1));
			}
//쿼리문이 작성 되었을때 성공적으로 쿼리가 동작되면, rs.next로 
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCLOSE.close(psmt, conn, rs);
		}

		
		
		this.bdto = bdto;
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

	public boolean writeBBS(BbsDTO dto) {
		int count = 0;
		 
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " INSERT INTO BBS(SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, ?, ?, SYSDATE, 0, 0) ";
		
		try {
			conn = DBCONNECTON.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,  dto.getId());
			psmt.setString(2,  dto.getTitle());
			psmt.setString(3,  dto.getContent());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCLOSE.close(psmt, conn, rs);
			
		}
		
		return count > 0 ? true:false;
	}
	
	
	
	

}//end class
