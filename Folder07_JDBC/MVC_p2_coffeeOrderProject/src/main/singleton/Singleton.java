package main.singleton;

public class Singleton {
	
	private String loginId = null;
	
	private static Singleton s = null;


	public Singleton() {
		
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
