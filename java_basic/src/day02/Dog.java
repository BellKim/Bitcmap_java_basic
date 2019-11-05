package day02;
//필드: 이름, 종류, 성별, 나이
//메소드 : 생성자, 캡슐화 메소드, 짖는다, 먹는다, 잔다.

public class Dog {
	
	private String name;
	private String type;
	private String gender;
	private int age;
	
	public Dog() {
		name = "기본이름";
		type = "기본종류";
		gender = "기본성별";
		age = 0;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
//===============================================================
	public void dogBark() {
		System.out.println("짖는다 왈왈");
	}
	
	
	public void dogEat() {
		System.out.println("먹는다.");
	}
	
	
	public void dogSleep() {
		System.out.println("자고있네");
	}
	

}
