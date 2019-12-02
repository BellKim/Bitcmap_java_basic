package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class mainClass {
	public static void main(String[] args) {
		/*
			ArrayList : 검색			== Vector 
			LinkedList : 추가, 삭제(실시간) 으로 이루어 질때 주로 사용. 
		
		*/
		
		Vector<String> vec = new Vector<String>();
		vec.add("라이온즈");
		vec.size();
//		cpp에서 온 vector. 단방향 이라는 의미에서의 백터이다. 
		
		LinkedList<String> list = new LinkedList<String>();
		
//		List<String> list = new LinkedList<String>();
		
		if(list.isEmpty()) {		//리스트가 비어있으면
			System.out.println("데이터가 ㅇ하나도 업슷ㅂ니다.");
//			return; //밑에 함수 안거치도록 할 수 있다.
		}//문구출력.
		
		list.add("Tigers");
		list.add("giants");
		list.add(1, "Lions");
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s.toString());
//			System.out.println(s);
			
		}
		
		//맨 처음요소에 추가하기. (List에는 없는기능이다.)
		list.addFirst("bares");
		
		//맨 끝요소에 추가하기. 
		list.addLast("Twins");
		
		
		System.out.println();
		
		
		for(String string : list) {
			System.out.println(string);
		}
		
		//iterator : 반복자 를 의미. 			반복자 == 포인터(주소값으로접근) 
		//hash map 에서는 매우 중요한 개념이다. 
		Iterator<String> it;		//인터페이스 임폴트 해줘라.
									//String s;
		
		it = list.iterator();//베어즈 들어간 주소값이 저장됨.
		//리스트의 멘 첫번째의 주소값을 가지고 와서 
		//hasNext를 이요해서 다음 주소값으로 이동한다. 추가 삭제가 가능할떄 유리. 검색에서는 ArrayList 가 좋다.
		while(it.hasNext()) {
			String string = it.next();//데이터를 넘겨주면서 다음값을 읽음. 
			System.out.println("hasNext : " + string);
		}
		
		ArrayList<String> arrlist = new ArrayList<String>(list);	//arraylist 를 LinkedList 로 바꿀 수 있따.
																	//검색을 할떄는 어레이리스트로 넘겨주고 쓰면된다.
		for (int i = 0; i < arrlist.size(); i++) {
			System.out.println("arrayList = "+arrlist.get(i));
			
		}
		
		
		
		
		
	}//end main

}//end class
