package day02;

public class Ex03 {
	public static void main(String[] args) {
		Tire t = new kumhoTire();
		t.setSize(32.0);
		t.setType("스노우타이어");
		t.setMetrial("합성고무");
		Car myCar = new Car(t);
	}

}
