package chap07Function.Exercise;

public class exercise05 {

	public static void main(String[] args) {
		int num1[] = {1,2,3,4,5};
		
	for(int n : getdouble(num1)){
		System.out.print(n + " ");
	}
		

	}//end main
	//배열내 값의 2배값이 산출되도록하기. 

		static int[] getdouble(int[] num1) {
		for (int i = 0; i < num1.length; i++) {
			num1[i]*=2;
		}
		
		return num1;
	}

}//end class
