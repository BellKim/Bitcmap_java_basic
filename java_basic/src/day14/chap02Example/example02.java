package day14.chap02Example;

/*
 * * 2문 2차원 배열을 1차원 배열에 대입하라. 3*4 ->12
 */

public class example02 {
	public static void main(String[] args) {
		
//		int[][] makeArr= {
//				{12,11,10,9},
//				{8,7,6,5},
//				{4,3,2,1}
//		};
////내코드		
//		int [] inputArr = new int [(makeArr.length*makeArr[makeArr.length-1].length)];//3*4=12칸 배열	
//		
//		System.out.println(makeArr.length + " " + makeArr[makeArr.length-1].length);
//		int adder=0;
//		for (int i = 0; i < makeArr.length; i++) {
//			for (int j = 0; j < makeArr[i].length; j++) {
//
//				
//				inputArr[adder] = makeArr[i][j];
//				System.out.println("adder : " + adder);
//				adder++;
//			}
//		}
//		for(int n : inputArr) {
//			System.out.println("inputarr : "+ n);	
//		}

		//수업코드내용
		int[][] array2= {
				{12,11,10,9},
				{8,7,6,5},
				{4,3,2,1}
		};
		int col = array2.length;//column;
		int row = array2[0].length;
		int array1[] = new int[col*row];
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				array1[i*array2[0].length + j] = array2[i][j];
			}
		}
		
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
			
		}

		

		


	}//main

}//end class
