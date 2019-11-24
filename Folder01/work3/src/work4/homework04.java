package work4;

import java.util.Scanner;

public class homework04 {

	public static void main(String[] args) {
		// TODO 하나의 수를 입력받고 10의 배수로 입력받은 수는 어느범위에 있는지 출력하는 프로그램을 작성하여라.
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요 10단위의 어느범위에 있는지 알려줍니다. ");
		int inputnum1 = scan.nextInt();
		
		int res1;
		int res2;
		
		res1 = inputnum1/10;
		if(inputnum1%10 == 0) {
			System.out.println("입력받은 숫자 "+inputnum1+"은 \n " + res1*10+ " 보다 크거나 같고 " + ((res1*10)+10) + "보다 작다");
		}else {
			System.out.println("입력받은 숫자 "+inputnum1+"은 \n" + res1*10+ " 보다 크고 " + ((res1*10)+10) + "보다 작다");
		}
			
		
		scan.close();
		

	}//end of main

}//end of class
