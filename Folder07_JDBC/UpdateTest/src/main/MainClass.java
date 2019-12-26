package main;

import DB.DBCONNECTON;
import jdbc.UpdateTest;

public class MainClass {
	public static void main(String[] args) {
		DBCONNECTON.initConnection();
		
		UpdateTest ut = new UpdateTest();
		String id = "aaa";
		int age = 23;
		
		boolean b = ut.Update(id, age);
		if(b) {
			System.out.println("성공적 업뎃!");
		}
		
		
		
	}

}
