package DAO;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberDTO;

public class ManageDAO {

	ArrayList<MemberDTO> list;

	public ManageDAO() {
		list = new ArrayList<MemberDTO>();
		baseData();
	}

	public void baseData() {
		MemberDTO dto1 = new MemberDTO("김영희", 30, 40, 50, 60);
		dto1.setName("정홍주");
		
		dto1.setTotal(dto1.getEng()+dto1.getKor()+dto1.set())
		list.add(new)
		MemberDTO dto2 = new MemberDTO("김철수", 60, 70, 80, 90);
		MemberDTO dto3 = new MemberDTO("김미남", 100, 70, 80, 100);
		MemberDTO dto4 = new MemberDTO("김철민", 70, 90, 95, 100);
		list.add(new MemberDTO("김철민", 70, 90, 95, 100));
		list.add(dto2);
		list.add(dto3);
		list.add(dto4);
		
	}

	public void insert() {
		
		System.out.println("이름입력");
		String name = scanStr();
		System.out.println("나이");
		int age = scanInt();
		System.out.println("국어점수");
		int kor = scanInt();
		System.out.println("영어점수");
		int eng = scanInt();
		System.out.println("수학");
		int math = scanInt();
		
		MemberDTO dto = new MemberDTO(name, age, kor, eng, math,total, avg);
		list.add(dto);
	}

	public void showAll() {
		System.out.println("쇼올");
		
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto.toString());
		}
	}
	
	public String scanStr() {
		Scanner sc = new Scanner(System.in);
			String a= sc.next();
		return a;
	}
	public int scanInt() {
		Scanner sc = new Scanner(System.in);
			int a= sc.nextInt();
		return a;
	}
	
	public void select() {
		 int findindex= -1;
		 
		findindex = findindex();
		
		System.out.println(list.get(findindex).toString());
		System.out.println("검색결과 끝. ");
	}

	public int findindex() {
		int findindex=-1;
		System.out.println("찾고자하는 학생의 이름을 입력해주세요");
		String intputdata = scanStr();
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			
			if(dto.getName().equals(intputdata)) {
				return i;
			}
		}
		System.out.println("결과없음.");
		return findindex;
	}//end select

	public void delete() {
		 int findindex= -1;
		findindex = findindex();
		list.remove(findindex);
		if(findindex == -1) {
			System.out.println("삭제안됨.");
		}else {
			System.out.println("삭제 끝. ");
		}
	}//end delete

	public void update() {
		 int findindex= -1;
		findindex = findindex();
		
		MemberDTO dto = list.get(findindex);
		System.out.println("수정할 나이");
		dto.setAge(scanInt());
		System.out.println("수정할 수학점수");
		dto.setMath(scanInt());
		System.out.println("수정할 영어점수");
		dto.setEng(scanInt());
		System.out.println("수정할 국어점수");
		dto.setKor(scanInt());
		
		
		if(findindex == -1) {
			System.out.println("업데이트안됨..");
		}else {
			System.out.println("업데이트 완료 ");
		}
		
	}

}// end class
