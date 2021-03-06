package chap07FunctionToSorting_baseball_Sort;

import java.util.Scanner;

public class baseball_teacherChangeToMethod {
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
		
		/*
		  	1. 초기화
		  	
			2. random 산출
			
			//////////////////////// loop
			
			3. user input
			
			4. 판정
			
			5. 메시지
			
			///////////////////////
			
			6. 결과		
		*/
		int r_num[], u_num[];
		boolean clear;
		
		// 1.초기화
		r_num = new int[3];
		u_num = new int[3];		
		clear = false;
		
		// 2.random 산출
		ballRandom(r_num);
		
		
		int w = 0;
		int message[] = new int[2];
		while(w < 10) {
			
			// 3.user input
			u_num = userInput(u_num);
			
			// 4.판정
			clear = finding(r_num, u_num, message);			
			if(clear) break;
			
			// 5.메시지
			System.out.println(message[0] + "스트라이크 " + message[1] + "볼입니다");
			
			w++;
		}
		
		// 6. 결과	
		if(clear) {
			System.out.println("Game Clear!!");
		}
		else {
			System.out.println("Game Over~");
		}
		
		
		
		/*
		Scanner sc = new Scanner(System.in);
				
		int strike, ball;	
		boolean _switch[] = new boolean[10];	
		int w, r;
		
				
		//	1.초기화
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		for (int i = 0; i < _switch.length; i++) {	// fffff fffff
			_switch[i] = false;
		}
			
		//	2.random		
		w = 0;
		while(w < 3) {
			r = (int)(Math.random() * 10);	// 0 ~ 9
			if(_switch[r] == false) {
				_switch[r] = true;		// fftff fffff
				r_num[w] = r + 1;		// 1 ~ 10
				w++;
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "] = " + r_num[i]);
		}
					
		//////////////////	loop
		w = 0;
		while(w < 10) {
			strike = ball = 0;
			//	3.user input
			while(true) {
				for (int i = 0; i < u_num.length; i++) {
					System.out.print((i + 1) +  "번째 수 = ");
					u_num[i] = sc.nextInt();
				}
				if(u_num[0] != u_num[1] 
						&& u_num[0] != u_num[2]
								&& u_num[1] != u_num[2]) {
					break;
				}
				System.out.println("중복된 숫자가 있습니다");
			}
				
			//	4.finding
			// ball
			for (int i = 0; i < r_num.length; i++) {
				for (int j = 0; j < r_num.length; j++) {
					if(r_num[i] == u_num[j] && i != j) {
						ball++;
					}
				}
			}		
			
			// strike
			for (int i = 0; i < r_num.length; i++) {
				if(r_num[i] == u_num[i]) {
					strike++;
				}
			}
			
			// 판정
			if(strike > 2) {
				count = w + 1;
				clear = true;
				break;
			}
			
			// 메시지
			System.out.println(strike + "스트라이크 " + ball + "볼입니다");
			
			w++;
		}
		
		//////////////////
			
		//	5.result
		if(clear) {
			System.out.println(count + "회 Game Clear!!");
		}
		else {
			System.out.println("Game Over~");
		}
		*/
	}
	
	static void ballRandom(int rnum[]) {	
		boolean _switch[] = new boolean[10];	
		int w, r;
		
		w = 0;
		while(w < 3) {
			r = (int)(Math.random() * 10);	// 0 ~ 9
			if(_switch[r] == false) {
				_switch[r] = true;		// fftff fffff
				rnum[w] = r + 1;		// 1 ~ 10
				w++;
			}
		}
		
		for (int i = 0; i < rnum.length; i++) {
			System.out.println("r_num[" + i + "] = " + rnum[i]);
		}
	}
	
	static int[] userInput(int unum[]) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			for (int i = 0; i < unum.length; i++) {
				System.out.print((i + 1) +  "번째 수 = ");
				unum[i] = sc.nextInt();
			}
			if(unum[0] != unum[1] 
					&& unum[0] != unum[2]
							&& unum[1] != unum[2]) {
				break;
			}
			System.out.println("중복된 숫자가 있습니다");
		}
		return unum;
	}
	
	static boolean finding(int rnum[], int unum[], int message[]) {
		int strike = 0, ball = 0;
		
		// ball
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if(rnum[i] == unum[j] && i != j) {
					ball++;
				}
			}
		}		
		
		// strike
		for (int i = 0; i < rnum.length; i++) {
			if(rnum[i] == unum[i]) {
				strike++;
			}
		}
		
		message[0] = strike;
		message[1] = ball;
				
		if(strike > 2) {
			return true;
		}
		
		return false;
	}

}
