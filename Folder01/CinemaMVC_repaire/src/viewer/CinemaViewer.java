package viewer;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import controller.MovieController;
import dto.MovieDTO;

public class CinemaViewer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MovieController moviecontroller = new MovieController();
		while (true) {
			System.out.println("============비트시네마============");
			System.out.println("1, 영화관리  		2.종료\n> ");
			int choice = scan.nextInt();
			if (choice == 2) {
				System.out.println("안녕히가세요");
				break;
			} else if (choice == 1) {
				showAll(scan, moviecontroller);

			}

		} // while

		scan.close();

	}// end of main

	private static void showAll(Scanner scan, MovieController moviecontroller) {
		ArrayList<MovieDTO> list = moviecontroller.selectAll();
		System.out.println("====================목 록 보 기 =====================");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번" + list.get(i));
		}
		System.out.println("1. 목록보기   2. 개별보기   3.영화목록추가  4.돌아가기");
		int choice = scan.nextInt();
		if (choice == 1) {
			showAll(scan, moviecontroller);
		} else if (choice == 2) {
			showOne(scan, moviecontroller);
		} else if (choice == 3) {
			add(scan, moviecontroller);
		} else if (choice == 4) {

		} else {
			System.out.println("노노염");
		}

	}

	private static void add(Scanner scan, MovieController moviecontroller) {
		MovieDTO m = new MovieDTO();
		scan.nextLine();
		
		System.out.println("영화명 ");
		m.setTitle(scan.nextLine());
		System.out.println("상영시간");
		m.setLength(scan.nextInt());
		moviecontroller.insert(m);
		showAll(scan, moviecontroller);
		
	}

	private static void showOne(Scanner scan, MovieController moviecontroller) {
		System.out.println("개별보기할 목록 선택 하시오.");
		int choice = scan.nextInt();
		MovieDTO movieDTO =  moviecontroller.select(choice);
		System.out.println(movieDTO.getId());
		System.out.println(movieDTO.getLength());
		System.out.println(movieDTO.getTitle());
		System.out.println("=======================================");
		System.out.println("1. 수정    2. 삭제    3. 리스트보기 ");
		choice = scan.nextInt();
		if (choice == 1) {
			update(scan, moviecontroller, movieDTO);
		} else if (choice == 2) {
			delete(scan, moviecontroller, movieDTO);
		} else if (choice == 3) {
			showAll(scan, moviecontroller);
		}

	}

	private static void update(Scanner scan, MovieController moviecontroller, MovieDTO movieDTO) {
		scan.nextLine();
		System.out.println(" 영화타이틀 : ");
		movieDTO.setTitle(scan.nextLine());
		System.out.println(" 상영시간 : ");
		movieDTO.setLength(scan.nextInt());
		moviecontroller.update(movieDTO);
		showAll(scan, moviecontroller);
	}

	private static void delete(Scanner scan, MovieController moviecontroller, MovieDTO s) {
		moviecontroller.delete(s);
		showAll(scan, moviecontroller);
	}

}// end of calss
