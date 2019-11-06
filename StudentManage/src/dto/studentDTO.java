package dto;
//학생관리 프로그램을 작성하시오.
//필드: 관리번호, 이름, 전공, 국어, 영어, 수학 점수들
//메소드는 알어서 분리하고
//cinema 처럼 분리해서 만들어주세요.
//목표 : 패키지분리, ArrayList 사용
public class studentDTO {
	private int studentNo;
	private String name;
	private String major;
	private int kor;
	private int eng;
	private int math;
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	@Override
	public String toString() {
		return "studentDTO [studentNo=" + studentNo + ", name=" + name + ", major=" + major + ", kor=" + kor + ", eng="
		        + eng + ", math=" + math + "]";
	}
	
	

}//end of class
