package Model.dao;


import java.util.List;

import Controller.dto.coffeeOrderDto;
import Controller.dto.orderList;

public interface orderDao {
	
	public orderList getCoffeeNoANDPrice(orderList orderList);
	public int insertOrderList(List<orderList> orderlist);
	
	public int getmemberID(String memberid);
	
	public List<coffeeOrderDto> getReceiveAll();
	

}//end orderDao interface 
