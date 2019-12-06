package main;

import java.util.Scanner;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDao dao = new MemberDao();
		
		while(true) {
			System.out.println("1.데이터의 추가(insert)");	// create
			System.out.println("2.데이터의 삭제(delete)");	// delete
			System.out.println("3.데이터의 검색(select)");	// read
			System.out.println("4.데이터의 수정(update)");	// update
			System.out.println("5.데이터 모두 출력");
			System.out.println("6.프로그램 종료");
			
			System.out.print("메뉴번호를 입력해 주십시오 >> ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allprint();
					break;
				case 6:
					System.exit(0);					
					break;
				default:	
					System.out.println("잘못 입력하셨습니다");			
			}
		}
	}	

}
