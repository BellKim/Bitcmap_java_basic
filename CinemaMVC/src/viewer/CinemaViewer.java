package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieController;
import dto.MovieDTO;

public class CinemaViewer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MovieController moviecontroller = new MovieController();
		while (true) {
			System.out.println("--비트 시네마 --");
			System.out.println("1. 영화관리   2. 종료");
			System.out.println(" > ");
			int choice = scanner.nextInt();
			if (choice == 2) {
				System.out.println("사용해주셔서 감사합니다.");
				break;

			} else if (choice == 1) {
				System.out.println("영화관리 페이지");
				System.out.println("1. 목록보기   ");
				System.out.println("> ");
				choice = scanner.nextInt();
				if (choice == 1) {
					ArrayList<MovieDTO> list = moviecontroller.selectAll();
					int index = 0;

					for (int i = 0; i < list.size(); i++) {
						MovieDTO m = list.get(i);
						System.out.println(i + "번 : " + m.getTitle());
					}

					System.out.println("1. 새로입력    2. 상세보기 ");
					choice = scanner.nextInt();
					if (choice == 1) {
						MovieDTO movieDTO = new MovieDTO();
						scanner.nextLine();
						System.out.print("제목 : ");
						movieDTO.setTitle(scanner.nextLine());
						System.out.print("길이 : ");
						movieDTO.setLength(scanner.nextInt());
						moviecontroller.insert(movieDTO);
					} else if (choice == 2) {
						System.out.println("상세보기 할 영화의 번호를 입력하세요");
						index = scanner.nextInt();
						if (index < 0 || index > list.size() - 1) {
							System.out.println("잘못입력하셧습니다.");
						} else {
							MovieDTO movieDTO = moviecontroller.select(index);
							System.out.println("영화번호 : " + movieDTO.getId());
							System.out.println("영화제목 : " + movieDTO.getTitle());
							System.out.println("영화길이 : " + movieDTO.getLength());
						}
					}
				}
			}
		} // while

		scanner.close();

	}// end of main
}// end of calss
