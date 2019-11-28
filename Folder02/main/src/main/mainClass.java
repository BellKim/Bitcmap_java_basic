package main;

public class mainClass {

	public static void main(String[] args) {
		myClass cls = new myClass();
		cls.method();
		cls.method();
		cls.method();
		
		myClass cls1 = new myClass();
		cls1.method();

	}
	
	
	

}

//클래스에서의 final은 상속금지
//final class myClass{
class myClass{
	private int number;
	public static int stNumber;
	
	//상수 final
	//상수를 표현할때는 가독성을 위해서 전체 대문자를 사용한다.
	final int NUMBERFINAL = 3;
	
	
	
//	public final method() {
//	void는 기본생성자에 붙혀주면 상속금지가된다.
	public void method() {	
		int num=0; // local 변수
		num++;
		this.number++;
		stNumber++;
		
		System.out.println("locla num = " + num);
		System.out.println("private number = " + number);
		System.out.println("public statuc stNumber = " + stNumber);
		
		System.out.println();
		
	}
	
//	Object mcls = new YouClass();
//	//object 클래스는 어떠한 데이터도 다 담을수 있다. 
//	
////	myClass my = mcls;//오류
//	myClass my = (myClass)mcls;
//	YouClass yo = (YouClass)my;
//	
//	YouClass yc1 = new YouClass();
	
}

class YouClass extends myClass{
//	public void method() {
//
//		
//	}
	
	
}



