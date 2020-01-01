package Model.service.impl;

import java.util.List;

import Controller.dto.orderList;
import Model.dao.orderDao;
import Model.dao.impl.orderDaoImpl;
import Model.service.orderService;

public class orderServiceImpl implements orderService{
	orderDao ordardao = new orderDaoImpl();
	
	
	@Override
	public int getNameToPrice(String coffeeName, String coffeeSize) {
		int sizeToInt = 1;
		if(coffeeSize.equals("Short")) {
			sizeToInt = 1;
		} else if(coffeeSize.equals("Tall")) {
			sizeToInt = 2;
		} else if(coffeeSize.equals("Grande")) {
			sizeToInt = 3;
		}
		return ordardao.getPrice(coffeeName, sizeToInt);
	}//end getNameToPrice


	@Override
	public void insertOrderList(List<orderList> list, String userInfo) {
		ordardao.insertOrderList(list,userInfo);
		
	}

	

}//end class
