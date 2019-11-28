package mainclass;

import child.TomClass;
import parents.ParentsClass;
import child.JaneClass;

public class MainClass {
	
	public static void main(String[] args) {
		TomClass tc= new TomClass();
		
		
		JaneClass jc = new JaneClass();
		
		
//		tc.ParentMethod();
//		jc.ParentMethod();
		
		//overRide 목적 : 하나의 instance형으로 관리를 용이하게하기 위함이다.
		
		
//		부모클래스 인스턴스에 자식클래스 인스턴스생성.
		ParentsClass p1 = new TomClass();
//		p1.ParentMethod();
		
//		부모클래스접근에 자식클래스 필드 생성. 
		ParentsClass p2 = new JaneClass();
		p2.ParentMethod();
		
//		부모클래스 접근에 자식클래스 메소드가 오버라이드 되어있다는게 키 포인트. 
		
		//p1에서 tomclass의 func는 접근이 불가능하다. 
		//일단 부모클래스의 관점에서 접근하는것이기에 자식클래스에 접근이 불가능하기때문.
//		p1.func();
		
		TomClass t= (TomClass)p1;//
		t.func();//접근가능.
//		혹은
		((TomClass)p1).func();//으로도 표현가능하다.
		
		
		
		
/*
 	회사(부모클래스)
 		총무	(자식)
 		개발자(자식)
 		전산소(자식)
	이런식으로 개발가능. 
 */
		
		/*
		TomClass tomArr[] = new TomClass[5];
		JaneClass janeArr[] = new JaneClass[5];
		
		tomArr[0] = new TomClass();
		janeArr[0] = new JaneClass();
		janeArr[1] = new JaneClass();
		
		
		ParentsClass parArr[] = new ParentsClass[10];
		
		parArr[0] = new TomClass();
		parArr[1] = new JaneClass();
		parArr[2] = new JaneClass();
		*/
		
		
		
		
		
		
		
	}//end main
	
}//end of class 
