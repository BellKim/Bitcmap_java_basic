package Model.service;

import java.util.List;

import Controller.dto.orderList;

public interface orderService {
	
	public int getNameToPrice(String coffeeName, String coffeeSize);

	public void insertOrderList(List<orderList> list, String userInfo);
	

}//orderService()
