package DAO;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberDTO;

public class ManageDAO {

	ArrayList<MemberDTO> list;

	public ManageDAO() {
		list = new ArrayList<MemberDTO>();
//		baseData();
	}

	public void baseData() {
		MemberDTO dto1 = new MemberDTO("김영희", 30, 40, 50, 60, 150, 50,0);
		MemberDTO dto2 = new MemberDTO("김철수", 60, 70, 80, 90, 240, 80,0);
		MemberDTO dto3 = new MemberDTO("김미남", 100, 70, 80, 100, 250, 83,0);
		MemberDTO dto4 = new MemberDTO("김철민", 70, 90, 95, 100, 285, 95,0);

		list.add(dto2);
		list.add(dto3);
		list.add(dto4);
		list.add(dto1);
		System.out.println("사이즈 : " + list.size());

		setRank();

	}// end base data

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
		System.out.println("점수 총점");

		int sum = listElementSum(kor, eng, math);

		System.out.println("점수 평균");
		int avg = listElementAvg(sum);

		System.out.println("Rank설정");

		int rank = 1;
		

		MemberDTO dto = new MemberDTO(name, age, kor, eng, math, sum, avg, rank);

		list.add(dto);
		setRank();
	}

	public void setRank() {
		int rank = 1;
		int rankarr[] = new int[list.size()];

			
			for (int i = 0; i < rankarr.length; i++) {
				rankarr[i]=1;
				for (int j = 0; j < list.size(); j++) {
						if(list.get(i).getAvg() < list.get(j).getAvg()){
							rankarr[i]+=rank;			
						}
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setRank(rankarr[i]);
			}
			
//			for(int i : rankarr) {
//				System.out.println("rankarr : "+ i);
//			}
			
			
			
//			int[] grade = new int[]{47, 98, 56, 33, 85}; //성적 
//			int[] rank1 = new int[]{1, 1, 1, 1, 1}; //등수 
//			//rank 구하기 
//			for(int i=0 ; i<rank1.length ; i++) {
//				for(int j=0 ; j<grade.length; j++) {
//					if(grade[i] < grade[j]) {
//						rank1[i]++; 
//					}
//				}
//			}

			
		
		



		
	}// end setRank

	public int addTotal(int receiveIndex) {

		MemberDTO dto = list.get(receiveIndex);
		int total = dto.getMath() + dto.getKor() + dto.getEng();
		return total;
	}

	public int listElementSum(int kor, int eng, int math) {
		return kor + eng + math;
	}

	public int listElementAvg(int sum) {
		return sum / 3;
	}

	public int lastCheck() {
		// 초기에 4개의 데이터가 입력되었다면, 4번쨰 데이터는 0123 총 3번째값이다.
		// 그러므로 입력될 데이터를 찾는것이라면, 마지막배열번호=어레이리스트의 갯수가 됨.
//		System.out.println(list.size());
		return list.size();
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
		String a = sc.next();
		return a;
	}

	public int scanInt() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}

	public void select() {
		int findindex = -1;

		findindex = findindex();

		System.out.println(list.get(findindex).toString());
		System.out.println("검색결과 끝. ");
	}

	public int findindex() {
		int findindex = -1;
		System.out.println("찾고자하는 학생의 이름을 입력해주세요");
		String intputdata = scanStr();
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);

			if (dto.getName().equals(intputdata)) {
				return i;
			}
		}
		System.out.println("결과없음.");
		return findindex;
	}// end select

	public void delete() {
		int findindex = -1;
		findindex = findindex();
		list.remove(findindex);
		if (findindex == -1) {
			System.out.println("삭제안됨.");
		} else {
			System.out.println("삭제 끝. ");
		}
	}// end delete

	public void update() {
		int findindex = -1;
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

		if (findindex == -1) {
			System.out.println("업데이트안됨..");
		} else {
			System.out.println("업데이트 완료 ");
		}

	}

	public void studentTotal() {
		System.out.println("이름 "+ "총점" );
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println( list.get(i).getName()+ " " + list.get(i).getTotal());
		}
		
	}

	public void studentAvg() {
		System.out.println("이름 "+ "총점" );
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println( list.get(i).getName()+ " " + list.get(i).getAvg());
		}
		
	}

	public void TopToBottom() {
		int top = 0;
		int bottom = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getRank()==1) {
				top=i;
			}else if(list.get(i).getRank()==(list.size())){
				bottom = i;
			}
			
		}
		System.out.println("list.size-1 = " + (list.size()-1));
		System.out.println("1등은 "+list.get(top).getName() + "꼴등은 " + list.get(top).getName() +"입니다." );
		
	}

}// end class
