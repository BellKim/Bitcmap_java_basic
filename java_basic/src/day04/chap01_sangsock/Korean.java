package day04.chap01_sangsock;

public class Korean implements Human{

	String name;
	String jumin;

	public Korean() {// 생성자 만들어줌.
		System.out.println("KOREAn 생성자 호출");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String toString() {
		return "TOSTRING's = korean + name = " + name + "  jumin = " + jumin;
	}
	
	public void eat() {
		System.out.println("김치를 먹는다........");
	}
	
//	interface 상속을 받으면
//	해당interface에서 선언된 메소드를  '반드시'
//	정의해줘야한다.
	public void speak() {
		System.out.println("한국말을 합니다.");
	}
	public void play() {
		System.out.println("놀고 있습니다.");
	}

}
