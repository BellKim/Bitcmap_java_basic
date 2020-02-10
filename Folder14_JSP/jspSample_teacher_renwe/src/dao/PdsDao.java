package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.PdsDto;

public class PdsDao {
	
	private static PdsDao dao = new PdsDao();
	
	public PdsDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static PdsDao getInstance() {
		return dao;
		
	}
	
	public List<PdsDto> getPdsList(){
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, "
				+ " READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS "
				+ " ORDER BY SEQ DESC  ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getpdsList SUCCESS");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getpdsList SUCCESS");
			
			rs=psmt.executeQuery();
			System.out.println("3/6 getpdsList SUCCESS");
			
			while(rs.next()) {
				int i=1;

				PdsDto dto = new PdsDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getInt(i++),
						rs.getString(i++)
						);
						//id, title, contetn, readcount, downcount, regDate)
				list.add(dto);
			}
			System.out.println("4/6 getpdsList SUCCESS");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		
		
		
		return list;
		
	}
	
	public boolean writePds(PdsDto pds) {
		String sql = " INSERT INTO PDS (SEQ, ID, TITLE, CONTENT, FILENAME, "
				+ " READCOUNT, DOWNCOUNT, REGDATE) "
				+ " VALUES(SEQ_PDS.NEXTVAL, ?, ?, ?, ?, "
				+ " 0, 0, SYSDATE)  ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writePds SUCCESS");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pds.getId());
			psmt.setString(2, pds.getTitle());
			psmt.setString(3, pds.getContetn());
			psmt.setString(4, pds.getFilename());
			System.out.println("2/6 writePds SUCCESS");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writePds SUCCESS");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count>0?true:false;
		
	}//end writePds()
	
	
	

}//end pdsDao
