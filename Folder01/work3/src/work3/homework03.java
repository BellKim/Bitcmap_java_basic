package work3;

import java.util.Scanner;

public class homework03 {

	public static void main(String[] args) {
		// TODO 하나의 수를 입력받고 삼항 연산자를 사용하여 양수임지 음수인지 판단하라.
//		수를입력
		
//		판단
		
//		출력
		
		//양수입니다 출력.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요 양수인지 음수인지 판정해 드립니다.");
		int number = scan.nextInt();
		String msg;
		msg = (number > 0 ) ? "양수입니다.":"음수입니다";
		
		System.out.println(msg);
							
		
		
		
		
		
		
		
		
//		int inputNumber1 = scan.nextInt();
//		if(inputNumber1 <0) {
//			System.out.println("음수입니다.");
//		}else if(inputNumber1 >0 ) {
//			System.out.println("양수입니다.");
//			
//		}else if( inputNumber1 ==0) {
//			System.out.println("0이네요");
//		}else {
//			System.out.println("숫자가 아닙니다.");
//		}
		
		
		
		scan.close();

	}

}
