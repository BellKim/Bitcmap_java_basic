package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.dto.coffeeOrderDto;
import Controller.dto.orderList;
import Model.service.orderService;
import Model.service.impl.orderServiceImpl;
import View.OrderList_01Main;
import View.OrderList_02_ShopingCart;
import main.singleton.Singleton;

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
		// (string)커피이름 과 커피사이즈를 통해서 
		// 기존 리스트에 커피 인덱스 번호화 커피가격을 추가해준다.  
		
		orderServ.getCoffeeNoANDPrice(orderlist);
		
		shopingCartList.add(orderlist);
		
		System.out.println("add된 리스트 내역 : -===================");
		System.out.println(shopingCartList.toString());
		System.out.println("add된 리스트  내역 : -===================");
		
		new OrderList_02_ShopingCart();
		
	}//end goToCart
	
	public List<orderList> getFromCart() {
		return shopingCartList;
	}
	
	
	public List<orderList> showAll(){
		Singleton si = new Singleton();
		si.getLoginId();
//		shopingCartList
		
		return null;
	}
	
	public List<coffeeOrderDto> getFromOrderList(){
		
		return null;
	}

//	insertOrderList
	
	public void insertOrderList() {
//		Singleton si = Singleton.getInstance();
		int res = orderServ.insertOrderList(shopingCartList);
		System.out.println("insertOrderList 의 결과 " + res);
		
		
	}
	
	


}//end class
