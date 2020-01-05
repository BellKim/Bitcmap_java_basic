package Model.dao;


import java.util.List;

import Controller.dto.orderList;

public interface orderDao {
	
	public orderList getCoffeeNoANDPrice(orderList orderList);
	public int insertOrderList(List<orderList> orderlist);
	
	public int getmemberID(String memberid);

}//end orderDao interface 
