package Chap01Bit;

public class mainclass {

	public static void main(String[] args) {
		/*
		   bit: 0, 1;
		    연산처리 하는데 있어서 비트연산으로 하면 조금 더 속도가 빠르다.
		   & 	AND
		   | 	OR
		   ^ 	xor			서로 다를떄 1출력, 같으면 0 
		   					쓸일이 많다?
		   					
		   << 	left shift
		   >>	right shift
		   ~ 	NOT
		   
		 */
		int num;
		//AND연산
		num = 0xD3&0xf0;
		System.out.println("num = "+num);
//			8421 8421
//			1101 0011
//			1111 0000
//			----------
//		&   1101 0000	d0
		System.out.printf("and = 0x%x\n\n", num);
		
		
		num = 0xD3|0xf0;
		System.out.println("num or = "+num);
//			8421 8421
//			1101 0011
//			1111 0000
//			----------
//		|   1111 0011	f3
		System.out.printf("OR = 0x%x\n\n", num);
		
		
		num = 0xD3^0xf0;
		System.out.println("num or = "+num);
//			8421 8421
//			1101 0011
//			1111 0000
//			----------
//		^   0010 0011	23
		System.out.printf("xor = 0x%x\n\n", num);
		
		
//		반전 0->1    1->0
//		
//		0x55;
//		8421 8421
//		0101 1010
//		1010 0101
		
//		더블워드 = int 
		byte by;
		by=~0x55;
		
		
		System.out.println(" ~by = " + by);
		
		
//		left shift
		/*
		 결과는 *2 (곱하기2)
		 	0001 -> 1 시프트왼쪽하면
		 	0010 -> 2 로 변함.
		 	0100 -> 4
		 	1000 -> 8
		 */
		
		
//		right shift
		/*
		 결과는 /2 (나누기2)		 
		 	1000 -> 8
		 	0100 -> 4
		 	0010 -> 2 로 변함.
		 	0001 -> 1 시프트왼쪽하면
		 */
//		3d 연산에 비트연산을 많이 사용한다고한다. 
		
		int bit;
//		0000기준으로 왼쪽으로 시프트 1
		bit = 0x1<< 1;
		System.out.println(" 1bit값 = "+bit);
//		0000기준으로 왼쪽으로 시프트 2
		bit = 0x1<< 2;
		System.out.println(" 2bit값 = "+bit);
//		0000기준으로 왼쪽으로 시프트 3
		bit = 0x1<< 3;
		System.out.println(" 3bit값 = "+bit);
//		0000기준으로 왼쪽으로 시프트 4
		bit = 0x1<< 4;
		System.out.println(" 4bit값 = "+bit);
		

	}//end of main

}//end of class
