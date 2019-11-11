package viewer;

import java.util.Scanner;

import controller.MemberController;
import dto.MemberDTO;

public class BoardViewer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = new MemberController();

		while (true) {
			// 기본화면에서 로그인할지 종료할지 선택 -> 종료면 종료, 로그인이면 로그인 화면으로 이동한다.
			System.out.println("========= 게시판 입니다. ===========");
			System.out.println("1. 로그인, 2. 종료");
			int choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("1. 로그인,,,,,    2. 회원가입");
				choice = scan.nextInt();
				if(choice == 1) {
					// 로그인 메소드 호출
					MemberDTO logInUser = logIn(scan, memberController);
					if ((logInUser != null)) {
						System.out.println("로그인 성공\n"+ logInUser.getName()  +" 사용자님 환영합니다.");
						//로그인 성공 이후 코드를 여기에
						System.out.println("1. 게시판보기, 2. 회원정보보기");
						choice = scan.nextInt();
						if(choice == 1) {
							//게시판 목록보는 코드부터 들어간다.
						}else if(choice ==2) {
							//회원 정보를 출력하고 수정할 수 있는 코드가 들어간다.
						}
						
					} else {
						System.out.println("로그인 실패 !!!");
					}					
				}else if(choice == 2) {
					//회원가입메소드 실행
					scan.nextLine();
					MemberDTO memberDTO = new MemberDTO();
					System.out.print("사용자 id: ");
					memberDTO.setUserId(scan.nextLine());
					System.out.print("사용자 pw: ");
					memberDTO.setPassword(scan.nextLine());
					System.out.print("사용자 닉네임: ");
					memberDTO.setName(scan.nextLine());
					memberController.insert(memberDTO);
				}
			} else if (choice == 2) {
				System.out.println("이용해주셔섯 감사합니다. ");
				break;
			}
		}

		scan.close();

	}// end of main

	private static MemberDTO logIn(Scanner scan, MemberController memberController) {
		scan.nextLine();//
		System.out.print("ID : ");
		String userId = scan.nextLine();
		System.out.print("Password : ");
		String password = scan.nextLine();
//		if(userId.equals("admin")&&password.equals("111")) {
//			return true;
//		}else {
//			return false;
//		}
		return memberController.selectOne(userId, password);

	}// logIn

}// end of class
