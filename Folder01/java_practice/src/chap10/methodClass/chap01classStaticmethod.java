package chap10.methodClass;
class InstCnt{
//	static int instNum=0;	//클래스 변수 (static 변수)
	int instNum=0; 
	
	public InstCnt() {
		// TODO 생성자.
		instNum++;		//static으로 선언된 변수의 값 증가. 
		System.out.println("인스턴스 생성  : " + instNum);
		
	}
					
}

public class chap01classStaticmethod {
	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
		InstCnt cnt4 = new InstCnt();
		
		
		
				
		
	}//end main
}//end class

