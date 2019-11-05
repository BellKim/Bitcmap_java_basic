package day02;

public class Student {
	public String name;
	public int age;
	public int kor;
	public int eng;
	public int math;
	public String jumin;
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
	
//	pojo?
	
//	메소드 선언방법:
//	접근제한자 리턴타입 메소드이름(파라미터)
//	접근제한자 : 해당 메소드나 필드가 어디서부터 접근 가능한지 정해준다.
//		s2.age, s2.goToSchool() 같은것들.
//	리턴타입 : 메소드가 끝난 후 호출된 곳으로 보내줄 값의 데이터타입
//	메소드이름:호출될때 사용될 이름 
//			명명법은 소문자 명사로
//	파라미터 : 이 메소드에서 필요로하는 외부의 값.
//			입력되는 데이터들() 안에 선언된 데이터타입
//	파라미터는 데이터타입 파라미터 이름으로 이루어지는데
//			모든 클래스 객체가 들어올수 있도록 선언되는 object o,
//	파라미터이름은 외부에서 보내줄 변수의 이름과 일치할 필요가 없다.
//	다만 메소드 내부에서는 파라미터의 이름으로 쓰이게 된다.
	
	public boolean equals(Object o) {
		if(o instanceof Student) {//o 가 student에서 만들어진 객체인지 확인하는 instanceof
			
//			type casting 을 이용해서 형변환을 한다.(student)
			Student s = (Student)o;//여기서의 this는 o
			if(this.jumin.equals(s.jumin)
					&& this.name.equals(s.name)) {
				//여기서 this란? 이 메소를 호출할 객체를 말한다. (StudentEx.java에서 선언된 s 나 s2 같은애들)
				return true;
			}
		}
		return false;
	}//end equals()
	//	(명시적/암시적) 형변환
	
	public static void main(String[] args) {
		
		
		

	}

}
