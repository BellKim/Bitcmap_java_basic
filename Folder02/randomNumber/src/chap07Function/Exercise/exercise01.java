package chap07Function.Exercise;

public class exercise01 {
	public static void main(String[] args) {
		
		System.out.println(getDistance(1,1,2,2));
		
	}//end main
	
	
	
	
	
	//math.pow(밑, 지수)		math.qurt(a) 루트
	public static double getDistance(int x, int y, int x1, int y1) {
		//두 점 x,y 와  x1, y1 간의 거리를 구한다.
				/*
				 	(1) 알맞은 코드를 넣어 완성하시오.
				*/
		return Math.sqrt((Math.pow((y1-y), 2) + Math.pow((x1-x), 2))); 
	}
}//end class
