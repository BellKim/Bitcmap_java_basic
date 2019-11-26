package day14.Array2Class;


public class mainclassArray {

	public static void main(String[] args) {
		/*
		 	Array : 같은 자료형의 묶음 변수들
		 	관리 ; index0 ~ n-1 
		 		다른 자료형의 묶음 class(Data Transfer Object, Value Object), structure(c)
		 	
		 	int arr[] = new int[5];
		 	int arr[] = {1,2,3};
		 	
		 	0-1-2-3-4-5
		 	
		 	단점 : 같은자료형, 정적이다, 
		 	
		 	2차원배열
		 	int array[열][행];
		 	int [행]array[열]; 배열입력시 2가지 패턴
		 	
		 	int array[2][3] = {
				 	{1,2,3},
				 	{4,5,6}
		 		};
		 */
		
		int Array2[][];
		Array2 = new int[3][];
		
		int data1[] = new int[4];
		data1[0] = 1;
		data1[1] = 2;
		data1[2] = 3;
		data1[3] = 4;
		
		int data2[] = new int[5];
		data2[0] = 5;
		data2[1] = 6;
		data2[2] = 7;
		data2[3] = 8;
		data2[4] = 18;
		
		
		int data3[] = new int[4];
		data3[0] = 9;
		data3[1] = 10;
		data3[2] = 11;
		data3[3] = 12;
		
		Array2[0] = data1;
		Array2[1] = data2;
		Array2[2] = data3;
		
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < Array2[i].length; j++) {
				System.out.print(Array2[i][j]+" ");
			}
			System.out.println();
		}
		
		int Array21[][] = new int[2][3];
		Array21[0][0] = 10;
		Array21[0][1] = 10;
		Array21[0][2] = 10;
		
		Array21[1][0] = 11;
		Array21[1][1] = 12;
		Array21[1][2] = 13;


		for (int i = 0; i < Array21.length; i++) {
			for (int j = 0; j < Array21[i].length; j++) {
				System.out.print(" "+ Array21[i][j]);
			}
			System.out.println();
		}
		
		//==========================
		int Array22[][] = {
				{1,2,3,4},		//0번쨰 0~3
				{4,5,6,7},		//2번쨰 0~3
				{8,9,10,11}		//3번째 0~3
		};
		
		for (int i = 0; i < Array22.length; i++) {
			for (int j = 0; j < Array22[i].length; j++) {
				System.out.print(" "+ Array22[i][j]);
			}
			System.out.println();
		}
		
		
		
	}//end main

}//end class
