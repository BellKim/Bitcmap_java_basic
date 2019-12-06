package main;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		ArrayList<String> strlist = new ArrayList<String>();
		strlist.add("가");
		strlist.add("나");
		strlist.add("다");
		strlist.add("라");
		strlist.add("마");
		System.out.println(strlist.indexOf("라"));
		System.out.println(strlist.get(1));
		
		
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		
		MemberDTO memdto = new MemberDTO();
		memdto.setNumber(001);
		memdto.setName("철수");
		
		MemberDTO memdto1 = new MemberDTO();
		memdto1.setNumber(002);
		memdto1.setName("영희");
		
		MemberDTO memdto2 = new MemberDTO();
		memdto2.setNumber(003);
		memdto2.setName("백구");
		
		MemberDTO memdto3 = new MemberDTO();
		memdto3.setNumber(004);
		memdto3.setName("철구");
		
		
		memlist.add(memdto);
		memlist.add(memdto1);
		memlist.add(memdto2);
		memlist.add(memdto3);
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("찾을번호입력");
//		int inputnum = sc.nextInt();
//		
//
//		
//		for (int j = 0; j < args.length; j++) {
//			MemberDTO d = memlist.get(j);
//			System.out.println(d.toString());
//			
//			
//		}
		
		MemberDTO dto = new MemberDTO(1011,"성춘향");
		MemberDTO dto1 = new MemberDTO(1011,"김영숙");
		MemberDTO dto2 = new MemberDTO(1012,"김영숙");
		memlist.add(dto);
		memlist.add(dto1);
		memlist.add(dto2);
		
		//삭제
//		memlist.remove(1);
		
		for(MemberDTO n : memlist) {
			System.out.println(n);
		}
		
		//검색
		String findname = "철구";
		int indexNumber = -1;
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO mem = memlist.get(i);
			if(mem.getName().equals(findname)) {
				indexNumber = i;
				break;
			}
		}
		System.out.println("찾은데이터 : " + memlist.get(indexNumber).toString());
		
		
/*		
		동명이인처리방식 : 
			다수의데이터
			갯수를카운터
			배열동적
			찾아서 데이터에넣어준다.
	*/		
		ArrayList<MemberDTO> findDatalList = new ArrayList<MemberDTO>();
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO d = memlist.get(i);
			if(d.getName().equals("김영숙")) {
				findDatalList.add(d);
			}
		}
		
		for (int i = 0; i < findDatalList.size(); i++) {
			MemberDTO d = findDatalList.get(i);
			System.out.println("동명이인 찾은 데이터 : "+ d.toString() );
		}
		
		
		
		//수정
		MemberDTO updateDTO = new MemberDTO(1010, "김단단");
		memlist.set(2, updateDTO);
		
		
		
		
		
		
		
		
		

		

	}//end of main

}//end of class
