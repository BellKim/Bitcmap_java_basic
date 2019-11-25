package chap03randomNumber;

import java.util.Scanner;

/*
	random -> 1개    1~100범위 를 받는다.
	
	무작위 숫잘를 입력받음.
	(랜덤넘버 75일경우)
	
	----------------------------loop 로 입력받고, 기회는 10회
	입력>>50
	message : 너무 작습니다.
	
	입력>>70
	message : 너무 작습니다.
	
	입력>>90
	message : 너무 큽니다.
	
	입력>>
	message : 너무 작습니다.

	---------------------------------
	결과 출력.
	
	1. 선언부 
	2. 랜덤값을 받아야함. 1~100까지 받는다.
	----------------------루프
	3. 유저로부터 입력을 받음. 
	4. 판정
	----------------------루프끝
	5. 결과출력
	
*/
public class mainclass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		int randomNum = (int)(Math.random()*100)+1;
		int inputNum, inputCount;
		
		System.out.println("랜덤값이 정해졌습니다.(1~100사이) \n 숫자를 입력하여 랜덤값을 맞춰주세요.");
		for (inputCount = 0; inputCount < 10; inputCount++) {
			System.out.println("시도 : " + (inputCount+1));
			inputNum = scan.nextInt();
			if(inputNum<randomNum) {
				System.out.println(" 업 \n");
			}else if(inputNum>randomNum) {
				System.out.println(" 다운 \n");
			}else if(inputNum == randomNum){
				System.out.println("정답입니다.\n");
				break;
			}else {
				System.out.println("오류");
				break;
			}
		}// end for
		

		//결과
		System.out.println("===============================================\n");
		
		System.out.println("당신은 총 "+inputCount+"회를 시도하였습니다.");
		System.out.println("정답은 " + randomNum+ "이었습니다. \n");
		
		System.out.println("===============================================");
		
		
	*/	
		
		
		
		
		//========================다른 방법 ==============================================
		int w=0; 
		int u_num=0;
		int r_num = (int)(Math.random()*100)+1;
		
		int findnum = 0;
		boolean clear = true;
		
		//초기화 
		
		while(clear) {
			clear = true;
			while(w<10) {
				System.out.println("숫자를 입력해주세요");
				u_num=scan.nextInt();
				if(u_num>r_num)	findnum = 1;
				else if(u_num<r_num) findnum=2;
				else				findnum=3;
				
				switch(findnum) {
				case 1:
					System.out.println("너무 큽니다.");
					break;
				case 2:
					System.out.println("too small");
					break;
				case 3:
					System.out.println("정답입니다. ");
					break;
					
				}
				w++;
			}
			//결과
			if(clear) {
				System.out.println("Clear gmae");
			}else {
				System.out.println("gameover");
			}
	//		replay?
			String msg = "";
			System.out.println("replay? Y/N");
			msg = scan.next();
			
			if(msg.charAt(0)!='y' && msg.charAt(0) != 'Y'){
				System.out.println("good BYE!");
			}else {
				clear = false;
			}
			
		}
		
		
	}//end main
}//end class
