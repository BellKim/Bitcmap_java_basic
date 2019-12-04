package bcls;

import single.Singleton;

public class MyClass {
	private String myName;
	private int myNum;
	
	public MyClass() {
		Singleton si1 = Singleton.getInstance();

	}

//	public int getMyNum() {
//		return myNum;
//	}
	public void MyMethod() {
		Singleton si = Singleton.getInstance();
		myName = si.name;
		
		System.out.println(myName);
	}
	
	public void fromyou() {
		Singleton si11 = Singleton.getInstance();
		myNum = si11.youNum; 
		System.out.println("mynum  ="+myNum);
		
	}
	
	
	
	

}
