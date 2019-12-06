package DTO;

public class HumanDTO {
	private int number;
	private String name;
	private int age;
	private int height;
	
	
	public HumanDTO() {
		// TODO Auto-generated constructor stub
	}
	


	public HumanDTO(int number, String name, int age, int height) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}



	@Override
	public String toString() {
		return "HumanDTO [number=" + number + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}




	
	
	
	
	
	
	

}//end of classs

