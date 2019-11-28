package chap13Contructor;

public class MyClass {
	
	private float number;
	
	//컨트롤 스페이스 누르면 컨스트록터로 생성된다. 
	//void는 별도로 호출해줘야 하는 메소드에사용하고 보이드가없으면 이와같이 생성자에 보이드 없이 사용한다. 
	public MyClass() {
		
		System.out.println("myclass 내의 myclass 기본생성자.");
		
	}
	
	public MyClass(int i) {
		System.out.println("myclasss : input int " + i);
	}
	
	public MyClass(int i, int j) {
		System.out.println("myclasss : input int " + i + " j : " + j);
	}
	
	public MyClass(float _number) {
		number = _number;
		System.out.println( " float number" + number);
	}//생성자가 호출됨과 동시에 메소드 변수가 초기화된다. 
	
	public double getNumber() {
		return number;
	}


}//end class
