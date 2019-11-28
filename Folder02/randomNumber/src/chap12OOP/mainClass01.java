package chap12OOP;

public class mainClass01 {

	/*
			OOP Object Oriented Programing
			Aspect(관점) ㅒ갸둣ㄷㅇ ㅖ갷ㄱ므ㅑㅜㅎ
						Orienteo programing
			
			oop는,
			1. 처리중심, (절차중심과 정반대)
			2. 설계중요
			!=절차지향  -> 순차적 처리(속도가 빠름)\
			
			1. 은닉성(캡슐화)
			2. 다양성
			3. 다형성
			
			class설계
							접근지정자(public protected default private)
			class 명{
				접근지정자  변수자료형  변수명;	//meber 변수
				
				--메소드부(함수부)
				접근지정자  자료형  메소드명 (매개변수){
					메소드 내용설정
				}
			}
			
			변수(객체) 를 선언후에 동적할당을 해야 접근가능. 
			class 변수 -> object, 객체, instance(주체)
										실제 메모리 영역에 올라가는 변수를 의미함. ㅓ
										
			=> 선언방법
			클래스명 인스턴트 = new 클래스명();
			
			인스턴스 : stack 에 올라가며 인스턴스를 통해서 실제크기저장은 heap에 저장된다.
			인스턴스는 접근하기 위한 표인터(참조변수이다.)
	 */
	public static void main(String[] args) {
		
		myclass cls;	//cls==instance (메인문에 선언을 했기때문에 메모리에 올라감.
		cls = new myclass();	//heap 에 올라갔지만 cls = stack 에 저장된다. 
		cls.c = 'A';
		cls.x = 12;
//		cls.func();
		cls.method(33);

		//TV (안방, 홀, 내방)
		String name[] = new String[3];
		int channel[] = new int[3];
		boolean power[] = new boolean[3];
		
		TVclass tv1, tv2, tv3;
		tv1 = new TVclass();
		tv2 = new TVclass();
		tv3 = new TVclass();
		
		tv1.setName("LOG");
		tv2.setName("samsung");
		tv3.setName("HANSUNG");
		
		tv1.setPower(true);
		tv2.setPower(false);
		tv3.setPower(true);
		
		TVclass arrTV[] = new TVclass[3]; //변수 3개선언한거와 같음. 
		//위 내용과 같음. (tv1, tv2, tv3)
//		arrTV[0].setChannel(2);//사용불가.
		
		arrTV[0] = new TVclass();//인스턴스를 잡은뒤에 (포인터지정)
		arrTV[0].setChannel(2);// 해당 포인터를 이용한 주소를 통해 메소드 사용가능.
//		System.out.println("티브이 체널 : "+arrTV[0].getChannel());
						
		
		
	}//end amin

}//end class




class myclass{
	//변수부(맴버)
	int x, y;
	char c;
	String str;
	
	//str = "hello"; //변수부에 값을 대입할 수 없다. 메소드부에 가서 조작해야한다. 
	
	//메소드부
	void func() {
		x = 0;
		System.out.println("My class Func() 입니다. ");
		
	}
	void method (int i) {
		str = "hello";
		System.out.println("myclass method( "+i+" )");
		System.out.println("myclass method( "+i+" ), \n 입력받은 x 값은 ? : " + x);
		
	}	
}//end myclass

class TVclass{
	String name;
	int channel;
	boolean power;
	
	void setName(String newName) {
		name = newName;
	}
	String getName() {
		return name;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int newchannel) {
		channel = newchannel;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean newpower) {
		power = newpower;
	}

	
	
	
	
}//end of tvclass