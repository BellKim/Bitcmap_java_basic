package day14.chap02Example;

import java.util.Scanner;



public class example03 {
	public static void main(String[] args) {
//		3문 두개의 수를 입력받고 계산결과를 출력하라. 문자가 포함되었는지 조사하라. (+ - * 나누기 가 입력되었는지 조사.)
		// 두개의 수를 입력받고 계산 결과를 출력하라.
		// 문자 포함되었는지 조사.
		// ( + - * / ) 포암되어있는지 조사하기.
		Scanner sc = new Scanner(System.in);

		String num1, num2;
		String oper;
		boolean stop = true;
		
		while(true) {
			stop = true;
			
			System.out.print("첫번째 수 = ");
			num1 = sc.next();	
			
			// 문자 포함되어 있는지 조사
			for(int i = 0;i < num1.length(); i++) {
				char c = num1.charAt(i);	// 1a2
				int asccode = (int)c;
				if(asccode < 48 || asccode > 57) {
					stop = false;
					break;
				}
			}
			
			if(stop == false) {
				System.out.println("숫자가 아닙니다. 다시 입력해 주십시오");
				continue;
			}
			break;
		}
		while(true) {
			stop = true;
			
			System.out.print("첫번째 수 = ");
			num2 = sc.next();	
			
			// 문자 포함되어 있는지 조사
			for(int i = 0;i < num2.length(); i++) {
				char c = num2.charAt(i);	// 1a2
				int asccode = (int)c;
				if(asccode < 48 || asccode > 57) {
					stop = false;
					break;
				}
			}
			
			if(stop == false) {
				System.out.println("숫자가 아닙니다. 다시 입력해 주십시오");
				continue;
			}
			break;
		}
		
		
		// (+, -, *, /) ->
		while(true) {
			System.out.print("연산자(+, -, *, /) = ");
			oper = sc.next();			
			if(oper.equals("+")){
				System.out.println("연산합니다.\n" + num1+oper+num2 +"="+(Integer.parseInt(num1)+Integer.parseInt(num2)));
				break;
			}else if(oper.equals("-")) {
				System.out.println("연산합니다.\n" + num1+oper+num2 +"="+(Integer.parseInt(num1)-Integer.parseInt(num2)));
				break;
			}else if(oper.equals("*")) {
				System.out.println("연산합니다.\n" + num1+oper+num2 +"="+(Integer.parseInt(num1)*Integer.parseInt(num2)));
				break;
			}else if(oper.equals("/")) {
				System.out.println("연산합니다.\n" + num1+oper+num2 +"="+(Integer.parseInt(num1)/Integer.parseInt(num2)));
				break;
			}else {
				System.out.println("연산자를 잘 못 입력하셨습니다. 다시 입력하세요");
			}
		}


//		Scanner scan = new Scanner(System.in);
//		String inputNum1;
//		String inputNum2;
//		

//		
//		
//		while(true) {
//			
//			System.out.println("두개의 수를 입력해주세요 ");
//			System.out.println("첫번째수 : ");
//			inputNum1 = scan.nextLine();
//
//			
//			for (int i = 0; i < inputNum1.length(); i++) {
//				if(inputNum1.charAt(i)>=48 && inputNum1.charAt(i)<=57) {		//48~57아스키코드 숫자범위
//					System.out.println("숫자입력확인. : " + inputNum1.charAt(i) );
//				}
//			}
//			
//	
//		}
//		
//		while(true){
//		
//			System.out.println("두번째수 : ");
//			inputNum2 = scan.nextLine();
//			
//			for (int i = 0; i < inputNum2.length(); i++) {
//				if(inputNum2.charAt(i)>=48 && inputNum2.charAt(i)<=57) {		//48~57아스키코드 숫자범위
//					System.out.println("문자열발견 : " + inputNum2.charAt(i) );
//				}
//			}
//		}
//
//		scan.close();
	}// end main

}// end class
