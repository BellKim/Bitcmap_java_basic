package main;

import Template.motionListener;
import View.OrderList_01Main;
import View.OrderList_01_sub_MenuList;
import View.OrderList_02_ShopingCart;
import View.OrderList_03_ShowAll;
import View.accountJoinView;
import View.loginView;
import main.singleton.Singleton;

public class mainClass {
	public static void main(String[] args) {

		Singleton s = Singleton.getInstance();
//		new loginView();			//로그인창
//		new accountJoinView();		//회원가입창
//		new OrderList_01Main();		//크기, 시럽, 휘핑 등등 선택후 주문할 수 있는 창
//		new OrderList_02Sub_OrderList();	//메뉴판
//		new OrderList_02_ShopingCart();	//주문내역
		new OrderList_03_ShowAll();
		
		
		
		
//		new motionListener();
		
	}

}
