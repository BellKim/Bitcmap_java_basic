package view;

import java.util.Scanner;

import DAO.bbDAO;
import DTO.HumanDTO;
import DTO.PitcherDTO;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bbDAO dao = new bbDAO();
		System.out.println("7번선택");
		int choice;
		
		while(true) {
			choice = sc.nextInt();
			if(choice ==1) {//선수등록
				System.out.println("1.Pitcher 등록, 2.Batter 등록");
				choice=sc.nextInt();
				dao.insert(choice);
			}else if(choice == 2) {//선수삭제

			}else if(choice == 3) {//선수검색
				
			}else if(choice == 4) {//선수정보 수정
				
			}else if(choice == 5) {//방어율 TopToBottom
				
			}else if(choice == 6) {//타율 TopToBottom
				
			}else if(choice == 7) {//등록데이터 열람.
				dao.showAll();
			}else if(choice == 8) {
				
			}else if(choice == 9) {
				
			}else if(choice == 0) {
				
			}else {
				
			}
			
			
			
			
			
			
		}
		

		
	}//end main



}//end classs
