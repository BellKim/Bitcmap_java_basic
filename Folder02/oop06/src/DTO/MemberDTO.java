package DTO;

public class MemberDTO {
	private int number;
	private String name;
	private int age;
	private String address;
	
	public MemberDTO() {
		number= 0;
		name=" ";
		
		age =0;
		address = " ";

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberDTO [number=" + number + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	

}//end main
