package chap09Overload;

public class mainClass {

	public static void main(String[] args) {
		/*
			over load : 함수(메소드) 명은 같고
						인자, 인수(매개변수)의 자료형이나
						인수의 갯수가 다른 함수를 의미한다. (동명 2인)
						
			image draw function
			RGB, RGBA(A는 투명도)
			imageDraw(int x, int y)
			imageDraw(int x, int y, int a)
			
			Over Ride -> 상속성, 다양성
			
						
		*/
		
		func();
		func('G');
		func(123);
		func('Z', 123);
		func(123, 'Z');
		

	}//end main

	
	static void func() {
		System.out.println("func() 호출");
	}
	
	static void func(char c) {
		System.out.println("(char c) 까지 호출 : " + c);
	}
	
	static void func(int c) {
		System.out.println("(int c) 까지 호출 : " + c);
	}
	
	static void func(char c, int i) {
		System.out.println("(int c, int i) 까지 호출 : " + c + ", "+ i);
	}
	private static void func(int i, char i2) {
		System.out.println("(int i, char i2) 까지 호출 : " + i + ", "+ i2);
	}
//	private static int func(int i, char i2) {
//		System.out.println("(int i, char i2) 까지 호출 : " + i + ", "+ i2);
//		return 1;
//	}	//오버로딩하는데 있어서 리턴만 추가된건 위반.
	
	/*
	 * private static void func(int k, char l) {//파라미터만 달라도 오류
	 * System.out.println("(int i, char i2) 까지 호출 : " + i + ", "+ i2); }
	 */
	
	
}//end class
