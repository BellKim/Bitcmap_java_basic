package main;

import bcls.MyClass;
import bcls.YouClass;
import ccls.HeClass;
/*
		Singleton pattern
		단 1개의 instance만을 이용해서 접근하는 패턴
 */
public class MainClass {
	public static void main(String[] args) {

		YouClass ycls= new YouClass();
		MyClass mcls = new MyClass();
		ycls.method();
		mcls.fromyou();
		
//		ycls.setYouNum(6);
//		ycls.method();
	
		HeClass hcls = new HeClass();
		
		mcls.MyMethod();
		
		
	
	}
}
