package work4;

import java.util.Scanner;

public class homework08 {
	public static void main(String[] args) {
		//유저로부터 입력받은 수들의 합계와 평균을 구하는 프로그램ㅇ르 작성하여라 .
		
		////////////////////////////
		//입력받는 횟수도 랜덤
		//합계를 산출할 갯수 (5 입력시 5개수)
		//갯수에 맞춰서 입력을 받는다.
		/////////////////////////
		
		//////////////////////////처리
		//5개의 총 합
		//5개의 평균
		///////////////////////////
		
		///////////////////////////
		//결과출력
		
		Scanner scan = new Scanner(System.in);
		int inputCount = ((int)(Math.random()*7)+3);
		int arr [];
		int sum=0;
		int avg=0;
		
//		for (int i = 0; i < 10; i++) 
//		System.out.println(inputCount);
		System.out.println("총 ["+inputCount+"] 개의 숫자를 입력해야합니다.");
		for (int i = 0; i < inputCount; i++) {
			arr = new int [inputCount];
			System.out.println("[ "+(i+1)+" ] 번째수 입력");
			arr[i] = scan.nextInt();
			sum+=arr[i];
		}
		avg=sum/inputCount;
		
		
		System.out.println("총"+inputCount+"개를 입력받았으며, \n입력받은수의 총 합은 "+sum+"이며, \n 그 수들의 평균은 "+avg+" 입니다." );
		
		
		scan.close();
		
		
		
	}//end main

}//end class
