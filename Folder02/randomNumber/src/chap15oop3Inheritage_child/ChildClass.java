package chap15oop3Inheritage_child;

import chap15oop3Inheritage.SuperClass;

public class ChildClass extends SuperClass {
	//상속은 다중상속이 불가하다. 
	public ChildClass() {
		
		
	}
	
	public void child_func() {
		System.out.println("ChildClass 의 child_func");
		
//		pri_name 부모클래스의 자산이므로 접근이 불가하다. 
		pub_name = " ";//부모클래스의 public 이므로 접근가능하다.
		pro_name = "aaaa";//protected 는 같은 패키지 내에서는 부모클래스의 내용에 접근이 가능하지만, 다른 패키지로 넘어가면 접근이 불가능하다.
							//접근하게 하려면 getter Setter로 해야한다. 
		
		
		
	}
	
	//부모클래스의 메소드에서 추가됨. 
	
	public void Super_Method() {
		System.out.println("child class 에서 추가됨 ");
		
	}

}//end of ChildClass
