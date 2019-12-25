package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import DB.DBClose;
import DB.DBConnection;
import DTO.userDTO;

public class SelectTest {
	public SelectTest() {
	
	}
	
	public userDTO search(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ "WHERE ID = '" + id + "'";
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt  = null;
		ResultSet rs = null;
		userDTO dto = null;
		System.out.println("sql =  " + sql);
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joinDate = rs.getString("joindate");
				dto = new userDTO(_id, _name, _age, _joinDate);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
		
				
	}//end search

	public userDTO select1(String id) {
		String sql = " SELECT id, name, age, joindate "
				+ "FROM userDTO WHERE id = ? ";
		//커넥션 삼형제
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt  = null;
		ResultSet rs = null;
		
		userDTO dto  =null;
		System.out.println("sql = " + sql );
		
		try {
			psmt  = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joinDate = rs.getString("joindate");
				dto = new userDTO(_id, _name, _age, _joinDate);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		return dto;
				
		
	}
	
	public List<userDTO> SelectAll(){
		List<userDTO> list= new ArrayList<userDTO>();
		String sql = "SELECT * FROM USERDTO";
		
		//커넥션 삼형제 
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		userDTO dto = null;
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				dto = new userDTO();
				
				dto.setId(rs.getString("id") );
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoinDate(rs.getString("joindate"));
				list.add(dto);
				
//				String id = rs.getString("id");
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String jobdate = rs.getString("joindate");
//				
//				list.add(new userDTO(id, name, age, jobdate));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
			
		}
		
		
		return list;

	}//end selectAll();
	
	
	
	
	
	
	
	

}//end class
