package DAO;

import java.util.Scanner;

import DTO.MemberDTO;
import DTO.fileClass;

public class MemberDAO{
	
	MemberDTO memberDTO[] = new MemberDTO[10];
	
	public MemberDAO() {
		for (int i = 0; i < memberDTO.length; i++) {
			memberDTO[i] = new MemberDTO();		
		}
	}
	
	public void init() {
		setBaseData();//초기데이터 넣는곳.
	}
	
	public void loop() {
		int choice = 0;
		while(true) {
			firstMenu();
			choice = scannerNum();
			if(choice == 1) {// create
				create();
			}else if(choice == 2) {// delete
				delete();
			}else if(choice == 3) {// read
				read();
			}else if(choice == 4) {// update
				update();
			}else if(choice == 5) {// show data all.
				showDataAll();
			}else if(choice == 6) {
				System.out.println("데이터 세이브");
				dataSave();
			}else if(choice == 7) {
				System.out.println("데이터 로 드?");
			}else if(choice == 8) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못입력하셧습니다. 초기메뉴로 이동합니다. ");
			}

		}//end while
	}//end loop
	
	private void dataSave() {
		fileClass fileinstance = new fileClass();
		fileinstance.createFile(memberDTO);
	}

	private void showDataAll() {
		for (int i = 0; i < memberDTO.length; i++) {
			String column[] = { "번호 : ", "이름 : ", "나이 : ", "주소 : " };
			if(memberDTO[i].getNumber() != 0 &&
					memberDTO[i].getAge()!=0 &&
					!memberDTO[i].getName().equals(" ") &&
					!memberDTO[i].getAddress().equals(" ")) {
				System.out.println(column[0] + memberDTO[i].getNumber());
				System.out.println(column[1] + memberDTO[i].getName() ); 
				System.out.println(column[2] + memberDTO[i].getAge());
				System.out.println(column[3] + memberDTO[i].getAddress()); 
				System.out.println();
			}
		}
	}

	private void update() {
		System.out.print("수정할 이름:");
		String name = scannerString();
		
		// 검색
		int findIndex = -1;
		for (int i = 0; i < memberDTO.length; i++) {
			if(name.equals(memberDTO[i].getName())) {
				findIndex = i;
				break;
			}
		} 	
		
		if(findIndex == -1) {
			System.out.println("수정할 데이터를 찾을 수 없습니다");
		}else {
			System.out.print("수정할 주소:");
			String address = scannerString();
			
			memberDTO[findIndex].setAddress(address);
			System.out.println("성공적으로 데이터를 수정하였습니다");
		}
		
	}//end update

	private void read() {
		// 입력
		System.out.print("검색할 이름:");
		String name = scannerString();
		
		// 검색
		int findIndex = -1;
		for (int i = 0; i < memberDTO.length; i++) {
			if(name.equals(memberDTO[i].getName())) {
				findIndex = i;
				break;
			}
		}
		
		// 출력
		String column[] = { "번호 : ", "이름 : ", "나이 : ", "주소 : " };
		

		if(findIndex == -1) {
			System.out.println("검색하신 데이터를 찾을 수 없습니다");
		}else {
			System.out.println(column[0] + memberDTO[findIndex].getNumber());
			System.out.println(column[1] + memberDTO[findIndex].getName() ); 
			System.out.println(column[2] + memberDTO[findIndex].getAge());
			System.out.println(column[3] + memberDTO[findIndex].getAddress()); 

		}
		
	}

	private int scannerNum() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	private String scannerString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	private void delete() {
		// 입력
		System.out.print("삭제할 이름:");
		String name = scannerString();
		
		// 검색
		int findIndex = -1;
		for (int i = 0; i < memberDTO.length; i++) {
			if(name.equals(memberDTO[i].getName())) {
				findIndex = i;
				break;
			}
		} 	
		
		if(findIndex == -1) {
			System.out.println("삭제할 데이터를 찾을 수 없습니다");
		}else {
			memberDTO[findIndex].setNumber(0);
			memberDTO[findIndex].setName(" ");
			memberDTO[findIndex].setAge(0);
			memberDTO[findIndex].setAddress(" ");
			
			System.out.println("성공적으로 데이터를 삭제하였습니다");
		}	
		
	}

	private void create() {
		// 입력 		
		Scanner sc = new Scanner(System.in);
		int inputNum =0;
		for (int i = 0; i < memberDTO.length; i++) {
			if(memberDTO[i].getNumber()!=0) {
				inputNum++;
			}
			
		}
		
		System.out.print("번호:");
		int number = sc.nextInt();
		
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("나이:");
		int age = sc.nextInt();
		
		System.out.print("주소:");
		String address = sc.next();
		
		memberDTO[inputNum].setNumber(number);
		memberDTO[inputNum].setName(name);
		memberDTO[inputNum].setAge(age);
		memberDTO[inputNum].setAddress(address);
		
		System.out.println("데이터 추가 성공 ");
		for(MemberDTO n : memberDTO) {
			System.out.println(n.getNumber() + n.getName() + n.getAge() + n.getAddress());
		}
		
	}

	public void firstMenu() {
		System.out.println("1.데이터의 추가(insert)");	// create
		System.out.println("2.데이터의 삭제(delete)");	// delete
		System.out.println("3.데이터의 검색(select)");	// read
		System.out.println("4.데이터의 수정(update)");	// update
		System.out.println("5.데이터 모두 출력\n");
		
		System.out.println("6.데이터 세이브");
		System.out.println("7.데이터 로 드?");


		System.out.println("9, 0 . 프로그램을 종료합니다.");
		
		
		
		
		System.out.print("메뉴번호를 입력해 주십시오 >> ");
	}

	private void setBaseData() {
		memberDTO[0].setNumber(1001);
		memberDTO[0].setName("홍길동");
		memberDTO[0].setAge(23);
		memberDTO[0].setAddress("서울시");
		
		memberDTO[1].setNumber(1002);
		memberDTO[1].setName("일지매");
		memberDTO[1].setAge(22);
		memberDTO[1].setAddress("부산시");

		memberDTO[2].setNumber(1003);
		memberDTO[2].setName("김초코");
		memberDTO[2].setAge(26);
		memberDTO[2].setAddress("경기도 수원시");

		memberDTO[2].setNumber(1004);
		memberDTO[2].setName("김미남 ");
		memberDTO[2].setAge(29);
		memberDTO[2].setAddress("경기도 수원시");
	}//end base data 

}//end dao
