package mmSingleton;

import mm01.mm01DTO;

public class mmSingleton {
	private static mmSingleton single = null;
	
	public mm01DTO mm01dto1;
	
	
	private mmSingleton() {
		// TODO Auto-generated constructor stub
		System.out.println("1");
	}

	public static mmSingleton getInstance() {
		if(single == null) {
			single = new mmSingleton();
		}
		return single;
	}
	
	

}
