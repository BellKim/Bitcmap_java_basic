package chap07Function.Exercise;

public class exercise03 {
	// 주어진 int형 배열의 값 중에서 제일 큰 값을 반환함.
	// 주어진 배열이 null 이거나 크기가 0인경우 -999999를 반환한다.

	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
//		int[] data= new int[0];
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값 : " + max(data));

	}// end main

	private static int max(int[] arr) {
		int max = -999999;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			} else if ((arr.length == 0) || arr == null) {
				System.out.println("배열의 크기가 0");
				System.out.println("혹은 배열이 NULL ");
				break;
			}
		}

		return max;
	}

}// end class
/*
	


*/