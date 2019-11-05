package day02;

public class StudentEx {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName("김미나");
		s.setAge(17);
		s.setKor(80);
		s.setEng(100);
		s.setMath(70);
		s.setJumin("912345-123456");
		
		s.study();
		s.sing();
		s.connectToMySql();
		s.goToSchool();
		
		Student s2 = new Student();
		s2.setName("김미나");
		s2.setAge(20);
		s2.setKor(75);
		s2.setEng(90);
		s2.setMath(66);
		s2.setJumin("912345-123456");
		s2.study();
		s2.sing();
		s2.connectToMySql();
		s2.goToSchool();
		System.out.println(s.equals(s2));
		String str = "abc";
		System.out.println(s.equals(str));
		
//		s와 s2 는 다른객체이다.
//		처음생성될때 들어가있는 위치와 값이 다르기 때문.
//		만약 값들이 db에서 나왔다면, 같은 객체인가 같은객체이다.
/*
 	붕어빵에서 각자의 붕어는 같은객체이다. 다만, 주소값은 다를것.
 	s, s2 서로 필드값만 달라지고, 객체는 같은 객체를 사용한다.
 	
 	붕어빵별로 일련번호가 나왔다면, 
 	
 	s. 을 치고 팝업창을 보면 equals 등과 같은 직접적으로 생성하지 않은
 	메소드 들이 뜨게된다. 이러한 것은 java.lang.object 에서 선언되어진다.
 	link java.lang.object(463라인)는 notifyAll()된다.
 	재정의가 가능하다.(오버라이드)
 
 
 
 * 
 * */
		


	}

}
