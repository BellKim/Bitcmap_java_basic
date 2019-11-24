package day15.work5;

public class mainClass {
	public static void main(String[] args) {
		
	
		//피보나치수열 (fibonnaci) 이테리어
		/*
		  바로 앞 수를 더해서 다음수가 나온다. 
		  c=a+b
		  0 1 1 2 3 5 8 13 21 34 
		  a b c
		    a b c
		      a b c 
		        a b c 
		        .... 
		         ......
		         .......
		  */
		//int로 변수르 잡으면 범위를 넘어ㅓ선다.
		long a, b;		//대입변수
		long c;
		long  pArr[] = new long[20];
		
		a=0;
		b=1;
		
		pArr[0] = a;
		pArr[1] = b;
		int  w = 0;
		while(w<18) {
			c = a + b;
			pArr[w+2]=c;
			
			a=b;
			b=c;
			
			w++;
		}
		
		
		for (int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i] + " ");
		}
		System.out.println(" ==============  ");
		
		
	
	}//end  main

}//end calss
