package chap12OOP.classpackage;

import java.util.Scanner;

public class Myclass {
	private int number;
	private String name;
	private double height;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자입력");
		number = sc.nextInt();
		System.out.println("이름입력");
		name = sc.next();
		System.out.println("키 입력");
		height = sc.nextDouble();
	}
	
	void printing() {
		System.out.println("number ;  "+number+" "
				+ "name : "+name +"  height : " + height);
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int newNumber) {
		number = newNumber;
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public double getHeight() {
		return height;
	}
	
	
	
	
}//end of class
