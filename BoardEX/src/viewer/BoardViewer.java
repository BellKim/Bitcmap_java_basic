package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BoardController;
import controller.MemberController;
import dto.BoardDTO;
import dto.MemberDTO;

public class BoardViewer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = new MemberController();
		BoardController boardController = new BoardController();
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
							ArrayList<BoardDTO> list = boardController.selectAll();
							SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
							System.out.println("글번호 \t  제목 \t 작성자 \t 작성일 ");
							for(BoardDTO b: list) {
								System.out.printf("%d\t%s\t%s\t%s\n", 
										b.getId(),
										b.getTitle(),
										memberController.getWriterName(b.getWriterId()), //b.getWriterId(),
										sdf.format(b.getUpdateDate().getTime())
										);
							}
							
							System.out.println("1. 새조작성    2. 개별보기 ");
							choice = scan.nextInt();
							if(choice == 1) {
								//글 새로작성 코드
							}else if(choice == 2) {
								//글 번호 선택해서 개별보기 코드
								System.out.println("개별 보기할 글 번호를 입력하세요 : ");
								int boardId = scan.nextInt();
								BoardDTO selectedBoard = boardController.selectOne(boardId);
								if(selectedBoard == null) {
									System.out.println("게시글이 없습니다.");
								}else {
									sdf = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm문 ss초");
									System.out.println("==========");
									System.out.println("제목 : " + selectedBoard.getTitle());
									System.out.println("==========");
									System.out.println("작성자 : " + memberController.getWriterName(selectedBoard.getWriterId()));
									System.out.println("==========");
									System.out.println("작성일 : "+ sdf.format(selectedBoard.getWrittenDate().getTime()));
									System.out.println("==========");
									System.out.println("수정일 : "+ sdf.format(selectedBoard.getUpdateDate().getTime()));
									System.out.println("==========");
									System.out.println("     내    용     ");
									System.out.println("==========");
									System.out.println(selectedBoard.getContent());
									System.out.println("==========");
									System.out.println("1.수정   2. 삭제");
									choice = scan.nextInt();//입력 초기화 한다.
									if(choice == 1) {
										//수정하는 코드 실행    		제목과 내용만 수정되면된다.
										scan.nextLine();
										System.out.println("제목 :" );
										selectedBoard.setTitle(scan.nextLine());
										System.out.println("내용 :" );
										selectedBoard.setContent(scan.nextLine());
										boardController.update(selectedBoard);
										
									}else if(choice ==2 ) {
										//삭제하는 코드실행
//										scan.nextLine();
										boardController.delete(selectedBoard);
									}
								
									
								}
							}
							
						}else if(choice ==2) {
							//회원 정보를 출력하고 수정할 수 있는 코드가 들어간다.
							System.out.println("==========");
							System.out.println("이름 : " + logInUser.getName());
							System.out.println("비밀번호 : " + logInUser.getPassword());
							System.out.println("==========");
							System.out.println("작성글 목록" + logInUser.getPassword());
							ArrayList<BoardDTO> list = boardController.selectAll(logInUser.getId());
							
							SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
							System.out.println("글번호 \t 제목 \t 작성자 \t 작성일");
							for (BoardDTO b : list) {
								System.out.printf("%d\t%s\t%s\t%s\n", b.getId(), b.getTitle(),
								        memberController.getWriterName(b.getWriterId()),
								        sdf.format(b.getUpdateDate().getTime()));
							}
							System.out.println("1. 회원정보 수정 2. 회원탈퇴");
							System.out.print("> ");
							choice = scan.nextInt();
							if(choice == 1) {
								scan.nextLine();
								System.out.println("이름 : ");
								logInUser.setName(scan.nextLine());
								System.out.print("비밀번호 : ");
								logInUser.setPassword(scan.nextLine());
								memberController.update(logInUser);
							}else if(choice == 2) {
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
