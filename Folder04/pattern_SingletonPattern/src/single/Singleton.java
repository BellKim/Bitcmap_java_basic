package single;

public class Singleton {
	
	private static Singleton single = null;
	
	public String name;
	public int youNum;
	
	//다시는 못만들게 하기위해서  private 를 선언한다. 
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if(single == null) {
			single = new Singleton();
		}
		
		return single;
	}
	
	
	

}

