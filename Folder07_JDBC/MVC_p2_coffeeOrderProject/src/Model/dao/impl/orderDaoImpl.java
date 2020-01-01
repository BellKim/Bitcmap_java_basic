package Model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Controller.dto.orderList;
import Model.dao.orderDao;
import Template.DB.DBClose;
import Template.DB.DBConnection;

public class orderDaoImpl implements orderDao {

	@Override
	public int getPrice(String coffeeName, int coffeeSize) {
		String sql = " SELECT sizePrice "
				+ " FROM COFFEELIST "
				+ " WHERE coffeeName = ? "
				+ " AND coffeeSize = ? ";
		
		System.out.println( "idcheck.sql = " + sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int res = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, coffeeName);
			psmt.setInt(2, coffeeSize);
			rs = psmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return res;
	}
	
	
	
	@Override
	public List<orderList> callMenuNumber(List<orderList> list) {
		List<orderList> ol = list;
		String sql = " SELECT coffee_index"
				+ " FROM COFFEELIST WHERE coffeeName = ";
				for (int i = 1; i <= ol.size(); i++) {
					 sql += " ? " ;
					 if(i != ol.size()) {
						 sql += " , "; 
					 }else {
						 break;
					 }
				}
		System.out.println( "callMenuNumber.sql = " + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int res = 0;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			for (int i = 1; i <= ol.size(); i++) {
				psmt.setString((i), ol.get(i).getName());
			}
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				for (int i = 1; i <= ol.size(); i++) {
					res = rs.getInt(i);
					ol.get(i).setNameNumber(res);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return ol;
	}
	
	
	
	@Override
	public void insertOrderList(List<orderList> list, String userInfo) {
		
		String sql = " INSERT COFFEEORDER INTO () "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
				
				
		System.out.println( "insertOrderList.sql = " + sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int res = 0;
		try {
			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
//			psmt.setString(1, coffeeName);
//			psmt.setInt(2, coffeeSize);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
	}


	

}
