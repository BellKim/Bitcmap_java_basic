package chap05Sorting;
/*
sorting

선언부

입력부
몇개를 정렬하시겠습니까
동적할당
숫자를 갯수에 맞게 입력받느다
올림(1)/내림(2)

정렬

결과출력
*/

import java.util.Scanner;

public class mainClass01 {
	public static void main(String[] args) {

//		sorting

//		선언부
		Scanner sc = new Scanner(System.in);
//		int [] arr = new int[40];
		int inputNum[];

		int inputStatus;
		int temp = 0;
		

//		입력부

//		몇개를 정렬하시겠습니까
		System.out.println("몇개를 정렬하시겠습니까? ");
		inputStatus = sc.nextInt();
//		동적할당
		inputNum = new int[inputStatus];

//		숫자를 갯수에 맞게 입력받는다.
		for (int i = 0; i < inputNum.length; i++) {
			System.out.print(i+" 번째수 입력\n >>");
			inputNum[i] = sc.nextInt();
		} // n개에 맞춰서 입력을 받는다.

//		올림(1)/내림(2)
		System.out.println("오름차순,내림차순을 선택해주세요 \n 1. 오름차순, 2. 내림차순");
		inputStatus = sc.nextInt();
//		정렬
		for (int i = 0; i < inputNum.length-1; i++) {
			for (int j = i+1; j < inputNum.length; j++) {
				if(inputStatus == 1) {
					if(inputNum[i] > inputNum[j]) {
						temp = inputNum[i];
						inputNum[i] = inputNum[j];
						inputNum[j] = temp;
						}
				}else if(inputStatus == 2){			
					if(inputNum[i] < inputNum[j]) {
						temp = inputNum[i];
					inputNum[i] = inputNum[j];
					inputNum[j] = temp;
					}
				}else {
					System.out.println("오류");
				}
			}
		}
		
		System.out.println("결과 \n");
		for (int i = 0; i < inputNum.length; i++) {
			System.out.print(inputNum[i] + " ");
			
		}
//	결과출력

		sc.close();
	}// end main

}// end class
