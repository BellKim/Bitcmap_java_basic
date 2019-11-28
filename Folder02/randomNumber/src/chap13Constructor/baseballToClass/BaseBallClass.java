package chap13Constructor.baseballToClass;

import java.util.Scanner;

public class BaseBallClass {
	private int r_num[], u_num[];
	private boolean clear;
	private int message[];
	private int w;

	
	
	
	public BaseBallClass() {

		
	}
	
	
	public void init() {
		r_num = new int[3];
		u_num = new int[3];		
		clear = false;
		message = new int[2];
		w=0;
	}
	
	
	public void loop() {
		
		while(true) {
			ballRandom(r_num);
			
			while(w < 10) {
				
				// 3.user input
				u_num = userInput(u_num);
				
				// 4.판정
				clear = finding(r_num, u_num, message);	
				System.out.println("clear 은 ? " + clear);
				if(clear) {
					break;
				}
				
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
			
			
//			init();
			
		
		}
	}//end loop


	private boolean finding(int[] rnum, int[] unum, int[] message) {
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
				System.out.println(message[1]+" , "+message[0]);
		if(strike > 2) {
			return true;
		}
		return false;
	

	}//end finding


	private int[] userInput(int[] unum) {
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
	}//end userInput


	private void ballRandom(int[] rnum) {
		
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
		
		
		
	}//end ballRandom
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end baseballClass
