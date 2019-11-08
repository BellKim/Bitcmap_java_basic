package day05.chap2_student_manage;
//map안에 map안에 어레이리스트

//map은 키와 벨류가 모두 객체이다. 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jdk.internal.dynalink.beans.StaticClass;

//map 안에 map 안에 어레이리스트
public class StudentEx {
	public static void main(String[] args) {
//		모든학년을 담당하는HASHMAP 안에
//		모든 반을 담당하는 HASHMAP안에
//		각반의 학생을 담고있는 ArrayList

		// 각반 학생을 담당할 list
//		ArrayList<StudentDTO> list = new ArrayList<>();

		// 각 학년을 담당할 hash map
		HashMap<Integer, HashMap<Integer, ArrayList<StudentDTO>>> schoolMap = new HashMap<Integer, HashMap<Integer, ArrayList<StudentDTO>>>();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("=====무슨 고등학교 관리 프로그램.=======");
			System.out.println("1. 입력  2. 출력 3. 종료 \n > ");
			int choice = scanner.nextInt();
			if (choice == 3) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			} else if (choice == 1) {
				insert(scanner, schoolMap);
//				StudentDTO s = new StudentDTO();
//				// 각 반을 담당할 hashMap
//				System.out.print("학년: ");
//				s.setYear(scanner.nextInt());
//				System.out.print("반: ");
//				s.setRoom(scanner.nextInt());
//				System.out.print("번호: ");
//				s.setNumber(scanner.nextInt());
//				System.out.print("이름: ");
//				scanner.nextLine();
//				s.setName(scanner.nextLine());
//				System.out.print("국어점수: ");
//				s.setKor(scanner.nextInt());
//				System.out.print("영어점수: ");
//				s.setEng(scanner.nextInt());
//				System.out.print("수학점수: ");
//				s.setMath(scanner.nextInt());
//				System.out.println(s);
//
//				schoolMap.computeIfAbsent(s.getYear(), k -> new HashMap<Integer, ArrayList<StudentDTO>>())
//						.computeIfAbsent(s.getRoom(), j -> new ArrayList<StudentDTO>()).add(s);
//				3가지 경우의 변화
//				1.학년,반 모두 있을떄-> 곶당 해당 arrayList에 s 를 추가한다.
//				2. 학년은 반에있고 반은 없을때 -> 반은 담당할 ArrayList를 만들고 새로 만들어진 arraylist에 s 를 추가한다.
//				3. 학년 반 모두 없을때 -.args 그 학년을 담당할 hashmap을 만들고 그 안에 반을 담당할 arrayList를 만들고 s 를 추가한다.
			} else if (choice == 2) {
				if (schoolMap.size() == 0) {
					System.out.println("입력된 학생이 없습니다.");
				} else {// 입력된학생이 있을경우
					System.out.println("학년 : ");
					int year = scanner.nextInt();
					while (!schoolMap.containsKey(year)) {
						System.out.println("해당 학년 기록이 없습니다. ");
						System.out.println("학년 : ");
						year = scanner.nextInt();
					}
					System.out.println("반 : ");
					int room = scanner.nextInt();
					while (!schoolMap.get(year).containsKey(room)) {
						System.out.println("해당 반 기록이 없습니다.");
						System.out.println("반 : ");
						room = scanner.nextInt();
					}
					for (StudentDTO s : schoolMap.get(year).get(room)) {
						System.out.println(s);
					}
				}
			}

		}
		
		

	}
	private static void insert(Scanner scanner, HashMap<Integer, HashMap<Integer, ArrayList<StudentDTO>>> schoolMap) {
		StudentDTO s = new StudentDTO();
		// 각 반을 담당할 hashMap
		System.out.print("학년: ");
		s.setYear(scanner.nextInt());
		System.out.print("반: ");
		s.setRoom(scanner.nextInt());
		System.out.print("번호: ");
		s.setNumber(scanner.nextInt());
		System.out.print("이름: ");
		scanner.nextLine();
		s.setName(scanner.nextLine());
		System.out.print("국어점수: ");
		s.setKor(scanner.nextInt());
		System.out.print("영어점수: ");
		s.setEng(scanner.nextInt());
		System.out.print("수학점수: ");
		s.setMath(scanner.nextInt());
		System.out.println(s);

		schoolMap.computeIfAbsent(s.getYear(), k -> new HashMap<Integer, ArrayList<StudentDTO>>())
				.computeIfAbsent(s.getRoom(), j -> new ArrayList<StudentDTO>()).add(s);

	}

}// end of class
