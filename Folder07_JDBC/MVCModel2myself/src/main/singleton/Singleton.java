package main.singleton;

import controller.MemberController;

public class Singleton {
	
	private String loginId = null;	//로그인정보
	
	private static Singleton s = null;
	public MemberController memCtrl = null;
	
	public Singleton() {
		memCtrl = new MemberController();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}
	

	

}//end class
