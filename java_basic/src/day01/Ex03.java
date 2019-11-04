package day01;
//control문

//조건문, 반복문
//조건문1

public class Ex03 {

	public static void main(String[] args) {
//		if문
//		해당 조건식이 true 가 나오면 code block이 실행된다.
//		code block이란
//		해당 code가 속한 { }
//		if -> if else -> if else if else
		
		int myInt = 10;
		if (myInt <= 10) {
			System.out.println("10보다 작거나 같다. ");
		} else {
			//else는 if문의 조건식이 true가 아닌 모든 경우
			 System.out.println("10보다 크다");
		}
		
		if(myInt >100) {
			System.out.println("100보다 큽니다. ");
		}else if(myInt >=10){
			System.out.println("10보다 크지만 100보다 작거나 같다.");
		}else {
			System.out.println("10명 이하입니다.");
		}
		
		myInt = 120;
		//아래코드는 위의 코드와 결과가 틀리게 된다.
		if(myInt>100) {
			System.out.println("100초과");
		}
		if(myInt>10) {
			System.out.println("10초과");
		}
		
		String string1 = null;
		if(string1 != null) {
			if (string1.equals("abc")) {
				System.out.println("abc와 같습니다.");
			}else {
				System.out.println("abc와 다릅니다. ");
			}	//해당 예제는 nullpointerException 이 출력된다. 왜냐하면, 값이 생성되어 있지 않기때문에 오류가 뜸.
		} else {
			System.out.println("null 입니다. 확인해주세요");
		}
		
		
		
		if (string1 != null && string1.equals("abc")) {//false && false 연산 -> false 출력 
			System.out.println("abc와 같습니다.11111");
		} else {
			System.out.println("abc와 다릅니다.222222 ");
		} // 해당 예제는 nullpointerException 이 출력된다. 왜냐하면, 값이 생성되어 있지 않기때문에 오류가 뜸.
		
		

	}
}



