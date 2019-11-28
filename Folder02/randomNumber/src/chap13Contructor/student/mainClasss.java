package chap13Contructor.student;

public class mainClasss {
	public static void main(String[] args) {
		Student stu = new Student();
		
		/*
		 	@7852e922 4byte 로 주소값?
		 
		 */
		
		
		System.out.println(stu);
		System.out.println(stu.getThis());//stu가 저장되어있는 주소값의 위치
	
		
		
	}//end main 
	
	
}//end class
