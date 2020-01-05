package Model.service;

import java.util.List;

import Controller.dto.orderList;

public interface orderService {
	
	public orderList getCoffeeNoANDPrice(orderList orderList);
	public int insertOrderList(List<orderList> orderlist);

}//orderService()
