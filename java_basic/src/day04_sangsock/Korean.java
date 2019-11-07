package day04_sangsock;

public class Korean {

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

}
