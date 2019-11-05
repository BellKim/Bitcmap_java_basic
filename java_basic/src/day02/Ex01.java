package day02;

import java.util.Scanner;

//while loop
public class Ex01 {

	public static void main(String[] args) {
//		while문은 
//		괄호안에 조건식이 들어가고
//		false가 나올때까지 반복된다.
		
		int i=10;
		while(i>0) {
			System.out.println(i);
			i--;
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("비트성적관리 프로그램");
			System.out.println("1.입력, 2.출력, 3.종료");
			System.out.println(">  ");
			int choice = scanner.nextInt();
			if(choice == 3) {
				System.out.println("이용해줘서 감사합니다.");
				break;
			}
		}
		
		int j = 0;
		do {
			System.out.println(j);
			j--;
		} while (j>0);
		//j가 0이 입력되었을떄는 0이 출력이 된다. do while do가 실행된 다음에  while 은 적어도 한번은 실행된다.
		
		while(j>0) {
			System.out.println(j);
		}//하지만 그냥 while 문은 그냥 실행아 안된다.
		
		
		
		
		
		
	}//end of main

}//end of class
