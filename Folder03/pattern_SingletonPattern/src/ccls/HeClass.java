package ccls;

import single.Singleton;

public class HeClass {
	private String name;
	
	
	public HeClass() {
		name = "김미나";
		Singleton s = Singleton.getInstance();
		s.name = name;
		
	}

}
