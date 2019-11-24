package day02;

public class Car {
//	Tire t; //카는 Tire에 의존적인 클래스가 되었다.
//	//	타이어가 없다면 error 출력한다.
//	public Car(Tire t) {
////		t.setSize(0);
////		t.setType("기본형");
////		//만약 타이어에 다른타입이 추가된다면?
////		t.setMetrial("고무");
//////		tire.java에서 변수가 추가되면 car.java 에서도 데이터가 추가되어야한다.
//////		상호 의존적이라서 상위클래스 객체가 추가되면 의존적인 car.java 에서도 바뀌여야만함.
//		
//		this.t = t;
//		
//	}

	
	
	
	//필드 : 차량번호, 차량종류, 차량색깔, 최고속도, 연비
	//메소드 : 생성자 getter/setter, 출발, 정지, toString()
	private int carNumber;
	private String kind;
	private String color;
	private int maxSpeed;
	private int fuelEfficiency;
	
public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getFuelEfficiency() {
		return fuelEfficiency;
	}
	public void setFuelEfficiency(int fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}
	//===================================================================
	private void carGo() {
		System.out.println("car go 차가간다");
	}
	private void carStop() {
		System.out.println("car stop 멈춘다.");
	}
	
	public Car() {
//		carNumber = 0;
//		kind = "nnnnn";
//		color = "transparent";
//		maxSpeed = 0;
//		fuelEfficiency = 0;
		carNumber = 0;
		kind = "";
		color = "";
		maxSpeed = 0;
		fuelEfficiency = 0;
	}
	
	public Car(int carNumber, String kind, String color, int maxSpeed, int fuelEfficiency) {
		super();
		this.carNumber = carNumber;
		this.kind = kind;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.fuelEfficiency = fuelEfficiency;
	}

	
	
	public static void main(String[] args) {
		Car car = new Car();
		Car car1 = new Car();
		
		System.out.println(car.carNumber);
//		car1.setCarNumber(2233);
//		car1.setKind("소나타");
//		car1.setColor("녹색");
//		car1.setMaxSpeed(333);
		System.out.println(car1);
		car1.carGo();
		car1.carStop();
		
		
	}
	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", kind=" + kind + ", color=" + color + ", maxSpeed=" + maxSpeed
		        + ", fuelEfficiency=" + fuelEfficiency + "]";
	}
	
//	public String toString() {
//	return "[carNumber:" + carNumber + 
//			", kind : " + kind  +
//			", color : " + color+
//			", maxspeed : " + maxSpeed+
//			", fuelefficiency :" +fuelEfficiency + "]";
//}
	

	
	
	
}
