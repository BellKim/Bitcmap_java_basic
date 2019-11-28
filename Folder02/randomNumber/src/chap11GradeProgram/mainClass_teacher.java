package chap11GradeProgram;

import java.util.Arrays;
import java.util.Scanner;

public class mainClass_teacher {
	/*
	 * 함수로 제작하기. String student[][]; 불러와서 이 배열에 저장하기.
	 * 
	 * 1. 학생정보 추가 (이름, 나이, 영어점수, 수학점수) 2. 학생정보 삭제 3. 학생정보 검색 4. 학생정보 수정 5. 학생성적
	 * 조회(1명에 대한 정보만 조회하기) 총점 6. 학생성적 총점 7. 학생성적 평균 8. 학생성적순 출력(총점에 대한 출력)
	 * 
	 * 어느 작업을 하시겠습니까 검색,수정,삭제 는 시간남으면 파일로 저장하기.
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 변수선언부
//		String student[][] = new String[10][4];
		String student[][] = {
				{"홍길동","24","100","90"},
				{"","","",""},
			{"이이이","22","22","33"},
			{"삼삼삼","33","33","22"}
		};
			

//		for (String[] row : student)
//			Arrays.fill(row, "");// 2중배열 전체에 - 로 체우기

		int choice;

		while (true) {
			startInfo();// 초기메뉴를 보여준다.
			choice = sc.nextInt();
			if (choice == 1) { // 1. 학생정보 추가(이름, 나이, 영어점수, 수학점수)
				insert(sc, student);

			} else if (choice == 2) { // 2. 학생정보 삭제
				delete(student);

			} else if (choice == 3) { // 3. 학생정보 검색
				select(student);
			} else if (choice == 4) { // 4. 학생정보 수정
				modify(student);
			} else if (choice == 5) { // 5. 학생성적 조회(1명에 대한 정보만 조회하기) 1명의 총점
				student_sum_avg(student);
			} else if (choice == 6) { // 6. 학생성적 총점
				student_all_sum(student);
			} else if (choice == 7) { // 7. 학생성적 평균
				student_all_avg(student);

			} else if (choice == 8) { // 8. 학생성적순 출력(총점에 대한 출력)
				student_sort(student);

			} else if (choice == 9 || choice == 0) {
				System.out.println("프로그램을 종료합니다. ");
				break;
			} // end if

		} // end while()
		sc.close();

	}// end main

	static void student_sort(String student[][]) {
//		String studentSort[][] = student;//로 선언하면 원본데이터가 손상되는것이다.
		
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] != null && !student[i][0].equals("")) {
				count++;
			}
		}	//데이터의 갯수를 카운트한다. (10개중에서 null이 아니면서 삭제된 데이터만 제외시킴)
		System.out.println("count  = "+count);
		int val = 0;
		String studentSort[][] = new String[count][4];
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] != null && !student[i][0].equals("")) {
				studentSort[val][0] = student[i][0];
				studentSort[val][1] = student[i][1];
				studentSort[val][2] = student[i][2];
				studentSort[val][3] = student[i][3];
				val++;
			}
		}
		System.out.println("studentSort 시작");
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort.length; j++) {
				System.out.print(studentSort[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("studentSort 끝\n");
		// 내림정렬
		int sum[] = new int[studentSort.length];
		for (int i = 0; i < studentSort.length-1; i++) {
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][2]);
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][3]);
		}
		
		for (int i = 0; i < sum.length; i++) {
			System.out.println("sum["+i+"] = " + sum[i]);
		}
		String temp[];
		for (int i = 0; i < sum.length-1; i++) {
			for (int j = 0; j < sum.length; j++) {
				if(sum[i]<sum[j]) {
					temp = studentSort[i];
					studentSort[i] = studentSort[j];
					studentSort[j] = temp;
				}
			}
		}
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort.length; j++) {
				System.out.print(studentSort[i][j] + " ");
			}
			System.out.println();
		}
		

	}// end student_sort

	private static void student_all_avg(String[][] student) {
		// 학생수가 한명도 없을 경우,

		// 각 학생의 합계에 대한 평균
		// 학생? 몇명?
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] != null && student[i][0].equals("")) {
				count++;
			}
		}
		System.out.println("count : " + count);

		if (count == 0) {
			System.out.println("학생이 한명도 없습니다. ");
			return;// 메소드 내에서 아래내용을 실행하게 하지 않도록함.
		}

		int sum[] = new int[count];
		int j = 0;
		for (int i = 0; i < sum.length; i++) {
			if (student[i][0] != null && !student[i][0].equals("")) {
				sum[j] = sum[j] + Integer.parseInt(student[i][2]);
				sum[j] = sum[j] + Integer.parseInt(student[i][3]);
				j++;
			}

		} // end for
		int allSum = 0;
		for (int k = 0; k < sum.length; k++) {
			allSum = allSum + sum[k];
		}
		double allAVG = (double) allSum / count;
		System.out.println("학생들의 총점에 대한 평균 : " + allAVG);

	}// end student_all_avg

	private static void student_all_sum(String[][] student) {
		int sum = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] != null && !student[i][0].equals("")) {
				// && 문 앞뒤로 조건순서가 달라진다면, nullpointerException이 생성된다.
				sum = sum + Integer.parseInt(student[i][2]);
				sum = sum + Integer.parseInt(student[i][3]);
			}
		}

		System.out.println("전체학생의 총점 : " + sum);

	}// end student_all_sum

	private static void student_sum_avg(String[][] student) {
		Scanner sc = new Scanner(System.in);
//		검색
		System.out.println("검색할  학생의 이름을 입력 =");
		String name = sc.next();
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals((student)[i][0])) {
				findIndex = i;
				break;
			}
		}
		// 삭제
		if (findIndex == -1) {
			System.out.println("학생 데이터를 찾을 수 없습니다. ");
		} else {
			System.out.println("이름 : " + student[findIndex][0]);

			int eng = Integer.parseInt(student[findIndex][2]);
			int math = Integer.parseInt(student[findIndex][3]);
			int sum = eng + math;
			double avg = (double) sum / 2;
			System.out.println("총점 : " + sum);
			System.out.println("평균 : " + avg);
		}
	}// end student_sum_avg

	private static void modify(String[][] student) {
		Scanner sc = new Scanner(System.in);
//		검색
		System.out.println("검색할  학생의 이름을 입력 =");
		String name = sc.next();
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals((student)[i][0])) {
				findIndex = i;
				break;
			}
		}

		// 삭제
		if (findIndex == -1) {
			System.out.println("학생 데이터를 찾을 수 없습니다. ");
		} else {
			System.out.println("학생데이터를 찾았습니다.");
			System.out.println("수정할 점수를 입력해 주세요");

			System.out.println("나이를 입력하세요");
			String age = sc.next();
			System.out.println("영어점수를 입력하세요");
			String eng = sc.next();
			System.out.println("수학점수를 입력하세요");
			String math = sc.next();
//			// 이름, 나이, 영어점수, 수학점수
			student[findIndex][0] = name;
			student[findIndex][1] = age;
			student[findIndex][2] = eng;
			student[findIndex][3] = math;
		}
	}

	private static void select(String[][] student) {
		Scanner sc = new Scanner(System.in);
//		검색
		System.out.println("검색할  학생의 이름을 입력 =");
		String name = sc.next();
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals((student)[i][0])) {
				findIndex = i;
				break;
			}
		}

		// 삭제
		if (findIndex == -1) {
			System.out.println("학생 데이터를 찾을 수 없습니다. ");
		} else {
			System.out.println("학생데이터를 찾았습니다.");
			System.out.println("이름 : " + student[findIndex][0] + "나이 : " + student[findIndex][1] + "수학 : "
					+ student[findIndex][2] + "영어 : " + student[findIndex][3]);
		}
	}

	private static void delete(String[][] student) {
		Scanner sc = new Scanner(System.in);
//		검색
		System.out.println("삭제할 학생의 이름을 입력 =");
		String name = sc.next();
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals((student)[i][0])) {
				findIndex = i;
				break;
			}
		}

		// 삭제
		if (findIndex == -1) {
			System.out.println("학생 데이터를 찾을 수 없습니다. ");
		} else {
			for (int i = 0; i < student[0].length; i++) {
				student[findIndex][i] = "";
			}
			System.out.println("학생데이터를 삭제하였습니다.");
		}

	}// end delete

	static void insert(Scanner sc, String[][] student) {

		// 입력된 노드 다음에 자료가 입력되도록한다.
		// next node == null 을 찾는다.
		int nextNode = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] == null) {
				nextNode = i;
				break;
			}
		}
//		System.out.println("nextNode = " + nextNode);

		System.out.println("이름을 입력하세요");
		String name = sc.next();
		// student[nextNode][0] = sc.next(); //로도 치환가능.

		System.out.println("나이를 입력하세요");
		String age = sc.next();
		System.out.println("영어점수를 입력하세요");
		String eng = sc.next();
		System.out.println("수학점수를 입력하세요");
		String math = sc.next();
//		// 이름, 나이, 영어점수, 수학점수
		student[nextNode][0] = name;
		student[nextNode][1] = age;
		student[nextNode][2] = eng;
		student[nextNode][3] = math;
//
//		indexcount++;
	}// end addStudentData

	static void startInfo() {
		System.out.println("1. 학생정보 추가(이름, 나이, 영어점수, 수학점수)");
		System.out.println("2. 학생정보 삭제");
		System.out.println("3. 학생정보 검색");
		System.out.println("4. 학생정보 수정");
		System.out.println("5. 학생성적 조회(1명에 대한 정보만 조회하기) 총점");
		System.out.println("6. 학생성적 총점");
		System.out.println("7. 학생성적 평균	");
		System.out.println("8. 학생성적순 출력(총점에 대한 출력)");
		System.out.println("0. 프로그램 종료.");
	}

}// end class
