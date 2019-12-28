package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.dto.MemberDto;
import model.dao.MemberDao;
import template.db.DBClose;
import template.db.DBConnection;

public class MemberDaoImpl implements MemberDao{

	@Override
	public MemberDto login(String id, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMember(MemberDto dto) {
		String sql = " INSERT INTO MEMBER(id, pwd, name, email, auth)"
				+ "	VALUES(?, ?, ?, ?, 3)";
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println("addMember() sql = " +  sql );
		
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			
			count = psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		
		
		return count>0 ? true : false;
	}




}
