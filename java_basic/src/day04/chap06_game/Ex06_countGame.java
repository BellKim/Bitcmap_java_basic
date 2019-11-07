package day04.chap06_game;

import java.util.Random;
import java.util.Scanner;

public class Ex06_countGame {

	public static void main(String[] args) {
		Random rand = new Random();
//		랜덤클래스는 0과1  사이의 무수한 실수와 정수 난수들을 가지고있다.
//		무슨뜻이냐? 0~1 사이의 순서가 일정하지 않은 랜덤한 숫자를 가지고 있는 형태이고 
//		사용자가 요청하면 그 숫자를 하나 꺼내준다.
		int randomNumber = rand.nextInt(50) + 1;
		double randomDouble = rand.nextDouble() * 50;
		int score = 1;

		System.out.println("randomNumber = " + randomNumber);
		System.out.println("randDouble = " + randomDouble);

		Scanner scan = new Scanner(System.in);
		int userNum = -1;
		do {
			System.out.println("숫자를 입력해주세용ㅇㅇㅇㅇㅇㅇㅇㅇ");
			userNum = scan.nextInt();
			if (userNum > randomNumber) {
				System.out.println("down");
				score++;
			} else if (userNum < randomNumber) {
				System.out.println("! UP !");
				score++;
			}
		} while (userNum != randomNumber);

		System.out.println("맞추셧슴");
		System.out.println("score = " + score);

	}// end main

}// end class
