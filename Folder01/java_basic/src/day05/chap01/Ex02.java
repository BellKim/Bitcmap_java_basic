package day05.chap01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex02 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		
		while(list.size() < 6) {
			Integer randomNumber = random.nextInt(45)+1;
			if(!list.contains(randomNumber)){//리스트가 랜덤넘버가 없을때 실행.
				list.add(randomNumber);
			}
		}
		
		System.out.println("정렬하기전");
		for(int i : list) {
			System.out.println(i);
		}
		System.out.println("오름차 정렬후");
		Collections.sort(list);
		for(int i:list) {
			System.out.println(i);
		}
		System.out.println("오름차 정렬후 reverse");
		Collections.sort(list);
		Collections.reverse(list);
		
		for(int i:list) {
			System.out.println(i);
		}
		
		

	}//end main

}//end of classs
