package chap13Contructor.student;

//이것이 DTO Data Tranfer Object

public class Student {
	private int number;
	private String name;
	/*
		this.참조.
		자기 객체가 저장되어있는 힙 영역의 주소. 
	
	*/
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	public Student getThis() {
		return this;
//		return this.number;
	}	//디스를 리턴해주는데, 이건 
	
	
	
	
	
	
	/*
	public Student() {//기본생성자.
		
	}
	
	public Student getThis() {
		return this;
//		return this.number;
	}	//디스를 리턴해주는데, 이건 
	
	public void setNumber(int number) {
		//
		this.number = number;
		// 이 넘버 = 들어온넘버;
	}//객체가 들어가는 힙영역의 주소값 this
	*/
	

}//end classs
