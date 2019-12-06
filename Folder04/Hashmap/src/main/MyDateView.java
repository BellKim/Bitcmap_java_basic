package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class MyDateView {

	public static void main(String[] args) {
		HashMap<Integer, MyData> dataMap = new HashMap<Integer, MyData>();
		// 추가
		MyData md1 = new MyData(001, "가");
		MyData md2 = new MyData(002, "나");
		MyData md3 = new MyData(003, "다");
		MyData md4 = new MyData(004, "라");
		
		dataMap.put(001, md1);
		dataMap.put(002, md2);
		dataMap.put(003, md3);
		dataMap.put(004, md4);

		// 삭제
		boolean b = dataMap.containsKey(new Integer(002));
		System.out.println("있나? : " + b);
		if(b = true ) {
			MyData val = dataMap.remove(002);
			System.out.println("삭제된값   : " + val);
		}
		
		
		//전부출력
		Iterator<Integer> it = dataMap.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println("전부출력 value = " + key+ " " + dataMap.get(key).toString() );
		}
		

		// 검색
		boolean search = dataMap.containsKey(new Integer(002));
		System.out.println("002검색입니다.? : " + search);

		// 수정
		boolean modify = dataMap.containsKey(new Integer(003));
		if(modify == true) {
			MyData modifyData = new MyData(23, "이삼");
			dataMap.replace(003, modifyData);
		}
		//수정결과 출력
		MyData dataprint = dataMap.get(003);
		System.out.println("t수정결과 003 : " + dataprint);
		

		

		// 정렬
		TreeMap<Integer, MyData> mdata 
							= new TreeMap<Integer, MyData>(dataMap);
		Iterator<Integer> itkey = mdata.keySet().iterator();
		while(itkey.hasNext()){
			Integer key = itkey.next();
			System.out.println("정렬 ::: key : " + key
				+ "value : " + mdata.get(key).getNumber() 
				+ " " + mdata.get(key).getName());
		}
		
		
		
		
		
		

	}// end main

}// end class
