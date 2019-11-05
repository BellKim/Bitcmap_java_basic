package day02;

public class Ex02 {

	public static void main(String[] args) {
		//암시적 형변환
		//더 작은 데이터아입을 큰 데이터아입으로 바꿀 때
		//아무런 명령어 없이 곧장 초기화 가능하다.
		int i = 10;
		long l = i;//암시적 형변환
		
		int j = 10;
		long k = (int)j;//명시적 형변환
		
		//int 타입보다 long 타입의 데이터 크기가 더 크다.
		//long 타입을 int 타입에 저장시 불가능하다. 
//	byte(1byte) < short(2byte) < int(4byte) < long(8byte)
		
		String str = "12345"+6;//문자가 나오면 오류가 출력된다. (문자가 g 에 들어갈때 타입이 달라지므로)
		int g = Integer.parseInt(str);
		System.out.println(g + 6);
	}//main

}//class
