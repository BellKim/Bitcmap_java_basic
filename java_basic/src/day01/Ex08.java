package day01;
//별찍기.
public class Ex08 {

	public static void main(String[] args) {
		
		System.out.println("1번");
		for(int i = 1; i<=5; i++) {
			for(int j = 0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}//end for
		
								System.out.println();
		System.out.println("2번");
		for(int i = 1; i<=5; i++) {
			for(int j = 6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}//end for
		
								System.out.println();
		System.out.println("3번");
		for(int i = 1; i<=5; i++) {
			for(int j = 5; j>i; j--) {
				System.out.print("  ");
			}
			
			for(int j = 0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}//end for
		
		System.out.println();
		
		System.out.println("4번");
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}

			for (int k = 5; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
		
		System.out.print("5번");
		for (int i = 0; i <= 5; i++) {
			for (int j = 6; j > i; j--) {
				System.out.print("  ");
			}

			for (int k = 1; k < (2*i); k++) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
		
		System.out.println();
		
		System.out.println("6번");
		for (int i = 0; i <= 5; i++) {
			
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			
			for (int k = 9; k > (2*i); k--) {
				System.out.print("*");
			}
			System.out.println();
			
			
		} // end for
		
		
		
		
		
		
		
		

	}//end of main

}//end of class
