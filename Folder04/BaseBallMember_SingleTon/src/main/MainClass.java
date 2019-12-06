package main;

import java.util.HashMap;
import java.util.Scanner;

import DAO.Insert;
import DAO.showAll;
import DTO.Human;
import SingleTon.singleTonClass;



public class MainClass {
	
	private static HashMap<String, Human> hMap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		singleTonClass singlet = singleTonClass.getInstance();
		
		
		
		while(true) {
			int choice = 0;
			System.out.println("1. 추가   9. 전체출력");
			choice = sc.nextInt();
			if(choice == 1) {
				Insert is = new Insert();
				is.insert();
				
				
				
			}else if(choice == 2) {
				
			}else if(choice == 3) {
				
			}else if(choice == 4) {
				
			}else if(choice == 5) {
				
			}else if(choice == 6) {
				
			}else if(choice == 7) {
				
			}else if(choice == 8) {
				
			}else if(choice == 9) {
				showAll sa = new showAll();
				sa.showAll();
			}else if(choice == 0) {
				
			}else {
				System.out.println("잘못입력하셧습니다.");
			}
			
			
			
		}//end while
		
		
		
		
		
	}
	

}//end MainClass
