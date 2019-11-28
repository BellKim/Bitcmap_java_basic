package chap07FunctionToSorting_baseball_Sort;

import java.util.Scanner;

public class hello {
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = null;
		
		
		arr = input(scan, arr );
		
		for(int b:arr) {
			System.out.println("최종결과값 : "+ b);
		}
		
		
		
	}//end main

	 static int[] input(Scanner scan, int[] arr) {
		int count = scan.nextInt();
		
		arr = new int[count];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int a : arr) {
			System.out.println("input array data : " + a );
		}
		return arr;
		
		
		
	}//end input



	
}
