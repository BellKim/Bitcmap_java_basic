package chap14StaticClass02;

public class StaticClass {
	private int number;	//인스턴스변수
	public static int staticNumber;// class변수. 
	
	/*
		stack heap static sys
		
	스텍. local(지역)변수 저장영역{ } 로 이뤄진 블록을 넘어가면 사라진다.
	힙은. new 했을때 간다.(누군가 강제적으로 지워줘야한다.)지워지면 또 쓸수있음. 가비지컬랙터가 존재하는 영역.
	스테틱. 정적(동적의반대) 움직이지 않으며, 메모리에 상주하는 영역.(프로그램 시작시에) 너무 지나치게 사용하면 메모리에 쌓여서 안좋음.
			*너무 많이 사용하면안된다. 메모리에 쌓임. 
		
	*/
	public StaticClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void StaticClass() {
		staticNumber++;
	}
	
	
	
	

}// end of class
