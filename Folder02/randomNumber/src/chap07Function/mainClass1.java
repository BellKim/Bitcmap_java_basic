package chap07Function;

public class mainClass1 {

	public static void main(String[] args) {
		
		
		
		
		int num = 11;
		int arrNum[] = new int [1];
		arrNum[0] = 11;
		
//		func(num, arrNum);
//		
//		System.out.println(" n = " + num);
//		System.out.println(" arr[0] = " + arrNum[0]);
//		int aNumber[] = {2,4,6,8,10};
//		func(num, aNumber);
		System.out.println();
		
		int a=1;
		int b=2;
		
//		System.out.println("1함수전  a= " + a + "b  =" + b);
//		
//		swap(a, b);
//		System.out.println("1함수후  a= " + a + "b  =" + b);
		
		
		
		
		int arr[] = new int [2];
		arr[0] = 1;
		arr[1] = 2;
		System.out.println("함수전 arr[0] = " + arr[0] +"arr[1]" + arr[1]);
		
		swapArr(arr);
		
		System.out.println("함수전 arr[0] = " + arr[0] +"arr[1]" + arr[1]);
		
		
		
		
		
		
	}//end main
	
	static void arrDiv(int anum[]) {
		for (int j = 0; j < anum.length; j++) {
			
			anum[j] = anum[j]/2;
		}
	}
	
	static void swap (int a, int b) {
		int temp;
		temp = a;
		a=b;
		b=temp;
		
		System.out.println(" 함수 안 =  " + a +" b =  " + b+" " + " temp = " + temp);
	}
	
	static void swapArr (int []arr) {
		int temp;
		temp = arr[0];
		arr[0]=arr[1];
		arr[1] = temp;
		
		System.out.println(" 함수 안 arr[0]=  " + arr[0] +" b arr[1]=  " + arr[1]+" " );
	}
	
	
	static int[] randomValue(int rnum) {
		int array[] = new int [rnum];//인자값에 대해서 랜덤값의 갯수를 받아오는 방식.(가변선언) 
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 10);
			
		}
		return array;
	}
	
	
					//value, adress(=pointer)
	static int func(int n, int arr[]) {
		System.out.println("func의  n = " + n);
		System.out.println("func의  arr[0] = " + arr[0]);
		
		n=22;
		arr[0]=22;
		
		System.out.println("func의  n = " + n);
		System.out.println("func의  arr[0] = " + arr[0]);
		
		return n;
	}
	

	
	
}//end class
