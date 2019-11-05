package day02;

public class student {
	public String name;
	public int age;
	public int kor;
	public int eng;
	public int math;
	public void study() {
		System.out.println("공부합시다!!");
	}//study.
	
	public void connectToMySql() {
		System.out.println("Mysql 연결");
	}
	public void sing() {
		System.out.println("서울고등학교 교가를 부른다.");
	}
	public void goToSchool() {
		System.out.println("서울 고등학교로 갑니다.");
	}
	//코드의 재사용성이 없어짐. (서울고등학교 한정으로 사용가능한 코드)
	
//	pojo? db가 내용을 담는일을 전담한다.
	
	public static void main(String[] args) {
		
		
		

	}

}
