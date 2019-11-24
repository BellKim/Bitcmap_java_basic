package day01;
//자바의 연산자들
//산술 논리 비트 비교 증감

import java.util.Calendar;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//기본형 데이터타입
		
		//8bit 16bit 32bit 64bit 작은실수 큰실수 문자 참/거짓
		//산술 : + - * /
		//32비트ㅇ 운영체제에선, int 형 운영체제로서 4gb 까지만 메모리 부여를 허용할 수 있다.
			//그러나 64bit에서는 
		
		
		//byte short int log float double char boolean
		
						//		메모리 참조형과 메모리 기본형 데이터의 차이 =>  기본형 메모리 주소에 주소값을 그대로 가지고 있음. 
						//		그러나 참조형은 메모리의 주소값으로 가면, 그 클래스 변수값이 들어가있는것이 아니라 그객체가 있는 메모리 주소값이 있다.?????????
		//기본형 VS 참조형
		//해당 메모리 위치에 실제값이 들어가면 기본형
		//해당 메모리 위치에 실제값이 아니라 hepa 영역 메모리 주소값이 들어가면 참조형
		//   ** 힙영역은 - 필요에 의해 동적으로 메모리를 할당 할 때 사용 하는 영역임.
		

		//논리 : boolean rkqtdp eogks dustks -> && || !  and or 반전 
		boolean isTrue = true;
		boolean isFalse = false;
		System.out.println(isTrue && isFalse);//둘 다 true 여야 True다. 
		System.out.println(isTrue || isFalse);	//둘 중 하나만 True 여도 true
		System.out.println(!isFalse);	// 해당 연산의 반전
		System.out.println(!isTrue || isFalse);	// F or F => false
		
		//비트 : 2진법수에 대한 연산
//		bit란? 2진법 숫자 한자리 한자리를 비트라함. 
//		8bit 는 8자리 2진법 표현방식
		byte myByte = 3;		//00000011
		byte myByte2 = 4;		//00000100
		byte myByte3 = -10;		//1111 0110
		
		System.out.println(" & 연산  =  " + (myByte & myByte2)); //0
		System.out.println(" || or 연산  =  " + (myByte | myByte2)); //7
		System.out.println(" ^  xor 연산  =  " + (myByte ^ myByte2)); //2진법으로 변환 후 두 숫자의 같은 자리 값이 다르면 1
		System.out.println(" ~ 부정 연산  =  " + (~myByte)); // 1111011 = -4
		System.out.println("<< 시프트연산 "  +  (myByte<<2)); //	00000011 -> 00001100
		System.out.println(">> 시프트연산 "  +  (myByte>>2)); //	00000011 -> 00000000
		
		System.out.println(">> 시프트연산 "  +  (myByte3>>2)); 	//1111 1101
		System.out.println(">> 시프트연산 "  +  (myByte3>>>2)); 	//0011 1101
		
		
		//컴퓨터에선 2진법 숫자의 제일 앞자리는 부호를 뜻한다.
		//또한 숫자체계가 직선이 아닌 원형 체계이기 때무에 
		//0111 1111 +1 은 1000 0000  이 되면서 음수 최소값으로 바뀐다.
		//이러한 숫자체계 때문에 양수 최대값 + 1 이 음수 최소값으로 바뀌는걸
//		overflow 라고 한다. 
//		음수 최소값 -1 이 양수 최대값으로 바뀌는걸 
		//underflow 라고한다.
		
//		강제로 overflow 경험해보기
		System.out.println("바이트 127 = " + (byte)127);
		System.out.println("바이트 128 = " + (byte)128);
		System.out.println("바이트 129 = " + (byte)129);
		
		
		//비교 : 크거나 작거나 같은 비교
		//		>  >=  <  <= != 총 6가지 개념.
		
//		클래스의 비교
		 String string1 = "abc";
		 String string2 = new String("abc");
		 String string3 = "abc";
		 //if compare value, data is all same. but == 연산자 is not true
		 System.out.println(string1 == string2); // f
		 System.out.println(string2 == string3); // f
		 System.out.println(string1 == string3); // t
		 //1과 3은 주소값으 그대로 들어가있는형태. 
		 //문자열의 값을 비교하는것이 아니라 스트링 1,2,3의 주소값을 비교하는것. 
//		 임시변수의 주소값을 가르키는 1,3은 같다고 나오지만 다른주소값이 있는 2 는 다르다고 나올것.
		 
		 System.out.println(string1.equals(string2));// T  해당 주소에 위치해 있는 값의 비교를 하기위한 함수. equals()
		 
		 
		 
		 
		
		
		
		//증감 : ++ -- 
		int myNumber = 5;
		System.out.println(myNumber++);//실행되고 증가, 되므로 출력시 5, 
		System.out.println(myNumber);//증가되서 6
		System.out.println(++myNumber); //증가되고 출력하므로 6+1 = 7
		System.out.println(myNumber);		//출력하면 7
		
		
		
		int number1 = 5;
		int number2 = 10;
		Scanner scanner = new Scanner(System.in);
		Ex02 e = new Ex02();
		Calendar calender = Calendar.getInstance();
		
		System.out.println(number1);
		System.out.println(e);
		System.out.println(calender);
		
		
		

	}

}
