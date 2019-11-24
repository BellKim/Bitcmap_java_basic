package Chap02IfCase;

public class mainclass {
	public static void main(String[] args) {
//		1. 1~100 사이에 있는 숫자들 중 짝수들의 합과 홀수들의 합을 구하라.
		int even=0;//짝
		int odd=0;//홀
		
		for(int i=1;i<=100;i++) {
			if((i%2) == 0 ) {//짝수
				even+=i;
			}else {
				odd+=i;
			}
		
		}
		System.out.println("짝수합 = " + even);
		System.out.println("홀수합 = " + odd);

		
		
		
		
		
//		2. 문자열 'A' 문자를 찾아서  'a' 로 변경하라.
		char ch[] = {'D','W','A','V','Q','A'};
		
		for(char a : ch) {
			System.out.println(a);
			if(a == 'A') {
				a = (char) (a+0x20);
				System.out.println("변환된 A값  = "+a);
			}
		}
		
		
		
		
		
		
	}//end main

}//end class
