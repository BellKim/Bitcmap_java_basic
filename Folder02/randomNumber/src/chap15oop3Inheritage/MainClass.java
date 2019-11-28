package chap15oop3Inheritage;

import chap15oop3Inheritage_child.ChildClass;

/*
	상속을 받으면 받을수록 요소가 늘어난다. 
	
*/
public class MainClass {
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		
		cc.Super_Method();
		cc.child_func();
		
		SuperClass sc = new SuperClass();
		sc.Super_Method();
//		sc.child_func();//부모클래스에서 자식클래스 접근불가, 오류.
//		cc.pub_name = "aaaa"; //public 변수이기에 접근가능하기에 은닉성에 위배되므로 사용시 유의할것.
//		cc.pro_name = "bbb";	//
//		cc.pub_name = "aaa";
//		cc.pro_name = "hello";
		
		
		
	}//end main()

}//end class
