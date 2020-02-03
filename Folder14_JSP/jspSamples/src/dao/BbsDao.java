package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao {
	
	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
		
	}
	
	public static BbsDao getInstance() {
		
		return dao;
		
	}//end class
	
	
	public boolean writeBbs(BbsDto bbs) {
		String sql = " INSERT INTO BBS"
				+ " (SEQ, ID, "
				+ " REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE,"
				+ " DEL, READCOUNT)"
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				//서브쿼리 
				+ "  (SELECT NVL(MAX(REF), 0) + 1 FROM BBS), "//NVL로 NULL이 들어오면 0으로 변환시켜주고, +1값을 출력해준다.
				//REF=NULL->1, REF=1  ->2
				//REF=그룹번호, 어느댓글에 달린 댓글인지 알수있도록함. 	
				+ "  0, 0, "
				+ " ?, ?, SYSDATE, "
				+ " 0, 0 )";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writeBbs success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 writeBbs success");
			
			psmt.setString(1, bbs.getId());
			psmt.setString(2, bbs.getTitle());
			psmt.setString(3, bbs.getContent());
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writeBbs success");
			
			
			
			
		} catch (SQLException e) {
			System.out.println("writebbs fail. ");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
			
		}
		return count>0?true:false;
	}//end writeBbs()
	
	
	
	public List<BbsDto> getBbsList(){
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ "TITLE, CONTENT, WDATE, "
				+ " DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList success!");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList success!");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList success!");
			while(rs.next()) {
				int i=1;
				BbsDto dto = new BbsDto(
										rs.getInt(i++),	//seq,
										rs.getString(i++),	//id,
										rs.getInt(i++),	//ref,
										rs.getInt(i++),	//step,
										rs.getInt(i++),	//depth,
										rs.getString(i++),	//title,
										rs.getString(i++),	//content,
										rs.getString(i++),	//wdate,
										rs.getInt(i++),	//del,
										rs.getInt(i++));	//readcount);
				list.add(dto);
			}
			System.out.println("4/6 getBbsList success!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
			
		}
		return list;
		
		
	}//end getBbsList()
	
	
	public BbsDto getBbs(int seq) {
		String sql = " select SEQ, ID, REF, STEP, DEPTH,"
				+ " TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ "FROM BBS"
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BbsDto dto = null;

		
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbs success!");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbs success!");
			
			psmt.setInt(1, seq);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbs success!");
			
			
			while(rs.next()) {
				int i=1;
				dto = new BbsDto(
								rs.getInt(i++),		//seq,
								rs.getString(i++),	//id,
								rs.getInt(i++),		//ref,
								rs.getInt(i++),		//step,
								rs.getInt(i++),		//depth,
								rs.getString(i++),	//title,
								rs.getString(i++),	//content,
								rs.getString(i++),	//wdate,
								rs.getInt(i++),		//del,
								rs.getInt(i++));	//readcount);
			}
			
			System.out.println("4/6 getBbs success!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
			
		}
		return dto;
		
	}// end getBbs()
	
	public void readcount(int seq) {
		String sql = " UPDATE BBS "
				+ " SET READCOUNT=READCOUNT+1 "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BbsDto dto = null;

		
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 readcount success!");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 readcount success!");
			
			psmt.setInt(1, seq);
			
			psmt.executeUpdate();
			
			System.out.println("3/6 readcount success!");
			

			
		} catch (SQLException e) {
			System.out.println("readcount fail  !");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
			
		}
		
	}// end readcount()
	
	
	
				  //부모글의sequence, 답글의object
	public boolean answer(int seq, BbsDto bbs) {
		//update 후에 insert 해준다. 
		

		String sql1 = " UPDATE BBS "
				+ " SET STEP=STEP+1 "
				+ " WHERE REF=(SELECT REF FROM BBS WHERE SEQ=?) "
				+ " AND STEP >(SELECT STEP FROM BBS WHERE SEQ=?) ";
		
		String sql2 = " INSERT INTO BBS "
				+ " (SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ " 	(SELECT REF FROM BBS WHERE SEQ=?), "
				+ " 	(SELECT STEP FROM BBS WHERE SEQ=?)+1, "
				+ " 	(SELECT DEPTH FROM BBS WHERE SEQ=?)+1, "
				+ " ?, ?, SYSDATE, 0, 0)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		
		try {
			//update
			conn=DBConnection.getConnection();
			
			conn.setAutoCommit(false);//오토커밋을 반드시 꺼줘야 한다. 2개의 쿼리가 동작하기전에 오류가날수도 있으니...
			
			System.out.println("1/6 answer success");
			
			psmt=conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count=psmt.executeUpdate();
			System.out.println("3/6 answer success");
			
			//psmt 초기화
			psmt.clearParameters();
			
			//insert 
			psmt=conn.prepareStatement(sql2);
			
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			psmt.setInt(3, seq);
			psmt.setInt(4, seq);
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			System.out.println("4/6 answer success");
			
			count= psmt.executeUpdate();
			System.out.println("5/6 answer success");
			conn.commit();
			
		} catch (SQLException e) {
			System.out.println("answer fail!!");
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			e.printStackTrace();
		}finally {
			
			
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("6/6 answer success");
		}
		

		
		return count>0?true:false;
	}//end answer()
	
	
	
	public boolean deleteBbs(String seq) {
		String sql = " UPDATE BBS SET DEL=? "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 deleteBbs success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 deleteBbs success");
			
			psmt.setInt(1, 1);
			psmt.setString(2, seq);
			
			count = psmt.executeUpdate();
			System.out.println("3/6 deleteBbs success");
	
			
		} catch (SQLException e) {
			System.out.println("deleteBbs fail. ");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
			
		}
		return count>0?true:false;
	}//end writeBbs()
	

}//end class
