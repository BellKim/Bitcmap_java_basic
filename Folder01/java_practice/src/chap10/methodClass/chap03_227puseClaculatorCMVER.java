package chap10.methodClass;
//메소드에 static 을 추가함으로서 메인문에서 인스턴스생성을 하지 않고 바로 호출할 수있다. 
//바로 호출을 하면서 코드의 간결함을 볼 수 있다.
//1. 모두 외부에 기능을 제공하기 위해서 사용함. 2. 모두 인스턴스 변수의 값을 참조하거나 수정하지 않는다.(값 받아서 리턴하는경우) 
class sc{
	static final double PI = 3.141592;
	int num11 = 726;
	
	static double add(double n1, double n2) {
		return n1 + n2;
	}
	static double min(double n1, double n2) {
		return n1 + n2;
	}
	static double calCircleArea(double r) {
		return PI*r*r;
	}
	static double calCirclePeri(double r) {
		return PI * (r*2);
	}
	
	static void printOUT(int i) {
		System.out.println("값을 출력합니다. " + i + " 여기까지. ");
		System.out.println("파이프린트 " + PI+"끝. " );
//		System.out.println("넘프린트" + num11 + "끝.");//오류
		//Cannot make a static reference to the non-static field num11
		
		
	}
	
	
}//end sc


public class chap03_227puseClaculatorCMVER {
	public static void main(String[] args) {
//		System.out.println(sc.add(3, 4));
//		System.out.println(sc.calCircleArea(2.2));
//		
//		System.out.println(sc.min(15, 7));
//		System.out.println(sc.calCirclePeri(5.0));
		
		sc.printOUT(44);
		
		
		
	}//end main


}
