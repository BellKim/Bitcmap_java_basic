package Model.service.impl;


import java.util.List;

import Controller.dto.orderList;
import Model.dao.orderDao;
import Model.dao.impl.orderDaoImpl;
import Model.service.orderService;

public class orderServiceImpl implements orderService{
	orderDao ordardao = new orderDaoImpl();

	@Override
	public orderList getCoffeeNoANDPrice(orderList orderList) {
		
		
		return ordardao.getCoffeeNoANDPrice(orderList);
	}

	@Override
	public int insertOrderList(List<orderList> orderlist) {
		
		
		return ordardao.insertOrderList(orderlist);
	}
	
	

	

}//end class
