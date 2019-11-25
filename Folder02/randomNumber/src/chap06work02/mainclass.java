package chap06work02;

import java.util.Scanner;

public class mainclass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// datas [사람수][정보];
		String datas[][] = new String[10][4];
		/*
		 * [0]:번호 [1]:이름 [2]:나이 [3]:주소
		 */
		int choice;
		int passIndex = 0;

		while (true) {
//			CRUD 라고하며
//			DAO Data Access Object			하기도 한다.
			System.out.println("1. 데이터의 추가(insert) ");
			System.out.println("2. 데이터의 삭제 (delete)");// 빈칸으로 만들어줘라.
			System.out.println("3. 데이터의 검색 (select)");
			System.out.println("4. 데이터의 수정 (update)");
			System.out.println("5. 데이터 모두 출력 ");

			System.out.println("메뉴 번호를 입력해주세요");

			choice = sc.nextInt();

			if (choice == 1) {// 데이터추가
				// 입력
				System.out.println("1. 데이터의 추가(insert) ");
				// 번호 이름 나이 주소

//				  for (int i = 0; i < datas.length; i++) { // if(datas[i][0]==null) { //
//					  if(datas[i][0]==null) { 
//						  passIndex=i;
//						  break;
//					  }
//				  }
				 
				System.out.println(passIndex);

				// for문을 돌리기보다는 가독성을 위해서
				System.out.print("번호");
				String number = sc.next();
				System.out.println("등록번호는 " + number + " 입니다.");

				System.out.print("이름 ");
				String name = sc.next();

				System.out.print("나이 ");
				String age = sc.next();
				sc.nextLine();
				System.out.print("주1소");
				String address = sc.nextLine();

				datas[passIndex][0] = number;
				datas[passIndex][1] = name;
				datas[passIndex][2] = age;
				datas[passIndex][3] = address;

				passIndex++;

			} else if (choice == 2) {// 데이터 삭제
				// 입력
				System.out.println("2. 데이터의 삭제 (delete)");// 빈칸으로 만들어줘라.
				// 인덱스 번호를 입력받아서 삭제하기.
				System.out.println("삭제할 인덱스 번호를 작성해주세요 ");
				int selectNumber = sc.nextInt();
				for (int i = 0; i < datas[selectNumber].length; i++) {
					datas[selectNumber][i] = " ";
				}
				System.out.println("해당 등록번호가 모두 삭제되었습니다.");

			} else if (choice == 3) {// 데이터의 검색
				// 입력
				System.out.println("3. 데이터의 검색 (select)");
				System.out.println("검색할 데이터를 입력해주세요 (인덱스번호로 검색합니다.)");
				sc.nextLine();
				String search1 = sc.nextLine();
				System.out.printf("번호\t 이름\t 나이\t 주소\t\n");
				for (int i = 0; i < datas.length; i++) {
					for (int j = 0; j < datas[i].length; j++) {
						System.out.printf("%d\t", datas[i][j]);
						if (datas[i][0].equals(search1)) {
							System.out.printf("%d\t", datas[i][j]);
						}
					}
				}
			} else if (choice == 4) {// 데이터의 수정
				// 입력 검색을 하고 수정한다. 인덱스번호를 검색후 그인덱스번호의 정보를 수정한다..
				System.out.println("4. 데이터의 수정 (update)");
				System.out.println("검색할 데이터를 입력해주세요 (인덱스번호로 검색합니다.)");
				String search1 = sc.nextLine();
				int passParam = 0;
				System.out.printf("번호\t 이름\t 나이\t 주소\t\n");
				for (int i = 0; i < datas.length; i++) {
					for (int j = 0; j < datas[0].length; j++) {
						if (datas[i][0].equals(search1)) {
							System.out.printf("%d\t", datas[i][j]);
							passParam = i;
						}
					}
				}

				// 해당라인 정보 전부 수정
				System.out.print("번호");
				String number = sc.next();
				System.out.println("등록번호는 " + number + " 입니다.");

				System.out.print("이름 ");
				String name = sc.next();

				System.out.print("나이 ");
				String age = sc.next();

				System.out.print("주소");
				String address = sc.next();

				datas[passParam][0] = number;
				datas[passParam][1] = name;
				datas[passParam][2] = age;
				datas[passParam][3] = address;

			} else if (choice == 5) {// 모든 데이터의 출력
				// 입력
				System.out.println("5. 데이터 모두 출력 ");
				System.out.printf("번호\t 이름\t 나이\t 주소\t\n");

				for (int i = 0; i < datas.length; i++) {
					if (datas[i][0] != null)
						System.out.printf("%s\t %s\t %s\t %s\t \n", datas[i][0], datas[i][1], datas[i][2], datas[i][3]);
				}

				System.out.println("널값 " + datas[0][0]);

			} else if (choice == 6) {

			} else {
				System.out.println("오류 ");

			}

			choice = 0;
		} // end while

	}// end main

}// end class
