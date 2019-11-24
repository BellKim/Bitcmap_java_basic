package day01;

public class Ex08_homework {

	public static void main(String[] args) {
		// ===============================================================
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
/*
5번      
     *
    ***
   *****
  *******
 *********

*/

		
		// ===============================================================
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
/*			
6번
*********
 *******
  *****
   ***
    *
*/
			

		// ===============================================================
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
/*

7번
*
**
***
****
*****
****
***
**
*

*/

		// ===============================================================
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
/*

8번
    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *

 */
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
/*

9번
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

*/
		} // end for

		// ===============================================================

		System.out.println("10번");
		for (int i = 0; i < 9; i++)
			System.out.print("*");
		System.out.println();
		for (int i = 0; i < 4; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 4; j > i; j--) {
				stringBuilder.append('*');
			}
			for (int k = -1; k < (2 * i); k++) {
				stringBuilder.append(" ");
			}
			for (int j = 4; j > i; j--) {
				stringBuilder.append("*");
			}
			System.out.println(stringBuilder.toString());
		}
		for (int i = 2; i < 5; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < i; j++) {
				stringBuilder.append('*');
			}
			for (int k = 5; k > i; k--) {
				stringBuilder.append(" ");
			}
			for (int k = 4; k > i; k--) {
				stringBuilder.append(" ");
			}
			for (int j = 0; j < i; j++) {
				stringBuilder.append('*');
			}
			System.out.println(stringBuilder.toString());
		}
		for (int i = 0; i < 9; i++)
			System.out.print("*");
		System.out.println();
/*
10번
*********
**** ****
***   ***
**     **
*       *
**     **
***   ***
**** ****
*********
 
 */		
		
	}// end of main
}// end of class