package starCraft;

import child.Marine;
import child.Race;
import child.Tank;
import parent.StarCraft;

public class mainClass {

	public static void main(String[] args) {
		//마린이 30기라면 인스턴스 생성 을 여러개 잡아야한다.
		Marine m[] = new Marine[10];
		Tank t[] = new Tank[10];
		Race r[] = new Race[10];
		
		StarCraft starArr[] = new StarCraft[5];
		
		starArr[0] = new Marine();
		starArr[1] = new Race();
		starArr[2] = new Marine();
		starArr[3] = new Tank();
		starArr[4] = new Tank();
		
		//overridde 된 메소드를 보기위해서 배열사용
		for (int i = 0; i < starArr.length; i++) {
			starArr[i].life();
		}
		
		//instanceof 객체를 판별해 주는 예약어이다. 
		
		for (int i = 0; i < starArr.length; i++) {
			StarCraft sc = starArr[i];
			if(sc instanceof Marine) {
				Marine ma = (Marine)sc;
//				((Marine)sc).run();// 동일한표현.
				
			}if(sc instanceof Race) {
				Race ra = (Race)sc;
				
			}if(sc instanceof Tank) {
				Tank ta = (Tank)sc;
				
			}
		}
		//자식들을 모아서 부모클래스에서 관리할 수 있따.
		
//		int array[] = { 1, 2, 3 };
//		for (int i = 0; i < starArr.length; i++) {
//			int n = array[i];
//			
		//	if(n )
		// 과 같은형태이다.
		
		

	}//end of main

}//end of class
