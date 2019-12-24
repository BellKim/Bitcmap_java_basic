package main;

import jdbc.JdbcTest;

public class MainClass {
	public static void main(String[] args) {
		JdbcTest jt = new JdbcTest();
		String id = "aaa";
		int count = 0;
//		count = jt.Delete(id);
//		if(count>0) {
//			System.out.println("성공적으로 삭제하였습니다. ");
//		}
		
		id = "aaa";
		int age = 11; 
		count = jt.Update(id, age);
		if(count>0) {
			System.out.println("성공적으로 업데이트였습니다. ");
		}
		
		
		
		
	}

}
