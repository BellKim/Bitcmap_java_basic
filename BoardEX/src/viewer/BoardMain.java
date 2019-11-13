package viewer;


import java.util.Scanner;
import controller.BoardController;
import controller.CommentController;
import controller.MemberController;
import dto.MemberDTO;

public class BoardMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = new MemberController();
		BoardController boardController = new BoardController();
		BoardViewer boardViewer = new BoardViewer();
		MemberViewer memberViewer = new MemberViewer();
		CommentController commentController = new CommentController();
		
		while (true) {
			// 기본화면에서 로그인할지 종료할지 선택 -> 종료면 종료, 로그인이면 로그인 화면으로 이동한다.
			System.out.println("========= 게시판 입니다. ===========");
			System.out.println("1. 로그인, 2. 회원가입  2. 종료");
			int choice = scan.nextInt();
			if (choice == 1) {
					// 로그인 메소드 호출
					MemberDTO logInUser = memberViewer.logIn(scan, memberController);
					if ((logInUser != null)) {
						System.out.println("로그인 성공\n"+ logInUser.getName()  +" 사용자님 환영합니다.");
						//로그인 성공 이후 코드를 여기에
						while(true) {
							System.out.println("1. 게시판보기, 2. 회원정보보기, 3. 로그아웃");
							choice = scan.nextInt();
							if(choice == 1) {
								//게시판 목록보는 코드부터 들어간다.
								boardViewer.showList(boardController, memberController, commentController, scan, logInUser);
							} else if (choice == 2) {
								// 회원 정보를 출력하고 수정할 수 있는 코드가 들어간다.
								memberViewer.showOne(logInUser, scan, memberController, boardController);
							} else if(choice == 3) {
								//로그아웃	
								System.out.println("로그아웃 되었스비다.");
								//로그인유저를 주석처리 해야한다.
								logInUser=null;
								break;
							}
							
						}//while()
					} else {
						System.out.println("로그인 실패 !!!");
					}	
				}else if(choice == 2) {
					//회원가입메소드 호출
					memberViewer.insert(memberController, scan);
					
			} else if (choice == 3) {
				System.out.println("이용해주셔섯 감사합니다. ");
				break;
			}
		}
		scan.close();
	}// end of main
}// end of class
