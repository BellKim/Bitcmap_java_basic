package work4;

import java.util.Scanner;

public class homework06 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("출력하고자 하는 단수를 입력해주세요 ");
		int input = scan.nextInt();
		for (int j = 1; j < 10; j++) {
			System.out.print(input +" * " + j + " = " + input*j + "   " );
			
		}
		
		scan.close();
		
		
	}//end main

}//end class
