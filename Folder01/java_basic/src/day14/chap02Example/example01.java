package day14.chap02Example;

import java.util.Scanner;

public class example01 {
	/*
	 * 1문 1~100사이의 10개의 수를 입력받고 최소값과 최대값을 출력하는 프로그램 작성.
	 * 
	 * 
	 * 2문 2차원 배열을 1차원 배열에 대입하라. 3*4 ->12
	 * 
	 * 
	 * 
	 * 3문 두개의 수를 입력받고 계산결과를 출력하라. 문자가 포함되었는지 조사하라. (+ - * 나누기 가 입력되었는지 조사.)
	 * 
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * 1문 1~100사이의 10개의 수를 입력받고 최소값과 최대값을 출력하는 프로그램 작성.
		 */

		Scanner scan = new Scanner(System.in);

		int countNumber = 1;
		int max=0, min=100;
		System.out.println("숫자값을 2개 입력해주세요\n 단, 0~100사이의 값만 입력해주세요.");
		int [] checkMaxMin = new int[10];
		
		
		while (true) {
			System.out.println(countNumber+"번째 수 입력 : ");
			checkMaxMin[countNumber-1]=scan.nextInt();
			if(countNumber == 10) {
				break;
			}else {
				countNumber++;
			}
		}
		
		for (int i = 0; i < checkMaxMin.length; i++) {
			if(checkMaxMin[i]>max) {
				max=checkMaxMin[i];
			}
			if(checkMaxMin[i]<min) {
				min = checkMaxMin[i];
			}
			
		}
		System.out.println("최대값은 " + max + "이며, 최소값은" + min + "입니다. ");


		scan.close();

	}// end main

}// end class
