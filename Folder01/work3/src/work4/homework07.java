package work4;

public class homework07 {

	public static void main(String[] args) {
		// TODO 1~100사이의 짝수의 합과 홀수의 합을 각각 출력하도록 작성하여라.
		int even=0;
		int odd=0;
		
		for (int i = 1; i < 101; i++) {
			if(i%2==0) {
				even+=i;
			}else if(i%2==1) {
				odd+=i;
			}
//			System.out.println("홀수합" + even);
//			System.out.println("짝수합" + odd);	
		}
		System.out.println("홀수합" + even);
		System.out.println("짝수합" + odd);
		

	}//end of main

}//end of class
