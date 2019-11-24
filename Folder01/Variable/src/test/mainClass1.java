package test;

import java.util.Scanner;
//scanner -> 클래스

public class mainClass1 {

	public static void main(String[] args) {
		// input
		Scanner scan = new Scanner(System.in);
		// 클래스 클래스변수 = class variable
		// 807-162-539
//		boolean b;
//		System.out.println("true/false = ");
//		b = scan.nextBoolean();

		// integer
//		int number;
//		System.out.println("정수  = ");
//		number = scan.nextInt();
//		System.out.println("number = " + number );
		
		//String = 문자열
//		String str;
//		System.out.println("str : ");
//		str = scan.next();
//		System.out.println("str = " + str);
		
		
		System.out.println("num = ");
		int num = scan.nextInt();
		
		System.out.println("str = ");
		String str = scan.nextLine();//한 라인에 대해서 입력을 받는다. 
		
		
		System.out.println("num = " + num);
		System.out.println("str = " + str);
		
		
		
		
		
		

	}

}
