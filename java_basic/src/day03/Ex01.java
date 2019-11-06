package day03;

import java.util.Scanner;

//스캐너버그

public class Ex01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("회원번호  : ");
		int userId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("회원이름 : ");
		String name = scanner.nextLine();
		
		System.out.println("번호 : " + userId );
		System.out.println("회원이름 : " + name);
		
		
		
		scanner.close();
		

	}//end of main

}//end of class


//scanner 는 버퍼메모리에 입력받아서 변수에 저장이되는데
//엔터를 누르면 종료가 되어버리는데
//다음 문구를 입력시키기위해 엔터를 누르면 종료시켜버림. 
//그러나 scanner.nextline();
//을 입력해주면 입력된 엔터를 버리고 줄바꿈을 입력해준다(버퍼를 비워준다.)




