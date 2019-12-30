package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.dto.BbsDto;
import model.dao.BbsDao;
import template.db.DBClose;
import template.db.DBConnection;

public class BbsDaoImpl implements BbsDao{
	
	

	@Override
	public List<BbsDto> getBbsListDao() {
		//DVO
		List<BbsDto> list = new ArrayList<BbsDto>();
		String sql = " SELECT * "
				+ " FROM bbs "
				+ " WHERE del = 0 "
				+ " ORDER BY seq desc ";
		//connection SET
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		//connection SET
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			//? 에 데이터 추가하고자 하면 추가. 
			rs = psmt.executeQuery();
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getInt(6),
										rs.getInt(7));
				list.add(dto);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
	

}// end class
