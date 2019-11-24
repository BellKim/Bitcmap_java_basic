package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieController;
import dto.MovieDTO;

public class CinemaViewer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MovieController moviecontroller = new MovieController();
		while (true) {
			System.out.println(" 영화 리스트 관리프로그램");
			System.out.println("1. 영화 전체보기, 2. 단일 항목 보기 3. 프로그램 종료");
			int choice = scan.nextInt();
			if(choice == 3) {
				System.out.println("안녕히가세요");
				break;
			}else if(choice == 1) {
				
			}
			
			

			break;
		} // while

		scan.close();

	}// end of main
}// end of calss
