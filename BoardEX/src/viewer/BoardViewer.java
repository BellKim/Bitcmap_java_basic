package viewer;

import java.util.Scanner;

import controller.MemberController;
import dto.MemberDTO;

public class BoardViewer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = new MemberController();
		
		while(true) {
			//기본화면에서 로그인할지 종료할지 선택 -> 종료면 종료, 로그인이면 로그인 화면으로 이동한다.
			System.out.println("========= 게시판 입니다. ===========");
			System.out.println("1. 로그인, 2. 종료");
			int choice = scan.nextInt();
			if(choice == 1) {
				MemberDTO logInUser = logIn(scan, memberController);
				//로그인 메소드 호출
				if((logInUser != null) == true) {
					System.out.println("로그인 성공\n admin사용자님 환영합니다.");
				}else {
					System.out.println("로그인 실패 !!!");
				}
			}else if(choice == 2) {
				System.out.println("이용해주셔섯 감사합니다. ");
				break;
			}
		}
		
		
		
		
		scan.close();

	}//end of main
	
	private static boolean logIn(Scanner scan) {
		scan.nextLine();//
		System.out.print("ID : ");
		String userId = scan.nextLine();
		System.out.print("Password : ");
		String password = scan.nextLine();
		if(userId.equals("admin")&&password.equals("111")) {
			return true;
		}else {
			return false;
		}
		
	}//logIn
	

}//end of class
