package mmMain;

import mm01.mm01;
import mm01.mm01DTO;
import mm02.mm02;

public class main {

	public static void main(String[] args) {
		mm01 m1 = new mm01();
		mm02 m2 = new mm02();
		m1.passToM2();
//		m2.receiveData();
		//하나의 인스턴스에 접근하기 위함이다. 
		

	}//end main

}//end class
