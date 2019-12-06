package dao;

import java.util.Scanner;

import dto.MemberDto;

public class MemberDao {
	
	Scanner sc = new Scanner(System.in);

	private MemberDto member[];
	private int MEMBER_NUM = 10;
	
	private int count;
	
	public MemberDao() {
		member = new MemberDto[MEMBER_NUM];
		
		member[0] = new MemberDto(1001, "홍길동", 24, "서울시");
		member[1] = new MemberDto(1002, "일지매", 22, "부산시");
		member[2] = new MemberDto(1003, "정수동", 25, "광주시");
		
		count = 3;
	}
	
	public void insert() {
		// 입력 		
		System.out.print("번호:");
		int number = sc.nextInt();
		
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("나이:");
		int age = sc.nextInt();
		
		System.out.print("주소:");
		String address = sc.next();
		
		MemberDto dto = new MemberDto(number, name, age, address);
		member[count] = dto;
		
		count++;		
	}
	
	public void delete() {
		int findIndex;
		
		System.out.print("삭제할 이름:");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다");
		}else {
			member[findIndex].setName("");
			member[findIndex].setNumber(0);
			member[findIndex].setAge(0);
			member[findIndex].setAddress("");
			
			System.out.println("회원 정보를 삭제하였습니다");
		}		
	}
	
	public void select() {
		int findIndex;
		
		System.out.print("검색할 이름:");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다");
		}else {
			System.out.println("찾은 회원 정보는");			
			System.out.println(member[findIndex].toString());			
			System.out.println("입니다");
		}
	}
	
	public int search(String name) {
		int indexNum = -1;
		/*
		for (int i = 0; i < member.length; i++) {
			MemberDto dto = member[i];
			if(dto != null && !dto.getName().equals("")) {
				if(name.equals(dto.getName())) {
					indexNum = i;
					break;
				}
			}
		}*/
		
		int i = 0;
		for (MemberDto dto : member) {
			if(dto != null && !dto.getName().equals("")) {
				if(name.equals(dto.getName())) {
					indexNum = i;
					break;
				}
			}
			i++;
		}
		return indexNum;
	}
	
	public void update() {
		int findIndex;
		
		System.out.print("수정할 이름:");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다");
		}else {
			System.out.print("수정할 주소를 입력:");
			String address = sc.next();
			
			member[findIndex].setAddress(address);
			System.out.println("수정되었습니다");
		}
	}
	
	public void allprint() {		
		for (int i = 0; i < member.length; i++) {
			MemberDto dto = member[i];
			if(dto != null && !dto.getName().equals("") ) {
				System.out.println(dto.toString());
			}
		}		
	}
	
}




