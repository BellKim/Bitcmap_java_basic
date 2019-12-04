package DAO;

import java.util.Iterator;
import SingleTon.singleTonClass;

public class showAll {
	
	public showAll() {
		// TODO Auto-generated constructor stub
	}
	
	public void showAll() {
		singleTonClass singlet = singleTonClass.getInstance();
		Iterator<String> it = singlet.hMap.keySet().iterator();
				//.hMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("데이터 출력  : " + key + " value : " +  singlet.hMap.get(key).toString());
		}
		
	}//end showAll()
	
	

}
