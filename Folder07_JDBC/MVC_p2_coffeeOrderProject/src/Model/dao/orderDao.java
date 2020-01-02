package Model.dao;

import java.util.ArrayList;
import java.util.List;

import Controller.dto.orderList;

public interface orderDao {
	public List<orderList> getPrice(String coffeeName, int coffeeSize);
	public List<orderList> callMenuNumber(List<orderList> list);
	public void insertOrderList(List<orderList> list, String userInfo);
	
}
