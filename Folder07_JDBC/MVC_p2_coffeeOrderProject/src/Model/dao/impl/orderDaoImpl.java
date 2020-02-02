package Model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.dto.coffeeOrderDto;
import Controller.dto.orderList;
import Model.dao.orderDao;
import Template.DB.DBClose;
import Template.DB.DBConnection;
import main.singleton.Singleton;

public class orderDaoImpl implements orderDao {

	@Override
	public orderList getCoffeeNoANDPrice(orderList orderList) {
		orderList ol = orderList;
		
		String sql = " SELECT coffee_index, sizePrice "
				+ " FROM COFFEELIST "
				+ " WHERE coffeeName=? AND coffeeSize=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println("sql = " + sql );
		
		int settingSize=1;
		if((orderList.getSize()).equals("Short")) {
			settingSize=1;
		}else if((orderList.getSize()).equals("Tall")) {
			settingSize=2;
		}else if(orderList.getSize().equals("Grande")) {
			settingSize=3;
		}
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1 , orderList.getName());
			psmt.setInt(2, settingSize);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				ol.setNameNumber(rs.getInt(1));
				ol.setPrice( (rs.getInt(2)) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		System.out.println(" getCoffeeNoANDPrice " + ol.toString());
		return ol;
	}

	@Override
	public int insertOrderList(List<orderList> orderlist) {
		int res=0;
		int setMemberNo = 1;
		int settingSize=1;
		Singleton si = Singleton.getInstance();
		
		/*
CREATE TABLE COFFEEORDER(
				ORDER_INDEX	NUMBER(4),		--PK
				MEMBERINDEX	NUMBER(4),		--FK
				coffee_index NUMBER(4),		--FK
				order_date	DATE,
				coffee_size	VARCHAR2(3),
				SYRUP		VARCHAR2(1),
				ADDSHOT		VARCHAR2(1),
				ADDWHIPING	VARCHAR2(1),
				AMOUNT		VARCHAR2(2),
				CONSTRAINT PR_OrderList_01 PRIMARY KEY(ORDER_INDEX),
				CONSTRAINT FK_COFFEEMEMBERS_01 FOREIGN KEY(MEMBERINDEX) REFERENCES COFFEEMEMBERS(MEMBERINDEX),
				CONSTRAINT FK_COFFEELIST_01 FOREIGN KEY(coffee_index) REFERENCES COFFEELIST(coffee_index)
			);		  
		 
		 */
		setMemberNo = getmemberID(si.getLoginId());
		for(int i = 0; i<orderlist.size(); i++) {
		String sql = " INSERT INTO coffeeorder " + 
				" VALUES(ORDER_INDEX.nextval,?,?,sysdate,?,?,?,?,3) ";
		System.out.println("orderlist!!! = ");
		System.out.println(orderlist.toString());
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		System.out.println("sql = " + sql );
		
			try {	
				if(orderlist.get(i).getSize().equals("Short")) {
					settingSize=1;
				}else if(orderlist.get(i).getSize().equals("Tall")) {
					settingSize=2;
				}else if(orderlist.get(i).getSize().equals("Grande")) {
					settingSize=3;
				}

				conn = DBConnection.getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, setMemberNo);//
				psmt.setInt(2, orderlist.get(1).getNameNumber());
//				coffee_size	VARCHAR2(3),
				psmt.setInt(3, settingSize);
//				SYRUP		VARCHAR2(1),
				psmt.setString(4, orderlist.get(i).getSyrup());
//				ADDSHOT		VARCHAR2(1),
				psmt.setString(5, String.valueOf(orderlist.get(i).isAddShot()));
//				ADDWHIPING	VARCHAR2(1),
				psmt.setString(6, String.valueOf(orderlist.get(i).isWhiping()));
				
				
				
				rs=psmt.executeQuery();
				
				if(rs.next()) {
					res +=1 ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBClose.close(psmt, conn, rs);
			}
		}
		System.out.println("res = " +  res);
		return res;
	}

	@Override
	public int getmemberID(String memberid) {
		int res= 0;
		
		String sql = " SELECT MEMBERINDEX "
				+ " FROM COFFEEMEMBERS "
				+ " WHERE id=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println("sql = " + sql );
		

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1 , memberid);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				res=rs.getInt(rs.getInt(1));
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
	public List<coffeeOrderDto> getReceiveAll() {
		String sql = " SELECT b.coffeeName, a.order_date, b.sizePrice " + 
				"from coffeeorder a, coffeelist b" + 
				"WHERE a.coffee_index = b.coffee_index  ";
		List<coffeeOrderDto> coffeeorder= null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		coffeeorder = new ArrayList<coffeeOrderDto>();
		System.out.println("getReceiveAll().sql = " + sql );
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String cofName = rs.getString(1);
				Date cofDate = rs.getDate(2);
				int cofPrice = rs.getInt(3);
				orderList ol = new orderList();
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
}//end class
