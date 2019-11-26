package chap11GradeProgram;



import java.util.Arrays;
import java.util.Scanner;

public class mainClass {
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
		String student[][] = new String[10][4];
		
		for (String[] row : student)
			Arrays.fill(row, "-");// 2중배열 전체에 - 로 체우기

		inputBaseData(student);

		int choice;

		while (true) {
			startInfo();// 초기메뉴를 보여준다.
			choice = sc.nextInt();
			if (choice == 1) { // 1. 학생정보 추가(이름, 나이, 영어점수, 수학점수)
				addStudentData(sc, student);

			} else if (choice == 2) { // 2. 학생정보 삭제
				showStudentInfoAll(student);
				deleteStudentData(sc, student);
				showStudentInfoAll(student);
				
			} else if (choice == 3) { // 3. 학생정보 검색
				searchStudentData(sc, student);
			} else if (choice == 4) { // 4. 학생정보 수정
				modifyStudendData(sc, student);
			} else if (choice == 5) { // 5. 학생성적 조회(1명에 대한 정보만 조회하기) 1명의 총점
				SelectOneStudentData(sc, student);
			} else if (choice == 6) { // 6. 학생성적 총점
				String [][] totalScore = StudentTotalScore(sc, student);
				showStudentInfoAll(totalScore);
				
			} else if (choice == 7) { // 7. 학생성적 평균
				String [][] totalAvgScore = studentAvrScore(sc, StudentTotalScore(sc, student));
				showStudentInfoAll(totalAvgScore);
				
			} else if (choice == 8) { // 8. 학생성적순 출력(총점에 대한 출력)
//				showStudentInfoAll(student);//그냥평균출력
				String [][] test=StudentRank(studentAvrScore(sc, StudentTotalScore(sc, student)));
				showStudentInfoAll(test);
			} else if (choice == 9 || choice == 0) {
				System.out.println("프로그램을 종료합니다. ");
				break;
			} // end if

		} // end while()
		sc.close();

	}// end main

	private static String[][] StudentRank(String[][] studentTotalScore) {
		String tempName, tempAvg;
		for (int i = 0; i < studentTotalScore.length; i++) {
			for (int j = 0; j < studentTotalScore.length; j++) {
				if (studentTotalScore[i][0] == null) {
					break;
				}else if(studentTotalScore[j][0] == null) {
					break;
				}else if (Integer.parseInt(studentTotalScore[i][1]) > Integer.parseInt(studentTotalScore[j][1])) {
					// 평균 비교를 해서 내림차순으로. 0행평균, 1행평균을 비교한것.

					tempName = studentTotalScore[i][0];
					tempAvg = studentTotalScore[i][1];

					studentTotalScore[i][0] = studentTotalScore[j][0];
					studentTotalScore[i][1] = studentTotalScore[j][1];

					studentTotalScore[j][0] = tempName;
					studentTotalScore[j][1] = tempAvg;
				} // 높은순에서 낮은순으로 정렬됨.

			}
		}
		
//		for(String[] a : studentTotalScore) {
//			System.out.println("studentRank: "+a[0] + "  " + a[1]);
//		}
		
		return studentTotalScore;
	}// end StudentRank Top to bottom

	private static String[][] studentAvrScore(Scanner sc, String[][] studentTotalScore) {

		String[][] totalAvgScore = new String[studentTotalScore.length][2];

		for (int i = 0; i < studentTotalScore.length; i++) {
			if (studentTotalScore[i][0] == null) {
				break;
			}
			totalAvgScore[i][0] = studentTotalScore[i][0];
			totalAvgScore[i][1] = Integer.toString(((Integer.parseInt(studentTotalScore[i][1]))/2));
		}
//		for (String[] a : totalAvgScore)
//			System.out.println(a[0] + " " + a[1]);

		return totalAvgScore;

	}

	private static String[][] StudentTotalScore(Scanner sc, String[][] student) {// 7. 학생성적 총점

		String[][] totalScore = new String[student.length][2];
		
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] == "-") {
				for (String[] a : totalScore)
//					System.out.println(a[0] + " " + a[1]);
				return totalScore;
			}
			totalScore[i][0] = student[i][0];
			totalScore[i][1] = Integer.toString((Integer.parseInt(student[i][2]) + Integer.parseInt(student[i][3])));
		}
		
//		for (String[] a : totalScore)
//			System.out.println(a[0] + " " + a[1]);
//		
//		System.out.println(totalScore[0][1]);
		
	

		return totalScore;
	}

	private static void SelectOneStudentData(Scanner sc, String[][] student) {

		showStudentInfoAll(student);

		System.out.println("총점을 열람하고싶은 학생을 선택하세요.");
		String searchData = sc.next();
		System.out.printf("이름\t 총점\t \n");
		for (int i = 0; i < student.length; i++) {
			if (student[i][0].equals(searchData)) {
				System.out.printf("%s\t %d \n\n", student[i][0],
						(Integer.parseInt(student[i][2]) + Integer.parseInt(student[i][3])));
			}
		}

	}// end SelectOneStudentData

	private static void modifyStudendData(Scanner sc, String[][] student) {

		showStudentInfoAll(student);

		System.out.println("수정할 학생의 이름을 입력해주세요");
		String inputData = sc.next();
		int indexCount=0;
		for (indexCount = 0; indexCount < student.length; indexCount++) {
			if (student[indexCount][0].equals(inputData)) {
				break;
			}
		}

		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("나이를 입력하세요");
		String age = sc.next();
		System.out.println("영어점수를 입력하세요");
		String eng = sc.next();
		System.out.println("수학점수를 입력하세요");
		String math = sc.next();

		// 이름, 나이, 영어점수, 수학점수
		student[indexCount][0] = name;
		student[indexCount][1] = age;
		student[indexCount][2] = eng;
		student[indexCount][3] = math;



	}// end modifyStudendData

	private static void searchStudentData(Scanner sc, String[][] student) {
		System.out.println("검색하고자 하는 학생의 이름을 입력하세요");
		String searchData = sc.next();
		System.out.printf("이름\t 나이\t 영어\t 수학\t \n");
		for (int i = 0; i < student.length; i++) {
			if (student[i][0].equals(searchData)) {
				System.out.printf("%s\t %s\t %s\t %s\t \n\n", student[i][0], student[i][1], student[i][2], student[i][3]);
			}
		}
	}// end searchData

	private static void deleteStudentData(Scanner sc, String[][] student) {

		String searchData = sc.next();
		for (int i = 0; i < student.length; i++) {
			if (student[i][0].equals(searchData)) {
				student[i][0] = "0";
				student[i][1] = "0";
				student[i][2] = "0";
				student[i][3] = "0";
			}
		}

	}// end delete

	private static void showStudentInfoAll(String[][] inputarr) {
		for (int i = 0; i < inputarr.length; i++) {
			for (int j = 0; j < inputarr[i].length; j++) {
				if(inputarr[i][j] != null)
				System.out.print(inputarr[i][j] + " ");
			}
			if(inputarr[i][0] != null)
			System.out.println();
		}
		
		
		
//		for (String[] n : inputarr) {
//			System.out.println(n[0] + " " + n[1] + " " + n[2] + " " + n[3]);
//		}
	}// end showStudentInfoAll

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

	static void inputBaseData(String[][] student) {
		student[0][0] = "김철수";
		student[0][1] = "19";
		student[0][2] = "70";
		student[0][3] = "70";

		student[1][0] = "김영희";
		student[1][1] = "22";
		student[1][2] = "80";
		student[1][3] = "80";

		student[2][0] = "김봉두";
		student[2][1] = "21";
		student[2][2] = "90";
		student[2][3] = "90";
	}// end inputBaseData

	static int checkLastData(Scanner sc, String[][] student) {
		int indexcount;
		// 빈 배열 체크한다. "-" 로 빈칸초기화가 되어있으므로, - 가 있는 지확인
		for (indexcount = 0; indexcount < student.length; indexcount++) {
			if (student[indexcount][0] == "-") {
				break;
			}
		}
		return indexcount;

	}// end checkLastData

	static void addStudentData(Scanner sc, String[][] student) {
		int indexcount = checkLastData(sc, student);
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("나이를 입력하세요");
		String age = sc.next();
		System.out.println("영어점수를 입력하세요");
		String eng = sc.next();
		System.out.println("수학점수를 입력하세요");
		String math = sc.next();

		// 이름, 나이, 영어점수, 수학점수
		student[indexcount][0] = name;
		student[indexcount][1] = age;
		student[indexcount][2] = eng;
		student[indexcount][3] = math;

		indexcount++;
	}// end addStudentData

}// end class
