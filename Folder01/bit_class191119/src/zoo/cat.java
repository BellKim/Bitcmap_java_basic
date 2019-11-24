
package zoo;

public class cat {
	//public 선언 메소드. 위치에 상관없이 어디서든 해당 인스턴스를 생성할 수 있다.
	
	public void makeSound() {
		System.out.println("야옹");
	}
	
	//default : 동일패키지로 묶인 클래스 내에서만 인스턴스 생성가능. 
	void makeHappy() {
		System.out.println("스마일");
	}

}//end of class
