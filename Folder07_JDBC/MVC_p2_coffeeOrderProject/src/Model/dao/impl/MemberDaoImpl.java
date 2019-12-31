package Model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.dto.coffeeMemberDto;
import Model.dao.MemberDao;
import Template.DB.DBClose;
import Template.DB.DBConnection;

public class MemberDaoImpl implements MemberDao{



	@Override
	public int idcheck(String id) {
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

	@Override
	public coffeeMemberDto loginAf(String id, String pwd) {
		String sql = " SELECT MEMBERINDEX, ID, PW, NAME, AGE, AUTH "
				+ " FROM COFFEEMEMBERS "
				+ " WHERE id=? AND PW=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		System.out.println("login().sql = " + sql );
		coffeeMemberDto dto = null;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int _memberIndex = rs.getInt(1);	// memberidex
				String _id = rs.getString(2);	// id
				String _pw = rs.getString(3);// pw
				String _name = rs.getString(4);	// name
				int _age= rs.getInt(5);	// age
				int _auth = rs.getInt(6); //auth
				
				dto = new coffeeMemberDto(_memberIndex, _id, null, _name, _age, _auth);
				
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
	public int addmemberIns(coffeeMemberDto dto) {
		int count = 0;
		String sql = " insert into COFFEEMEMBERS " +
//		" values(MEMBERINDEX.nextval, 'asd', 'asd', 'asd', 29, 3) ";
		" values( ?, ?, ?, ?, ?, 3) ";


		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		System.out.println("login().sql = " + sql );
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "MEMBERINDEX.nextval");
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());
			psmt.setString(4, dto.getName());
			psmt.setInt(5, dto.getAge());
			
			
			
			rs = psmt.executeQuery();
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count;
	}


	
	

}//end class
