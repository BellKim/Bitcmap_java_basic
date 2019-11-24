package day05.chap01;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//collection 마지막
//MAP
public class Ex04 {

	public static void main(String[] args) {
//		맵핑이란
//		그 단어가 몇번나왔는지 카운트
//		I ate hambugers. I love Hamburgers.
//		<I, 2>
//		<ate, 1>
//		<hamburgers, 2>
//		<love, 1>
//		key, value
//		우리가했던 collection 객체들은 polymorphism 을 적용시킬수 있다.
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> treemap = new TreeMap();
		
		map.put("키1번", "벨류1번");
		map.put("키2번", "벨류2번");

		
//		map에 저장된 데이터를 불러올때는 키값으로 불러오게 된다.
		System.out.println(map.get("키1번"));
		System.out.println(map.get("키55번"));
		
		
//		map에 저장을 할때 key는 key set 에 저장된다.
//		즉 중복된 key값은 허용되지 않는다.(덮어씌어진다.)
		
		for(String s : map.keySet()) {
			System.out.println(s);
		}
		
//		만약 우리가 map 키값과 value 값을 전부 출력하고 싶다면?
		for(String s : map.keySet()) {
			System.out.println("key : " + s + " value : " + map.get(s));
		}
		

		
		
		
		
		
		
		
		

	}//main  24
	
}//class
