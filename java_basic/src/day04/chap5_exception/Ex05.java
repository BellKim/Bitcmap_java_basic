package day04.chap5_exception;
////wrapper class
//wrapper class란?
//기본형데이터타입을 클래스처럼 만들어 놓은것을 
//wrapper 클래스(포장클래스)라고 한다.

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Integer i = 5;
		i = Integer.parseInt("314");
		
		//메소드를 통한 형변환
		//각 wrapper 클래스들은 parse메소드들이 있다
		//String을 해당 클래스로 바꿔준다.
		Scanner scanner = new Scanner(System.in);
		
		
		//예외처리가 된 부분.
		try {
			System.out.print(" plese input number > ");
			String userNumber = scanner.nextLine();
			Integer convertedNumber = Integer.parseInt(userNumber);
			System.out.println(convertedNumber);
			
		}catch (NumberFormatException e) {
			System.out.println("잘못된 형식입니다.!!!");
		}
		System.out.println(i);
		
		
		
		//예외처리가 되지 않은 분.
		System.out.print(" plese input number > ");
		String userNumber = scanner.nextLine();
		Integer convertedNumber = Integer.parseInt(userNumber);
		System.out.println(convertedNumber);
		
		
		
		
	}//end of main
}//end of class
