package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BoardController;
import controller.MemberController;
import dto.BoardDTO;
import dto.MemberDTO;

public class MemberViewer {
	public void showOne(MemberDTO logInUser, 
				Scanner scan, MemberController memberController,
				BoardController boardController) {
			
			System.out.println("==========");
			System.out.println("이름: " + logInUser.getName());
			System.out.println("비밀번호: " + logInUser.getPassword());
			System.out.println("==========");
			ArrayList<BoardDTO> list = boardController.selectAll(logInUser.getId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			System.out.println("글번호 \t 제목 \t 작성자 \t 작성일");
			for (BoardDTO b : list) {
				System.out.printf("%d\t%s\t%s\t%s\n", b.getId(), b.getTitle(),
				        memberController.getWriterName(b.getWriterId()),
				        sdf.format(b.getUpdateDate().getTime()));
			}
			System.out.println("1. 회원정보 수정 2. 회원 탈퇴");
			System.out.print("> ");
			int choice = scan.nextInt();
			
			if(choice == 1) {
				//수정하는 메소드 실행
				update(logInUser, scan, memberController);
				showOne(logInUser, scan, memberController, boardController);
				
			}else if(choice == 2) {
				//탈퇴 메소드 실행
				delete(logInUser, scan, memberController);
				
			}
		}

	private void delete(MemberDTO logInUser, Scanner scan, MemberController memberController) {
		scan.nextLine();
		System.out.println("정말로 탈퇴하시겠습니까??? 정말???\n (Y/N)");
		String agreement = scan.nextLine();
		if(agreement.equalsIgnoreCase("y")) {
			System.out.println("탈퇴를위해 비밀번호를 다시 입력해주세요");
			String password = scan.nextLine();
			if(password.equals(logInUser.getPassword())) {
				//회원동의하고, 비밀번호도 입력했으니 탈퇴메소드 호출한다.
				memberController.delete(logInUser);
			}
		}
				
		
	}

	private void update(MemberDTO logInUser, Scanner scan, MemberController memberController) {
		scan.nextLine();
		System.out.print("이름: ");
		logInUser.setName(scan.nextLine());
		System.out.print("비밀번호: ");
		logInUser.setPassword(scan.nextLine());
		memberController.update(logInUser);
		
		
	}

	public void insert(MemberController memberController, Scanner scan) {
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

	public MemberDTO logIn(Scanner scan, MemberController memberController) {
		scan.nextLine();
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
	}
	
	
	
	
}//endc class

