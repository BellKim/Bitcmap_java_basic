package parents;

public class parentsClass {
	private int number;
	
	public parentsClass() {//기본생성자 
		System.out.println("parentsClass 의 parentsClass 호출됨. ");
	}
	//부모클래스의 기본생성자를 주석처리하면 자식클래스인 childclass 의 기본생성자에 오류가 생성된다. 
	//childclass 내부에서 왜냐하면 인수가 없는 생성자를 콜하기 때문이다.
	
	public parentsClass(int number) {//기본생성자 
		this.number = number;
		
	}
	
	
	

}//end of class
