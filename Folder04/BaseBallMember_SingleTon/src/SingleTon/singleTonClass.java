package SingleTon;

import java.util.HashMap;

import DTO.Human;


public class singleTonClass {
	private static singleTonClass single = null;
	//변수선언부
	
	public HashMap<String, Human> hMap;
	public int MemNumber;
	
	
	private singleTonClass() {
		System.out.println("singleton start");
		hMap = new HashMap<String, Human>();
	
	}
	
	public static singleTonClass getInstance() {
		if(single == null) {
			single = new singleTonClass();
		}
		return single;
	}//end getInstance();
	
	
	
	
	

}//end class
