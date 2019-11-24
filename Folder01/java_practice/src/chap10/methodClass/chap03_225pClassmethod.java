package chap10.methodClass;
import java.lang.Math;

class NumberPrinter{
	private int myNum = 0;
	
	static void showInt(int n) {		//static 메소드
		System.out.println(n);
	}
	
	static void showDouble(double n) {	//static 메소드
		System.out.println(n);
	}
	
	void setMyNumber(int n) {
		myNum = n;
	}
	
	void showMyNumber() {
		showInt(myNum);
	}
	
}//end class

class chap03_225pClassmethod {
	
	public static void main(String[] args) {
		
		NumberPrinter numPrint = new NumberPrinter();//본래 선언방식
		numPrint.showInt(30);	//The static method showInt(int) from the type NumberPrinter should be accessed in a static way
								//넘버프린터 타입의  스테틱 메소드 showInt는  스테틱방법으로 억세스 해야합니다.
		
		NumberPrinter.showInt(20); //스테틱을 선언하면  인스턴스 생성을 하지 않아도 호출이 가능하다.
		NumberPrinter.showDouble(22.55);
		

		double num = Math.PI;
		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.6);
		np.setMyNumber(75);
		np.showMyNumber();
		
		System.out.println(Math.PI);

	}//end of main

}//end of class



