package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class MainClass {
	public static void main(String[] args) {
		/*
			HashMap : 사전(dictionary) 라고도 한다.
					사과 : apple
					key : value -> 1쌍( pair) 
					WEB에서는 json 으로 가능.
					TREE구조이다. 
					중요 : 중복키값을 사용할 수 없다. //중복키값은 멀티맵이라고 있다.
					
					데이터를 넣을때 마다 구조가 바뀐다. 어느 위치에 들어갈 지 모른다. 
					2진 트리구조이다. 
					0
				   0  0
				 0 0 0 0
				  			TreeMap = HashMap + sorting
				  					sorting -> key
				  					
				  					
				  					
				 
		*/
		
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		//hashmap 은 클래스이다. 
//		map<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(111, "백십일");
		hMap.put(222, "이백이십이");
		hMap.put(333, "삼백삼십일");
		
		//value취득하기. 
		String value = hMap.get(222);
		System.out.println(value);
		
		//검색
		//두종류가있다.
		//1. 있다없다
		//2. 값을 취득

		//1. 있다없다.
		boolean b = hMap.containsKey(new Integer(333));
		System.out.println("있다없다  333 = " + b);
		
		//2. 값을 취득.
		if(hMap.containsKey(333)) {
			value = hMap.get(333);
			System.out.println("hmap 333 값을 취득 ; " + value );
			
		}
		String val = hMap.remove(222);
		System.out.println(val + "값이 삭제 되엇습니다. ");
//		값이 삭제되면 삭제된값에 대해서 리턴해주고 삭제를 진행한다.
		
		//수정.
//		hMap.put(111, "100 + 10 + 1");
		hMap.replace(111, new String("100+10+1+0"));
		
		value = hMap.get(111);
		System.out.println("value = " + value);
//		중복키값.
		
		
		
		//키값을 전부 얻어오는 방법
		//iterator
		Iterator<Integer> it = hMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			// 키값이 넘어온다. 
			System.out.println("\nkey값 : " + key);
			
			String _val = hMap.get(key);
			System.out.println("value : " + _val);
			
			
			
		}
		
		HashMap<String, String> sMap = new HashMap<String, String>();
		//추가
		sMap.put("apple", "사과");
		sMap.put("grape", "포도");
		sMap.put("pineApple", "파인애플");
		sMap.put("banana", "바나나");
		
		
		String _value = sMap.get("grape");
		
		
		//모두출력
		Iterator<String> sKey = sMap.keySet().iterator();
		while(sKey.hasNext()) {
			String key = sKey.next();
			String sval = sMap.get(key);
			System.out.println("key: " + key + " value : " + sval);
		}
		
		
		//정렬, 숫자, 문자 => key
		//treeMap <----> hashMap
		
		TreeMap<String, String> treeMap = new TreeMap<String, String>(sMap);
		//오름차순
		Iterator<String> itkey = treeMap.keySet().iterator();
		System.out.println("오름차순");
		while(itkey.hasNext()){
			String key = itkey.next();
			System.out.println("key : " + key
								+ "value : " + treeMap.get(key));
		}
		
		//내림차순
		Iterator<String> downkey = treeMap.descendingKeySet().iterator();
		System.out.println("오름차순");
		while(downkey.hasNext()){
			String dkey = downkey.next();
			System.out.println("key : " + dkey
								+ "value : " + treeMap.get(dkey));
		}
		
		
		
		
		
		
		
		
	}//end main

}



