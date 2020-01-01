package Model.dao;

import java.util.List;

import Controller.dto.orderList;

public interface orderDao {
	public int getPrice(String coffeeName, int coffeeSize);
	
	public void insertOrderList(List<orderList> list, String userInfo);
	
}
