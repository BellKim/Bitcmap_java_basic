package chap15oop3Inheritage;
//부모클래스다.
public class SuperClass extends Object{//extends Object 로 상속받아오지만 기본적으로 생략되어있다. 
	private String pri_name;		//접근금지
	public String pub_name;			//누구나 접근가능.
	protected String pro_name;		//자식클래스에서만 접근이 가능하다. 
	
	
	public SuperClass() {
		
	}
	
	public void Super_Method() {
		System.out.println("SuperClass 내부의 Super_Method");
	}
	

}//end of main 
