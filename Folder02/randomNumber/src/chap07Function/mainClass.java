package chap07Function;

public class mainClass {

	public static void main(String[] args) {
		/*
			function : 함수, 독립적 c언어 - function method :함수, 클래스에 종속적 java - class
		 * 
		 * 구성요소 들어가는 값 : 매개변수, 인수, 인자, Parameter 돌려주는값 : return값
		 * 
		 * Oracle - PL [오라클언어를 함수화 시킨것.]
		 * 
		 * 함수의 형식 return값(자료형) 함수명(자료형 변수(가인수)){ 가인수 = 가상의인수, 대입변수 처리싟 return 값 ; }
		 * 
		 * int, float, double, String[], void int functionName(char c, int i){ //처리식
		 * return 값; }
		 * 
		 * 장점 : 코드를 간략화 할 수 있다. 동일한 처리의 코드를 여러번 작성할 필요가 없다. 소스의 분업이 가능해진다.
		 * 
		 * 
		 */

		funcName();
		funcName1(23);
		funcName2("hello", 'd');
		int r = funcName3(3.3);
		System.out.println("funcName3의 return값 : " + r);
		int ask = getAscIIcode('a');
		System.out.println("아스키코드값 " + ask);
		double d = funcNmae4();
		System.out.println("double d " + d);

	}// end main

	static void funcName() {
		System.out.println("funcNmae() 호출");
	}

	static void funcName1(int i) {
		System.out.println(" function1(int i)  호출 i = " + i);
	}

	static void funcName2(String str, char c) {
		System.out.println(":static void funcName2(String str, char c) ");
		System.out.println("str = " + str + "  c = " + c);
		str = "world";
		System.out.println("str change = : " + str);

	}

	static int funcName3(double d) {
		System.out.println("static int funcName3(double d)= " + d);
		return 11;
	}

	static int getAscIIcode(char c) {
		return (int) c;// 문자열을 아스키코드값으로 출력한다.
	}

	static double funcNmae4() {
		return 1.234567;
	}

}// end class
