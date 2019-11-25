package chap01BaseBall;

import java.util.Scanner;

public class BaseBall {
	/*
		1~10 랜덤숫자중에 3개가 뽑힘. 
		예>7 3 5
		user input (유저입력) -> 3개 숫자
		1 2 3 	-> 1ball 1개 숫자는 맞지만 자리가 안맞음.
		7 8 9	-> 1strike
		7 5 3	-> 1strike 1ball
		
		rnum != rnum2 != runu3
		2 4 4	<같은숫자 랜덤으로 나오면안됨. >
		2 4 1	=> 2strike 1ball
		
		user input -> 같은수가 입력이 되면 다시 입력!
		
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int com1, com2, com3;
		int in1, in2, in3;
		int tryCount=0;


//		com1 = 5;
//		com2 = 7;
//		com3 = 10;
//		in1 = scan.nextInt();
//		in2 = scan.nextInt();
//		in3 = scan.nextInt();
		
		int comArr[] = new int[3];
		int userArr[] = new int[3];
		
		for (int i = 0; i < comArr.length; i++) {//컴퓨터 숫자 셋팅
			comArr[i]=(int)(Math.random()*10)+1;
			for(int j=0; j<i;j++) {
				if(comArr[i]==comArr[j])i--;
			}//중복제거
		}//숫자 제시됨. 
		
		for (int j = 0; j < comArr.length; j++) {//컴퓨터 셋팅 출력
			System.out.println("ComArr"+j+" = "+comArr[j]);
		}
		
		
		
		//===========================================
		while(true) {
			for (int i = 0; i < userArr.length; i++) {//유저 숫자 셋팅
				userArr[i]=scan.nextInt();
			}
			
//			for (int j = 0; j < userArr.length; j++) {//유저 입력 출력
//				System.out.println("userArr"+j+" = "+userArr[j]);
//			}
			
			//comArr	
			//userArr
	//		1.볼체크 
	//		2.스트라이크체크
			
			
			int ballCount=0, strikeCount=0;
			for (int i = 0; i < comArr.length; i++) {//스트라이크 체크
				if(comArr[i]==userArr[i]) {
					strikeCount++;
				}
				for (int j = 0; j < userArr.length; j++) {//볼 체크
					if((comArr[i]==userArr[j]) && (comArr[i]!=userArr[i])) {
						ballCount++;
					}
				}
			}
			System.out.println((tryCount+1) + "회차 도전\n"+"볼 : "+ballCount+" 스트라이크 : " + strikeCount);
			++tryCount;
			if(ballCount ==3 &&  strikeCount==3) {
				break;
			}else if((tryCount) == 10) {
				System.out.println("도전횟수 초과하였습니다.");
				break;
			}
			
			

		}//end while
		System.out.println("\n\n프로그램 종료");
		scan.close();
		
		
		

		
		
				

	}//end main

}//end class
