package main;

import jdbc.JdbcTest;

public class MainClass {
	public static void main(String[] args) {
		JdbcTest jt = new JdbcTest();
		
		int count = jt.Insert("aaa", "김초코", 21);
		if(count>0) {
			System.out.println("정상적으로 추가되었습니다. ");
		}
		
		
		
		
	}

}
