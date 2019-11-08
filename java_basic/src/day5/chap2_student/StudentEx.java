package day5.chap2_student;
//map안에 map안에 어레이리스트

//map은 키와 벨류가 모두 객체이다. 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//map 안에 map 안에 어레이리스트
public class StudentEx {
	public static void main(String[] args) {
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
				StudentDTO s = new StudentDTO();
				// 각 반을 담당할 hashMap
				HashMap<Integer, ArrayList<StudentDTO>> yearMap = new HashMap<Integer, ArrayList<StudentDTO>>();

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
				// 람다식 입력
//				computeIfAbsent 는 키값이있는지없는지 봐 없으면 어레이리스트를 만들어 
				yearMap.computeIfAbsent(s.getRoom(), k -> new ArrayList<StudentDTO>()).add(s);

//				아래내용 줄인것.
//				if(yearMap.keySet().contains(s.getRoom())) {
//					yearMap.get(s.getRoom()).add(s);
//				}else {
//					ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
//					list.add(s);
//					yearMap.put(s.getRoom(), list);
//				}

				ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
				list.add(s);
				if (yearMap.containsKey(s.getRoom())) {
					yearMap.get(s.getRoom()).add(s);
				} else {
					yearMap.put(s.getRoom(), list);
				}
				if (schoolMap.containsKey(s.getYear())) {
					schoolMap.get(s.getYear()).putAll(yearMap);
				} else {
					schoolMap.put(s.getYear(), yearMap);
				}
			}
		}
		for (int i : schoolMap.keySet()) {
			for (int j : schoolMap.keySet()) {
				for (StudentDTO s : schoolMap.get(j).get(j)) {
					System.out.println(s);
				}
			}

		}
	}

}// end of class
