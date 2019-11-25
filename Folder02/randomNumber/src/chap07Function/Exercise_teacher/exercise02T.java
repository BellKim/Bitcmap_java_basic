package chap07Function.Exercise_teacher;

public class exercise02T {

	
	
	public static void main(String[] args) {
		int []original= {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		
		
	}//end main

	private static int[] shuffle(int[] original) {
		int temp;
		for (int i = 0; i < 1000; i++) {
			int r1 = (int)(Math.random()*original.length);
			int r2 = (int)(Math.random()*original.length);
			
			temp = original[r1];
			original[r1] = original[r2];
			original[r2] = temp;
			
			return original;
			
			
		}
		
		
		
		
		return null;
	}
	
	
	
	
	
}
