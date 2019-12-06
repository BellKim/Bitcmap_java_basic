package dto;

public class MemberDto {

	private int number;
	private String name;
	private int age;
	private String address;
	private int total;
	private int avg;
	private int rank;
	
	
	public MemberDto() {
	}

	public MemberDto(int number, String name, int age, String address) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public MemberDto(int number, String name, int age, String address, int total, int avg) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.address = address;
		this.total = total;
		this.avg = avg;
	}
	

	public MemberDto(int number, String name, int age, String address, int total, int avg, int rank) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.address = address;
		this.total = total;
		this.avg = avg;
		this.rank = rank;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

	@Override
	public String toString() {
		return "MemberDto [number=" + number + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
}//end memberDTO






