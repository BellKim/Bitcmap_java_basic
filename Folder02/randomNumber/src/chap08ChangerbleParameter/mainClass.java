package chap08ChangerbleParameter;

public class mainClass {
	public static void main(String[] args) {
		/*
		 	가변인수
		 
		 
		  */
		
		allocParameter(2,3,4);
		
		System.out.println("adsfasd===");
		
		alloc_parameter("hello", 2,3,4);
		
		
	
	
	
	}//end main

	private static void allocParameter(int...ab) {
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			sum = sum+ab[i];
		}
		System.out.println("합계" + sum);
		
		
	}//end allocParameter
	
								//getter
	static void alloc_parameter(String str, int ...ab) {
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			sum = sum+ab[i];
		}
		System.out.println("합계" + sum);
	}//end alloc_parameter
	
	
	
}//end classs
