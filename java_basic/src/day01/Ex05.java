package day01;

public class Ex05 {

	public static void main(String[] args) {
//		삼항연산자란
//		if나 switch없이
//		조건문을 만든다
//		다만 단독 실행을 불가하고
//		return 이나 초기화에만 사용할 수 있다.
		String result = "";
		int myNumber1 = 10;
		int myNumber2 = 15;
		result = myNumber1 < myNumber2 ? "myNumber2가 더큽니다." : "myNumber1이 더큽니다.";
		
		System.out.println("result 결과값 : " + result);
		
//		삼항연산자 안에서 System.out.println( ); 문을 사용할 수 없다.
		
		
		
//		윤년의 조건:
//		1. 4로나누어 떨어지고
//		2. 4로 나누어 떨어지지만 100으로 안나눠 떨어지고
//		3. 4로 나누어 떨어지고 100으로 나누어 떨어지지만 400으로도 나누어 떨어짐.
//		이 3가지 조건을 이용하여 삼항연산자를 만들어서 1992년이 윤년인지 아닌지를 출력하시오.
		
		int checkYear = 1600;
//		조건? T : F;
		
		result = ((checkYear % 4) == 0) ? 
						(checkYear %100 != 0) ?
							((checkYear % 400) == 0) ? "윤년이다." : "3F 평년이다." : "윤년이다." : "1f 평년이다.";
		
		System.out.println("result = " + result);
		

	}

}
