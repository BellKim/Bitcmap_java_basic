package chap10.methodClass;

class AccessWay{
	 static int num=0;
	 AccessWay(){
		 incrCnt();
		 
	 }
	 void incrCnt() {
		 num++;
	 }
}//end AccessWay


public class chap02classVarAccess {	
	public static void main(String[] args) {
		AccessWay way = new AccessWay();
		way.num++;	//외부에서 이름을 통한 접근.
		AccessWay.num++;	//외부에서 클래스 이름을 통한 접근.
		System.out.println("num = " + AccessWay.num);
		
//		System.out.println(num);
		
		
		
		
		
	}//end of main

}//end of class
