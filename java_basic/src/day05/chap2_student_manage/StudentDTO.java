package day5.chap2_student;

public class StudentDTO {
	private int year; // 학년
	private int room; // 반
	private int number; // 번호
	private String name; // 이름
	private int kor; // 국어 점수
	private int eng; // 영어 점수
	private int math; // 수학 점수
	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
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

	public String toString() {
		return year + "학년" + room + " 반 " + number + " 번  " + name + "학생  - 국어점수 " + kor + "점, 영어점수" + eng + "점, 수학점수"
		        + math + "점 ";
	}

}// end class
