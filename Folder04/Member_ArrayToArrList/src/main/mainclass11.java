package main;

import java.util.ArrayList;

import dto.MemberDto;

public class mainclass11 {

	public static void main(String[] args) {
		ArrayList<String> wawa = new ArrayList<String>();
		wawa.add("11");
		wawa.add("22");
		wawa.add("33");
		
		ArrayList<MemberDto> memWawa = new ArrayList<MemberDto>();
		MemberDto wawa1 = new MemberDto();
		wawa1.setNumber(11);
		wawa1.setAge(23);
		wawa1.setName("김영희");
		wawa1.setAddress("수원시");
		
		MemberDto wawa2 = new MemberDto();
		wawa2.setNumber(11);
		wawa2.setAge(33);
		wawa2.setName("김철수");
		wawa2.setAddress("부산시");
		
		memWawa.add(wawa1);
		memWawa.add(wawa2);
		
		for (int i = 0; i < memWawa.size(); i++) {
			MemberDto d = memWawa.get(i);
			System.out.println(d.toString());
		}
		
System.out.println("hello");		
		
		

	}

}
