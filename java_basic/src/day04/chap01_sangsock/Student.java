package day04.chap01_sangsock;
//상속
//상속에는 2가지 개념이 있다.
//	1번 : 클래스상속
//	=> 재사용성을 위한 상속
//	2번 : 인터페이스상속
//	=> polymorphism 을 위한 상속 
//	( poly : 다양한    morph : 모양  sim : 성격,주의 )
//	polymorphism = 다양한 모양의 성격 = 다양성
//
		
//클래스 상속은 extends 라는 명령어를 통해서 이뤄집니다.
public class Student extends Korean{
	public Student() {
		System.out.println("Student() 실행");
	}
	
	
	//overriding
//	overriding 이란? 부모클래스로부터 상속받은 클래스를
//	자식이 재정의해서 쓰는것.
//	자식클래스가 오버리이딩하면해당 메소드는 자식클래스의 메소드가 실행된다.
	public String toString() {
		return "Student클래스를 overrideing 했다.";

	}
	
	//단 오버리이딩할때에는 부모클래스의 메소드 선언부와 완전히 동일해야한다.( eat(여기 내용같아야함))
	//다르면 오버라이딩이아니라 오버로딩이다.
	public void eat() {
		System.out.println("고구마를 먹는다..");
	}//static 을 추가해주면 오버라이딩이 아닌게 된다.
	
}
