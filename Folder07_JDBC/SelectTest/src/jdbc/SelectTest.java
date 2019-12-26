package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBCLOSE;
import DB.DBCONNECTON;
import dto.UserDTO;

public class SelectTest {
	public SelectTest() {
	}
	
//	1개의 데이터만 취득
	public UserDTO search(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ " WHERE ID = '"+id+"' ";
		Connection conn = DBCONNECTON.getConnection();
		PreparedStatement psmt = null;
		
		ResultSet rs = null;
		UserDTO dto = null;		//select
		
		System.out.println("sql  =" + sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {//데이터가 있는경우
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");
				
				dto = new UserDTO(_id, _name, _age, _joindate);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCLOSE.close(psmt, conn, rs);
		}

		return dto;
	}
	
	public UserDTO select(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ " WHERE ID = ? ";
		//커넥션 삼형제
		Connection conn = DBCONNECTON.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		//커넥션 삼형제
		
		UserDTO dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);		//위의  ? 에 대입된다.
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				
				dto.setId(rs.getString("id") );
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoinDate(rs.getString("joindate"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCLOSE.close(psmt, conn, rs);
			
		}
		
		
		return dto;
		
		
	}
	
//	데이터 전부를 취득(다수의 데이터 취득)
	public List<UserDTO> getUserList(){
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ "FROM USERDTO ";
		
		//커넥션 삼형제
		Connection conn = DBCONNECTON.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		//커넥션 삼형제
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		//확인을 위한 쿼리문
		System.out.println("sql = " + sql);
		
		
		try {
			
			conn = DBCONNECTON.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joinDate = rs.getString("joindate");
				
				list.add(new UserDTO(id, name, age, joinDate));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
		
	}
	
	
	
	
}//end updateTest class
