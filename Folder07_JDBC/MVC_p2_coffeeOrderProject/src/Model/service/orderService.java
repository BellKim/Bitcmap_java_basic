package Model.service;

import java.util.List;

import Controller.dto.orderList;

public interface orderService {
	
	public List<orderList> getNameToPrice(List<orderList> list);

	public void insertOrderList(List<orderList> list, String userInfo);
	

}//orderService()
