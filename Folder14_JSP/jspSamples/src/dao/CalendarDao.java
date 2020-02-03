package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import calenderEX.CalendarDto;
import db.DBClose;
import db.DBConnection;

public class CalendarDao  implements Serializable{
	
	private static CalendarDao dao = new CalendarDao();
	
	public CalendarDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static CalendarDao getInstance() {
		return dao;
	}
	
	public List<CalendarDto> getCalendarList(String id, String yyyyMM){
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " + 
				" FROM (SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(RDATE, 1, 8)ORDER BY RDATE ASC) RNUM, " + 
				" SEQ, ID, TITLE, CONTENT, RDATE, WDATE " + 
				" FROM CALENDAR " + 
				" WHERE ID=? AND SUBSTR(RDATE, 6, 1)=?) " + 
				" WHERE RNUM BETWEEN 1 AND 5 ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		
		try {
			conn=DBConnection.getConnection();
			System.out.println("1/6 getCalendarList success! ");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM.trim());
			System.out.println("2/6 getCalendarList success! ");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getCalendarList success! ");
			
			while(rs.next()) {
				int i = 1;
				CalendarDto dto = new CalendarDto(
						rs.getInt(i++),							//seq,	 
						rs.getString(i++),						//id, 
						rs.getString(i++),						//title, 
						rs.getString(i++),						//content, 
						rs.getString(i++),						//rdate, 
						rs.getString(i++));						//wdate);
				list.add(dto);
				
			}
			System.out.println("4/6 getCalendarList success! ");
			
			
		} catch (SQLException e) {
			System.out.println("fail ");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
				
		
		return list;
		
		
	}//end getCalendarList
	
	

}//end class
