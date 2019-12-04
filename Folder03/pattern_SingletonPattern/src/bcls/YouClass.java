package bcls;

import single.Singleton;

public class YouClass {
	private int youNum;

//	public void setYouNum(int youNum) {
//		this.youNum = youNum;
//	}
	
	public YouClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void method() {
		youNum = 123;
		System.out.println("younum = " + youNum);
		Singleton si = Singleton.getInstance();
		si.youNum = youNum;
		
		
	}
	
	
	

}//end you class
