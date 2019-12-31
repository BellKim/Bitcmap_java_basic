package Controller;

import Model.service.orderService;
import Model.service.impl.orderServiceImpl;
import View.OrderList_01Main;

public class orderController {
	
	orderService orderServ = new orderServiceImpl();
	
	public void showOrderList() {
		new OrderList_01Main();
	}
	

}//end class
