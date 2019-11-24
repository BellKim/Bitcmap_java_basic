package day05.chap2_student_manage;

public class StudetController {
	public int calcSum(StudentDTO s) {
		return s.getKor()+s.getEng()+s.getMath();
	}
	
	public double calcAvg(StudentDTO s) {
		return calcSum(s)/3.0;
	}

	
	
	
}//end class
