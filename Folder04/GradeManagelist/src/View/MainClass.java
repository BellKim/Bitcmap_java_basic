package View;

import java.util.Scanner;

import DAO.ManageDAO;

public class MainClass {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		ManageDAO dao = new ManageDAO();
		dao.baseData();
		dao.showAll();
		
		
		
		
		int choice;
		while(true) {
			System.out.println("1. 학생정보 추가(이름, 나이, 영어점수, 수학점수)");
			System.out.println("2. 학생정보 삭제");
			System.out.println("3. 학생정보 검색");
			System.out.println("4. 학생정보 수정");
			System.out.println("5. 학생성적 조회(1명에 대한 정보만 조회하기) 총점");
			System.out.println("6. 학생성적 총점");
			System.out.println("7. 학생성적 평균	");
			System.out.println("8. 학생성적순 출력(총점에 대한 출력)");
			System.out.println("9. 전체조회.");
			System.out.println("0. 프로그램 종료.");
			
			System.out.print("메뉴번호를 입력해 주십시오 >> ");
			choice = sc.nextInt();

	
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
//					dao.selectOne();//총점출력
					dao.lastCheck();
					break;
				case 6:
					dao.studentTotal();
					break;
				case 7:
					dao.studentAvg();
					break;
				case 8:
					dao.TopToBottom();
					break;
					
				case 9:
					dao.showAll();
										
					break;
					
				case 0:
					System.exit(0);
				default:	
					System.out.println("잘못 입력하셨습니다");			
			}
		}
		
		
		

	}//end of main

}//end of class
