package day01;
//별찍기.

//chojeyungbit@gmail.com
//chojeyungbit@gmail.com

public class Ex08 {

	public static void main(String[] args) {

		System.out.println("1번");
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
//===============================================================
		System.out.println();
		System.out.println("2번");
		for (int i = 1; i <= 5; i++) {
			for (int j = 6; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
//===============================================================	
		System.out.println();
		System.out.println("2번 변형");
		for (int i = 1; i <= 5; i++) {
			String starPrint = " ";
			for (int j = i; j <= 5; j++) {
//				String을 연결하는 방법1. 
//				+연산자를 이용한다.
//				StartPrint = starPrint + "*";
//				위의 코드를 간략화 시키면
				starPrint += "*";

			}
			System.out.println(starPrint);
		} // end for

//===============================================================
		System.out.println();
		System.out.println("3번");
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		} // end for
//==================================================
		System.out.println("3번 변형");
		for (int i = 1; i <= 5; i++) {
			String starPrint = "";
			for (int j = 0; j < 5 - i; j++) {
				starPrint = starPrint.concat(" ");
			}
			for (int j = 1; j <= i; j++) {
				starPrint = starPrint.concat("*");
			}
			System.out.println(starPrint);
		} // end for
//===============================================================		
		System.out.println("3번 연결");
		for (int i = 1; i <= 5; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < i - 1; j++) {
				stringBuilder.append(' ');// 작은따옴표 여러개 넣으면 오류.
			}
			for (int j = i; j <= 5; j++) {
				stringBuilder.append("*");
			}
			System.out.println(stringBuilder.toString());
		} // end for
//===============================================================		
		System.out.println();

		System.out.println("4번");
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int k = 5; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
//===============================================================		
		System.out.print("5번");
		for (int i = 0; i <= 5; i++) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}

			for (int k = 1; k < (2 * i); k++) {
				System.out.print("*");
			}
			System.out.println();
		} // end for

		System.out.println();
//===============================================================		
		System.out.println("6번");
		for (int i = 0; i <= 5; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int k = 9; k > (2 * i); k--) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
//===============================================================		
		System.out.println("7번");
		for (int i = 1; i <= 10; i++) {
			if (i <= 5) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 10; j > i; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		} // end for
//===============================================================		
		System.out.println("8번");
		for (int i = 1; i <= 10; i++) {
			if (i <= 5) {
				for (int k = 5; k > i; k--) {
					System.out.print(" ");
				}
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
			} else {
				for (int l = 0; l < (i - 5); l++) {
					System.out.print(" ");
				}
				for (int j = 10; j > i; j--) {
					System.out.print("*");
				}

			}
			System.out.println();
		} // end for

		// ===============================================================
		System.out.println("9번");
		for (int i = 1; i <= 10; i++) {
			if (i <= 5) {
				for (int k = 5; k > i; k--) {
					System.out.print(" ");
				}
				for (int j = 0; j < (i); j++) {
					System.out.print("*");
				}
				for (int m = 1; m < i; m++) {
					System.out.print("*");
				}
			} else {
				for (int l = 0; l < (i - 5); l++) {
					System.out.print(" ");
				}
				for (int j = 10; j > i; j--) {
					System.out.print("*");
				}
				for (int j = 6; j > i - 3; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		} // end for

		// ===============================================================

		System.out.println("10번");
		for (int i = 0; i < 9; i++)System.out.print("*");
		System.out.println();
		for (int i = 0; i < 4; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 4; j > i; j--) {
				stringBuilder.append('*');
			}
			for (int k = -1; k < (2*i); k++) {
				stringBuilder.append(" ");
			}
			for (int j = 4; j > i; j--) {
				stringBuilder.append("*");
			}
			System.out.println(stringBuilder.toString());
		}
//System.out.println("ss");
		for (int i = 2; i < 5; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j <i ; j++) {
				stringBuilder.append('*');
			}
			for (int k = 5; k > i; k--) {
				stringBuilder.append(" ");
			}
			for (int k = 4; k > i; k--) {
				stringBuilder.append(" ");
			}
			for (int j = 0; j <i ; j++) {
				stringBuilder.append('*');
			}
			System.out.println(stringBuilder.toString());
		}
		for (int i = 0; i < 9; i++)System.out.print("*");
		System.out.println();
		

	}// end of main

}// end of class
