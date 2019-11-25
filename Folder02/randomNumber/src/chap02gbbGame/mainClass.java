package chap02gbbGame;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class mainClass {
	
	/*
	 	가위, 바위, 보
	 	
	 	user : com
	 	
	 	? win ? lose ? draw
	 	
	 	replay -> y/n
	  
	  
	  
	 * */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int randomNum = (int)(Math.random()*3)+1;
		int userNum;
		int win=0,lose=0,draw=0, gameCount=0;
		
		System.out.println("가위 바위 보 게임 입니다. 입니다. ");
		
		boolean checkReGame = true;
		int inputswitch = 0;
		
		

		
		
		while(checkReGame) {
			System.out.println("1.가위, 2.바위, 3.보\n");
			userNum = scan.nextInt();
			
			
			
			System.out.println("1.가위, 2.바위, 3.보\n");
			System.out.println("컴퓨터 : "+randomNum+"  유저 : "+userNum);
			
			
			
			if(randomNum==userNum) {//비김
				inputswitch = 1;
				draw++;
				System.out.println("비겼습니다.");
				
			}
			if(randomNum==1 && userNum==2) { //가위 바위 (바위승)
				System.out.println("졌습니다.");
				lose++;
			}else if(randomNum==1 && userNum==3){
				System.out.println("이겼습니다.");//가위 보 (가위승)
				win++;
			}
			if(randomNum==2 && userNum==3) { // 바위 보 (보승)
				System.out.println("졌습니다.");
				lose++;
			}else if(randomNum==2 && userNum==1){
				System.out.println("이겼습니다.");//바위 가위(바위승)
				win++;
			}
			if(randomNum==3 && userNum==1) { //보 가위(가위승)
				System.out.println("이겼습니다..");
				win++;
			}else if(randomNum==3 && userNum==2){
				System.out.println("졌습니다..");//보 바위 (보 승)
				lose++;
			}
			gameCount++;
			

			

						
			String inputRegame;
			System.out.println("총 "+gameCount+" 게임 , \n"+win+"승, "+lose+"패, "+draw+"무 했네요" );
			System.out.println("리게임을 하시겠습니까? Y/N");
			scan.nextLine();
			inputRegame = scan.nextLine();
			if(inputRegame.equals("y") || inputRegame.equals("Y")) {
				checkReGame=true;
			}else {
				checkReGame=false;
			}
				
			
		}//end while 		
		System.out.println("게임을 종료하였습니다.");
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}//end main


}//end class 
