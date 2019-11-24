package day04.chap06_game;

import java.util.Random;
import java.util.Scanner;

public class Ex07_RockScissorsPaper {
	
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		String[] rsp = {"가위", "바위","보"};
		System.out.println("1.가위  2.바위   3.보 \n> ");
		
		System.out.println("");
		int userChoice = scan.nextInt()-1;
		if(userChoice<0 || userChoice>2) {
			System.out.println("잘못입력해습니다.");
		}else {
			int computerChoice = rand.nextInt(3);
			System.out.println("사용자: "+rsp[userChoice]);
			System.out.println("컴퓨터: "+rsp[computerChoice]);
			if(userChoice == computerChoice) {
				System.out.println("비김!");
			}else {
				switch(userChoice) {
				case 0:
					if(computerChoice == 1) {
						System.out.println("사용자 패배");
					}else {
						System.out.println("사용자 승리");
					}
					break;
				case 1:
					if(computerChoice == 2) {
						System.out.println("사용자 패배");
					}else {
						System.out.println("사용자 승리");
					}
					break;
				case 2:
					if(computerChoice == 0) {
						System.out.println("사용자 패배");
					}else {
						System.out.println("사용자 승리");
					}
					break;
				}
			}
		}
		
		
	

	
	}//end main
	
}//end class
