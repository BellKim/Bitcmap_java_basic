package test;

import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		두개의 정수 값을 입력받고 x, y 변수에 저장한 후에 x, y 값을 바꾸고 출력하도록
//
//		프로그램을 작성하라.
//		int x, y;
//		x=1;
//		y=2;
//		
//		결과 x=2 y=1
		/*
		int x;
		int y; 
		int temp=0;
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		y=scan.nextInt();
		
		temp = x;
		x=y;
		y=temp;
		
		System.out.println("x값 : "+x);
		System.out.println("y값 : " + y);
		*/
		
		
		
		
		
		
//		문제2
//		편의점
//		금액 입력을 받는다.
//		지불금액 : 3230원
//		내돈: 10000원줌.
//		
//		거스름돈 : 5000원 -> n개
//				1000원 -> n개
//				500원 -> n개
//				50원 -> n개
//				10원 -> n개
		
		int check=3230;	//3230
		int mymoney=10000;	//10000
		
		
		int res=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("지불금액 : ");
//		input = scan.nextInt();
		System.out.println("내가 낸돈 : ");
//		mymoney = scan.nextInt();
		
		res = mymoney-check;
		System.out.println("res = " + res );
		
//		6770 중에 
		int money10000 = res%10000;
		int money5000 = res%5000;				//6770/5000= 1 ... 1770
		int money1000 = (money5000%1000);		//1770/1000 = 1....770
		int money500 = (money1000%500);//500;
		int money100=(money500%100);
		int money50=(money100%50);
		int money10=(money50%10);
		int calc;
//		System.out.println("  : " + money10000);
		
		calc=res/5000;
		System.out.println(" 5000원 : " + calc + "장");
		
		calc=money5000/1000;
		System.out.println(" 1000원: " + calc + "개 ");
		
		calc=money1000/500;
		System.out.println(" 500원: " +calc + "개 ");
		
		calc= money500/100;
		System.out.println(" 100원: " + calc + "개 ");
		
		calc=money100/50;
		System.out.println(" 50원: " + calc + "개 ");
		
		calc=money50/10;
		System.out.println(" 10원: " + calc + "개");
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		
		
		

	}

}
