package day02;

public class Student {
//	접근제한자
//	접근가능한 범위를 지정한다.
//	public		:	어디서든지 접근가능(같은프로젝트 내부에서 모두 접근가능)
//	protected	:	같은패키지 + 상속받는 클래스까지 접근가능.
//	package		:	같은패키지에서만 접근가능(아무것도 안적어주면package이다.)
//		=> default = package 와 같은 레벨.
//	private		:	같은 클래스에서만 접근가능. 
	// 접근제한자가 아닌것은?

//	private된 필드들은 더이상 외부에서 값을 불러오거나 저장할 수 없다 따라서 method를 통해서 값을 저장하거나 불러오게된다.
//	그러한 method를 getter/setter라고 부른다.
//	getter setter들은 get필드이름, set필드이름으로 이름짓는다.

//	캡슐화 : 필드 하나하나를 캡슐화 해서 외부에서의 개별접근을 막는것. 외부클래스를 통해서 값을 넣고 빼는것을 하는것 

	private String name;
	private int age;
	private int kor;
	private int eng;
	private int math;
	private String jumin;

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

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public void study() {
		System.out.println("공부합시다!!");
	}// study.

	public void connectToMySql() {
		System.out.println("Mysql 연결");
	}

	public void sing() {
		System.out.println("서울고등학교 교가를 부른다.");
	}

	public void goToSchool() {
		System.out.println("서울 고등학교로 갑니다.");
	}
	// 코드의 재사용성이 없어짐. (서울고등학교 한정으로 사용가능한 코드)

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
		if (o instanceof Student) {// o 가 student에서 만들어진 객체인지 확인하는 instanceof

//			type casting 을 이용해서 형변환을 한다.(student)
			Student s = (Student) o;// 여기서의 this는 o
			// o는 student클래스가 아니라고 생각하기에 student라는 틀을 씌워주는것이다.
			if (this.jumin.equals(s.jumin) && this.name.equals(s.name)) {
				// 여기서 this란? 이 메소를 호출할 객체를 말한다. (StudentEx.java에서 선언된 s 나 s2 같은애들)
				return true;
			}
		}
		return false;
	}// end equals()
	 // (명시적/암시적) 형변환

	public static void main(String[] args) {

	}
//	생성자(Constructor)
//	생성자란? 해당 객체가 초기화될떄 실행되는 메소드
//	주로 필드의 초기화를 담당한다.
//	우리가 따로 만들어주지 않아도
//	자바가 기본적으로 제공하는 생성자가
//	필드의 값들을 초기화하는데 
//	필드의 값들을 초기화하는데
//	필드의 데이터타입이 기본형이면 0
//	데이터타입이 참조형이면 null로 초기화된다.

//	그러면 생성자를 만들어봅시다.
//	생성자는 리턴타입이 없다.
	public Student() {
		name = "기본생성자 생성된 이름";
		age = 1;
		kor = 0;
		eng = 0;
		math = 0;
		jumin = "기본생성자가 생성한 주민번호";
	}// 기본생성자가 없으면 null이 생성된다.(StudentEx.java 55라인을 student()주석없이 실행해보면 null인것을 확인할 수
	 // 있다.)

	public Student(String name, int age, int kor, int eng, int math, String jumin) {
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.jumin = jumin;
	}

}
