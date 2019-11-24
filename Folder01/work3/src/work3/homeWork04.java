package work3;

public class homeWork04 {

	public static void main(String[] args) {
		// TODO 랜덤수를 취득하여 조건에 맞는 숫자를 출력할것.
//		1. 범위:0~99 중 한개
		System.out.println("0~99 중 한개");
		for(int i=0; i<50;i++)
		System.out.print((int)(Math.random()*100) + " " );
		System.out.println("\n");
//		2. 범위: 11, 12, 13, 14, 15 중 1개
		System.out.println("11, 12, 13, 14, 15 중 1개");
		for(int i=0; i<50;i++)
		System.out.print((int)(Math.random()*5)+11 + " ");
		
//		3. 범위 : 1~45 개수 6개
		System.out.println("1~45 개수 6개");
		for(int i=0; i<6;i++)
		System.out.print((int)(Math.random()*45)+1 + " ");
		

		
		
	}//end main

}//end class




//num = (int)math.random()*10;
//0~9 출력. (random은 double 형태이다.)
//
//10 20 30 40 50 출력하기
//num = (((int)math.random()*5)+1)*10
//
//-1 0 1 뽑고싶다.
//num = ((int)math.random()*3)-1
//0 1 2 -> -1 0 1
