package day02;

public class Ex03 {
	public static void main(String[] args) {
		Tire t = new kumhoTire();
		t.setSize(32.0);
		t.setType("스노우타이어");
		t.setMetrial("합성고무");
		Car myCar = new Car(t);
		
		Student s = new Student();
		System.out.println(s);
//		println에 객체가 들어오면
//		객체의 toString() 의 실행결과값을 출력한다.
	}

}
