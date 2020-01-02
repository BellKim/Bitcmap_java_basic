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
		String sql = " SELECT coffee_index FROM COFFEELIST WHERE ";
				for (int i = 0; i < ol.size(); i++) {
					if(i != 0){
						sql += " or ";
					}
					sql += " coffeeName = ? AND coffeeSize  = ? ";
				}
		System.out.println( "callMenuNumber.sql = " + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int res = 0;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);		
			int sizeToInt = 1;
			for (int i = 1; i < ol.size()+1; i++) {
				if((ol.get(i).getSize()).equals("Short")) {
					sizeToInt = 1;
				}else if((ol.get(i).getSize()).equals("Tall")) {
					sizeToInt = 2;
				}else if((ol.get(i).getSize()).equals("Grande")) {
					sizeToInt = 3;
				}
				System.out.println(" input 측정 ");
				int first = i+(i-1);
				int second = first + 1;
				psmt.setString(first, ol.get(i).getName());
				psmt.setInt(second, sizeToInt);
				System.out.println(" ol.size = "+ol.size()+" \n"+ol.get(i).getName()+" / "+ sizeToInt);
			}
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				for (int i = 1; i < ol.size()+1; i++) {
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


	

}//end class
