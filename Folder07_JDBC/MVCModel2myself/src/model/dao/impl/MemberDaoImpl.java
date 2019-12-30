package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.dto.MemberDto;
import model.dao.MemberDao;
import template.db.DBClose;
import template.db.DBConnection;

public class MemberDaoImpl implements MemberDao{

	@Override
	public MemberDto login(String id, String pwd) {
		String sql = "  SELECT ID, NAME, EMAIL, AUTH "
				+ " FROM MEMBER "
				+ " WHERE id=? AND PWD=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		System.out.println("login().sql = " + sql );
		MemberDto dto = null;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String _id = rs.getString(1);	// id
				String _name = rs.getString(2);	// name
				String _email = rs.getString(3);// email
				int auth = rs.getInt(4);	// auth
				
				dto = new MemberDto(_id, null, _name, _email, auth);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return dto;
	}

	@Override
	public int addMember(MemberDto dto) {
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
		return count;
	}

	@Override
	public int idCheck(String id) {
		String sql = " SELECT id "
				+ " FROM MEMBER "
				+ "WHERE id = ? ";
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		System.out.println( "idcheck.sql = " + sql);
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return count;
	}




}
