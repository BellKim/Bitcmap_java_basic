package main.singleton;

import Controller.memberController;
import Controller.orderController;

public class Singleton {
	
	private String loginId = null;
	
	private static Singleton s = null;
	
	public memberController memCtrl = null;
	public orderController orderCtrl = null;


	public Singleton() {
		memCtrl = new memberController();
		orderCtrl = new orderController();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}
	

	
	//getter//setter
	//login information.
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
	
	
	

}
