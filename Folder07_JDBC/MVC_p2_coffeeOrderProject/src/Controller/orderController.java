package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.dto.orderList;
import Model.service.orderService;
import Model.service.impl.orderServiceImpl;
import View.OrderList_01Main;

public class orderController {
	
	orderService orderServ = new orderServiceImpl();
	
	private List<orderList> shopingCartList = null;
	
	
	
	public void showOrderList() {
		new OrderList_01Main();
	}
	
	public void goToCart(orderList orderlist) {
		if(shopingCartList == null) {
			System.out.println("리스트 뉴 생성");
			shopingCartList = new ArrayList<orderList>();
		}
		System.out.println("gotocart 내역 : -===================");
		System.out.println(orderlist.toString());
		System.out.println("gotocart 내역 : -===================");
		
		shopingCartList.add(orderlist);
		
		System.out.println("add된 리스트 내역 : -===================");
		System.out.println(shopingCartList.toString());
		System.out.println("add된 리스트  내역 : -===================");
		
	}//end goToCart
	
	public List<orderList> getFromCart() {
		for (orderList orderList : shopingCartList) {
			System.out.println("출력된 getFromCart = " + orderList);
		}
		return shopingCartList;
	}// end getFromCart

	public int getPrice(String coffeeName, String coffeeSize) {
		
		return orderServ.getNameToPrice(coffeeName, coffeeSize);
	}

	public void paymentNow(List<orderList> list, String userInfo) {
		for (orderList orderList : list) {
			System.out.println("orderList = " + orderList.toString());
		}
		//주문내역 최종 결제.
		orderServ.insertOrderList(list, userInfo);
	}
	

	
	


}//end class
