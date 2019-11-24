package assignment;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentController;
import dto.StudentDTO;
//1.학생관리 2.종료
//1-1(학생관리페이지)학생목록
//	1	학생목록출력(select function 실행) 1 누구 2누구
//	실행끝나면= 1. 학생추가 2.학생상세보기
public class StudentViewer_my {
	public static void main(String[] args) {
		System.out.println("hello world");
		Scanner scan = new Scanner(System.in);
		StudentController controller = new StudentController();
		
		while(true) {
			System.out.println("======= 비트 학생관리 프로그램 ========");
			System.out.println("1. 전체보기,  2. 새로입력    3. 종료!");
			int choice = scan.nextInt();
			if(choice == 3) {
				System.out.println("이용해주셔서감사합니다.");
				break;
			}else if(choice == 1) {
				//전체보기 메소드 실행
				showAll(scan, controller);
			}else if (choice == 2) {
				//새로 입력 매소드 실행
				add(scan, controller);
			}
			
		}//end of while
		
		System.out.println("\n\n\n\n while 문 탈출 . 프로그램 종료.\n\n\n\n");
	}//end of main



	private static void showAll(Scanner scan, StudentController controller) {
		ArrayList<StudentDTO> list = controller.selectAll();
		System.out.println("목록보기 ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i +"번 " + list.get(i));
		}
		System.out.println("1. 새로입력  2.개별보기 3.돌아가기");
		int choice = scan.nextInt();
		if(choice == 1) {//새로입력
			add(scan, controller);
		}else if(choice ==2) {//개별보기
			showOne(scan, controller);
		}else if(choice ==3) {//돌아가기
			
		}
		
	}

	private static void add(Scanner scan, StudentController controller) {
		StudentDTO s = new StudentDTO();
		scan.nextLine();
		System.out.print("이름: ");
		s.setName(scan.nextLine());
		System.out.print("전공: ");
		s.setMajor(scan.nextLine());
		System.out.print("국어: ");
		s.setKor(scan.nextInt());
		System.out.print("영어: ");
		s.setEng(scan.nextInt());
		System.out.print("수학: ");
		s.setMath(scan.nextInt());
		controller.insert(s);
		showAll(scan, controller);
	}
	
	
	private static void showOne(Scanner scan, 
			StudentController controller) {
		//개별로 보고자 할때
		System.out.println("개별로 보고자 하는 번호를 입력하세요");
		int choice = scan.nextInt();
		StudentDTO s = controller.select(choice);
		System.out.println("=-===== " + s.getName() + "학생정보 ======= ");
		System.out.println("이름"+s.getName());
		System.out.println("학번"+s.getStudentNo());
		System.out.println("전공"+s.getMajor());
		System.out.println("국어점수"+s.getKor());
		System.out.println("영어점수"+s.getEng());
		System.out.println("수학점수"+s.getMath());
		System.out.println("========================================");
		System.out.println("1. 수정    2. 삭제    3. 리스트보기 ");
		choice = scan.nextInt();
		if(choice==1) {
			update(scan, controller, s);
		}else if(choice == 2) {
			delete(scan, controller, s);
		}else if(choice ==3) {
			showAll(scan, controller);
		}
	}

	private static void update(Scanner scan, 
			StudentController controller, StudentDTO s) {
		scan.nextLine();
		System.out.println("이름 : ");
		s.setName(scan.nextLine());
		System.out.println("전공 : ");
		s.setMajor(scan.nextLine());
		System.out.println("국어점수 : ");
		s.setKor(scan.nextInt());
		System.out.println("영어점수 : ");
		s.setEng(scan.nextInt());
		System.out.println("수학점수 : ");
		s.setMath(scan.nextInt());
		controller.update(s);
		showAll(scan, controller);
		
	}

	private static void delete(Scanner scan, 
			StudentController controller, StudentDTO s) {
		controller.delete(s);
		showAll(scan, controller);
	}
}//end of class
