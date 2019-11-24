package work4;

public class homeowkr02 {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (4-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}//end of main

}//end of class
