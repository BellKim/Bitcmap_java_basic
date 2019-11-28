package chap14StaticClass01;

public class mainClass {

	public static void main(String[] args) {
		MyClass cls1 = new MyClass();
		//instance 생성 . 설계된 클레스의 형태. 객체의 변수를 인스턴스라한다.?
		cls1 = new MyClass(12);
		
		
		mainClass mcls = new mainClass();
		mcls.func();
		
		
		
		

	}//end main
	
	public void func() {
		System.out.println("mainCLass func()");
	}

}//end class
