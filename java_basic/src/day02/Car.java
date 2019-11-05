package day02;

public class Car {
	Tire t; //카는 Tire에 의존적인 클래스가 되었다.
	//	타이어가 없다면 error 출력한다.
	public Car(Tire t) {
//		t.setSize(0);
//		t.setType("기본형");
//		//만약 타이어에 다른타입이 추가된다면?
//		t.setMetrial("고무");
////		tire.java에서 변수가 추가되면 car.java 에서도 데이터가 추가되어야한다.
////		상호 의존적이라서 상위클래스 객체가 추가되면 의존적인 car.java 에서도 바뀌여야만함.
		
		this.t = t;
		
	}
	

}
