package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentController;
import dto.StudentDTO;
//1.학생관리 2.종료
//1-1(학생관리페이지)학생목록
//	1	학생목록출력(select function 실행) 1 누구 2누구
//	실행끝나면= 1. 학생추가 2.학생상세보기
public class StudentManageViewer {
	public static void main(String[] args) {
		System.out.println("hello world");
		Scanner scanner = new Scanner(System.in);
		StudentController studentcontroller = new StudentController();
		
		while(true) {
			System.out.print("학생관리프로그림입니다   \n1.학생목록조회  2.종료 > ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				ArrayList<StudentDTO> list = studentcontroller.selectAll();
				
				for(int i=0; i<list.size(); i++) {
					StudentDTO st = list.get(i);
					System.out.println(i+"번 " + "학번 : "+st.getStudentNo() +
										" 이름 : " + st.getName()+
										" 전공 : " + st.getMajor()+
										" 수학 : "+st.getMath()+
										" 영어 : "+st.getEng()+
										" 수학 : "+st.getMath());
				}
				System.out.println("1. 학생리스트추가     2. 학생상세정보 보기");
				choice =scanner.nextInt();
				if(choice == 1) {//학생추가
					StudentDTO studentDTO = new StudentDTO();
					scanner.nextLine();
					System.out.println("학번입력 : ");
					studentDTO.setStudentNo(scanner.nextInt());
					scanner.nextLine();
					System.out.println("학생이름입력 : ");
					studentDTO.setName(scanner.nextLine());
					System.out.println("전공입력 : ");
					studentDTO.setMajor(scanner.nextLine());
					System.out.println("한국어점수입력 : ");
					studentDTO.setKor(scanner.nextInt());
					System.out.println("영어점수입력 : ");
					studentDTO.setEng(scanner.nextInt());
					System.out.println("수학점수입력 : ");
					studentDTO.setMath(scanner.nextInt());
					studentcontroller.insert(studentDTO);
					
					
				}else if(choice == 2) {//학생상세보기
					
				}else {
					System.out.println("잘못입력했습니다. (2depth) ");
				}
				
			}else if(choice ==2 ) {
				System.out.println("프로그램을 최종적으로 종료합니다.");
				break;
			}else {
				System.out.println("올바른 값을 입력해주세요.");
			}

			
		}//end of while
		
		System.out.println("\n\n\n\nwhile 문 탈출 . 프로그램 종료.\n\n\n\n");
	}//end of main

}//end of class
