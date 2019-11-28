package work2;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// [회원수][정보]
		String datas[][] = new String[10][4];
		/*
			[0] : 번호
			[1] : 이름
			[2] : 나이
			[3] : 주소
		*/
		
		int choice;
		int memberNum = 0;
		
		datas[0][0] = "1001";
		datas[0][1] = "홍길동";
		datas[0][2] = "24";
		datas[0][3] = "서울시";
		
		datas[1][0] = "1002";
		datas[1][1] = "일지매";
		datas[1][2] = "22";
		datas[1][3] = "부산시";
		
		while(true) {
			System.out.println("1.데이터의 추가(insert)");	// create
			System.out.println("2.데이터의 삭제(delete)");	// delete
			System.out.println("3.데이터의 검색(select)");	// read
			System.out.println("4.데이터의 수정(update)");	// update
			System.out.println("5.데이터 모두 출력");
			
			System.out.print("메뉴번호를 입력해 주십시오 >> ");
			choice = sc.nextInt();
			
			if(choice == 1) {	// 데이터 추가
				// 입력 		
				System.out.print("번호:");
				String number = sc.next();
				
				System.out.print("이름:");
				String name = sc.next();
				
				System.out.print("나이:");
				String age = sc.next();
				
				System.out.print("주소:");
				String address = sc.next();
				
				datas[memberNum][0] = number;
				datas[memberNum][1] = name;
				datas[memberNum][2] = age;
				datas[memberNum][3] = address;
				
				memberNum++;		
			}
			else if(choice == 2) {	// 데이터 삭제	-> ""
				// 입력
				System.out.print("삭제할 이름:");
				String name = sc.next();
				
				// 검색
				int findIndex = -1;
				for (int i = 0; i < datas.length; i++) {
					if(name.equals(datas[i][1])) {
						findIndex = i;
						break;
					}
				} 	
				
				if(findIndex == -1) {
					System.out.println("삭제할 데이터를 찾을 수 없습니다");
				}else {
					datas[findIndex][0] = "";
					datas[findIndex][1] = "";
					datas[findIndex][2] = "";
					datas[findIndex][3] = "";
					
					System.out.println("성공적으로 데이터를 삭제하였습니다");
				}				
			}
			else if(choice == 3) {	// 데이터 검색
				// 입력
				System.out.print("검색할 이름:");
				String name = sc.next();
				
				// 검색
				int findIndex = -1;
				for (int i = 0; i < datas.length; i++) {
					if(name.equals(datas[i][1])) {
						findIndex = i;
						break;
					}
				}
				
				// 출력
				String column[] = { "번호", "이름", "나이", "주소" }; 
				if(findIndex == -1) {
					System.out.println("검색하신 데이터를 찾을 수 없습니다");
				}else {
					for (int i = 0; i < column.length; i++) {
						System.out.println(column[i] + ":" + datas[findIndex][i]);						
					}
				}
			}
			else if(choice == 4) {	// 데이터 수정
				// 입력
				System.out.print("수정할 이름:");
				String name = sc.next();
				
				// 검색
				int findIndex = -1;
				for (int i = 0; i < datas.length; i++) {
					if(name.equals(datas[i][1])) {
						findIndex = i;
						break;
					}
				} 	
				
				if(findIndex == -1) {
					System.out.println("수정할 데이터를 찾을 수 없습니다");
				}else {
					System.out.print("수정할 주소:");
					String address = sc.next();
					
					datas[findIndex][3] = address;
					System.out.println("성공적으로 데이터를 수정하였습니다");
				}
			}
			else if(choice == 5) {	// 모두 출력
				for (int i = 0; i < datas.length; i++) {
					for (int j = 0; j < datas[0].length; j++) {
						if(datas[i][j] != null && !datas[i][0].equals("")) {
							System.out.println("datas[" + i + "][" + j + "] = " + datas[i][j]);
						}
					}
				}
			}		
		}		
		

	}

}




