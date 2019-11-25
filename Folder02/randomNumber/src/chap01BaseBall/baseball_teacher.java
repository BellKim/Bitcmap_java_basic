package chap01BaseBall;

import java.util.Scanner;

public class baseball_teacher {
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
		Scanner sc = new Scanner(System.in);
		
		int r_num[], u_num[];
		int r, w;
		boolean clear;
		int strike, ball;
		boolean _switch[] = new boolean[10];
		
//		1. 초기화
		
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		for (int i = 0; i < _switch.length; i++) {
			_switch[i] = false;
		}
		
//		2. random
		while(true) {
			for (int i = 0; i < u_num.length; i++) {
				r_num[i] = (int)(Math.random()*10)+1;
				}

			  if(r_num[0] != r_num[1] &&r_num[0] != r_num[2] &&r_num[1] != r_num[2]) { 
				  break;
			  }
			 
			w=0;
			while(w<3) {
				
				r= (int)(Math.random() * 10);
				if(_switch[r] == false) {
					_switch[r] = true;
					r_num[0] = r+1;
					w++;
				}
			}
			for (int i = 0; i < r_num.length; i++) {
				System.out.println(i + "=" + r_num[i]);
			}
		}
//		//////////////loop
		strike = ball = 0;
//		3. user input
		while(true){
			for (int i = 0; i < u_num.length; i++) {
				System.out.println((i+1) + "번째수  = ");
			}
		}
//		4. finding
		//ball 판정
		
//		for (int i = 0; i < r_num.length; i++) {
//			for (int j = 0; j < r_num.length; j++) {
//				if(r_num[i] == u_num[i] && i != j) {
//					ball++;
//				}
//			}
//		}
		//strike판정
//		for (int i = 0; i < r_num.length; i++) {
//			
//		}
//		//////////////end loop
//		5. result
		
		

	}

}
