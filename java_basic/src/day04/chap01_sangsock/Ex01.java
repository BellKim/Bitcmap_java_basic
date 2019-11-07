package day04.chap01_sangsock;

public class Ex01 {
	public static void main(String[] args) {
//		상속받은 클래스는 부모클래스의
//		필드를 사용할 수 있다.(private 인 경우엔 getter / setter)
//		를 통해서 사용가능하다.
		Student s = new Student();
		s.jumin = "999999-111111";
		s.name = "김가나초콜릿";
		
		System.out.println("exo1의 주민"+s.jumin);
		System.out.println("exo1의 네임"+s.name);
		
		Student s1 = new Student();
		//겟터셋터 만들면,
		s1.setJumin("111111-444444");
		s1.setName("기니디리");
//		먼저 부모클래스의 생성자를 호출해서 heap메모리에
//		부모클래스가 가지고 있는 필드와 메소드를 넣고
//		그래고 자식 클래스의 필드와 메소드를 넣는다.
		System.out.println(s);
		System.out.println(s1);
		
		System.out.println("=================================");
		System.out.println("eat 소환");
//		System.out.println(eat());
		s.eat();
		
		
		Korean k = new Korean();
		Japanese j = new Japanese();
		Human me = new Japanese();//new Korean();
		torture(s);
		
	}
	
	public static void torture(Korean k) {
		System.out.println("torture");
		k.play();
	
	}
	
	 

}
