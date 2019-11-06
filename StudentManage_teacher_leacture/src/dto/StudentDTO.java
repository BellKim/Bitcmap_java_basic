package dto;

import controller.StudentController;

//학생관리 프로그램을 작성하시오.
//필드: 관리번호, 이름, 전공, 국어, 영어, 수학 점수들
//메소드는 알어서 분리하고
//cinema 처럼 분리해서 만들어주세요.
//목표 : 패키지분리, ArrayList 사용
public class StudentDTO {
	private int studentNo;
	private String name;
	private String major;
	private int kor;
	private int eng;
	private int math;
	
	//캡슐화를 하기위해 getter setter 정의
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


 	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StudentDTO)) {//인스턴스오브가 아닐때 false.
			return false;
		}//메모리에 선언되어있는 객체의 형태를분석해서 이게만약 NULL 이라면 그객체는 FALSE로 처리해라.
		//student dto 
		StudentDTO other = (StudentDTO) obj;
		if (studentNo != other.studentNo) {
			return false;
		}
		return true;
	}//image 참조.
	

	
	

}//end of class
