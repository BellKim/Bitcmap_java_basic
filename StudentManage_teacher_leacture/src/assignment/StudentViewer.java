package assignment;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentController;
import dto.StudentDTO;

public class StudentViewer {
	public static void main(String[] args) {
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
		}
		
		scan.close();
	}//end of main
	private static void showAll(Scanner scan, StudentController controller) {
		//static은 클래스에 선언되어있는 메소드를 사용하기위해서 생성자호출해서 .으로 메소드접근해서 실행해야했음
		//static 영역에 붙어있으면 클래스내 변수로 사용할 수있다. 
		ArrayList<StudentDTO> list = controller.selectAll();
		System.out.println("======목록 보기======");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+"번: "+list.get(i));
		}
		System.out.println("1. 새로 입력 2. 개별 보기 3. 돌아가기");
		int choice = scan.nextInt();
		if(choice == 1) {
			//새로 입력하는 메소드 호출
			add(scan, controller);
		}else if(choice == 2) {
			//개별 보기 메소드 호출
			showOne(scan, controller);
		}else if(choice == 3) {
			
		}

}//end of class
