package test;
/*
소스코드 작성 
 
compile (문자코드 -> 기계어(2진수)) - lib파일(*.jar)

build == .exe 실행파일 생성   (exe = execute)

실행
*/

/*

	정수 ==상수
	2진수		0, 1					1100 1010	
	8진수		0 ~ 7 -> 010 -> 8		8421 8421
	10진수	0~9						
	16진수	0 ~ 9 A ~ F (15)		C	 A
	
	변수 : 특정 이름을 정하고 값을 원하는경우 변경할 수 있는 수
	name value 
	AAA <- 24
	AAA -> 24
	AAA <- 12
	AAA -> 12
	
	변수 설정법은 옆사람이 봐도 알아볼 수 있는 방법으로 지정한다.
	
	 int studentNumber;
	 int stuNum; 카멜법
	 
	 예약어를 변수로 사용할 수 없다. (int int;) 불가능.
	 변수로 되지 않는것 
	 int -num;	연산자가 앞머리에불가.
	 int 12num; 접두에 숫자가 들어갈 수 없다. 
	 int 123 	숫자로만 이루어진 변수는 사용불가하다. 

	


*/

public class mainClass {
	public static void main(String[] args) {
		
		
		System.out.print(010);
		
		/*
			변수의 자료형
			숫자형
				정수
				byte			1byte => 8bit -=> 256개    -128 ~ +128
				short			2byte => 
				integer(int)	4byte 
				long			8byte
				
				실수형
				float 			4byte
				double			8byte
				
			문자형
		 		문자
		 		char 		2byte	 character c언어 -> 1byte
		 		
		 		문자열
		 		Char arrChar[] = new char[10]; -> String
		 		String -> class		wrapper classs
		 		
		 	true/false
		 		boolean 1 byte  true(1)/false(0)
		 		
		 		boolean -> bool(1)  true/false 0, 1  , BOOL(4) TRUE/FALSE  0과 1에서 1100까지입력가능.    

		 */
		
		
		
		int number;			//4byte 영역
		//자료형 : integer 
		//변수명 : number
		number = 123;
		System.out.println(number);
		number = 234;
		System.out.println(number);
		
		byte by1 = -128;
		
		float f;
		f = 123.423f;//플루트는 숫자뒤에 f가 붙어야 float 로 인식. 
					//f 가 없으면 double 로 인식된다. 
		
		System.out.println("f = " + f);
		
		char c;
		c = '한';
		c = 'A';	//아스키코드
		System.out.println("c = " + c);
		System.out.printf("c = %c (int)%d", c, (int)c);
		
		//문자열 String != 자료형이 아니다. Class 이다. 
		//Wrapper class == 자료형을 class로 만들어 놓은것.
		String str;
		str = "안녕하세요";
		str = "반갑습니다.";
		
		char cStr[] = new char[5];
		cStr[0] = '안';
		cStr[1] = '녕';
		cStr[2] = '하';
		
		char cStr1[] = {'안', '녕','하','세','요','?'};
		
		System.out.println(cStr);
		System.out.println(cStr1);
		
		
		
//		escape sequence
//		 \n 개행
//		 \t 탭
//		 \b 
//		 \"
//		 \'
//		 \\ 은 역슬레쉬
		System.out.println("\\ hello world \n Javva \t world \\");
		
		
		
		
	}//end of main
}//end of class
