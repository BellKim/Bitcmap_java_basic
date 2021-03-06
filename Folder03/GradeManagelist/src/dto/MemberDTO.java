package dto;


public class MemberDTO {
	private String name;
	private int age;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int avg;
	private int rank;

	

	
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String name, int age, int kor, int eng, int math) {
		super();
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public MemberDTO(String name, int age, int kor, int eng, int math, int total, int avg) {
		super();
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
		this.avg = avg;
	}

	
	public MemberDTO(String name, int age, int kor, int eng, int math, int total, int avg, int rank) {
		super();
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
		this.avg = avg;
		this.rank = rank;
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
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
		return "MemberDTO [name=" + name + ", age=" + age + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + ", avg=" + avg + ", rank=" + rank + "]";
	}






	
	
	
	
	
	
	

}//end of class
