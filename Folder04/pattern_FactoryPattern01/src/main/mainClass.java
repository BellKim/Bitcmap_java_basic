package main;

import java.util.ArrayList;
import java.util.List;

import Factory.AnimalFactory;
import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.dog;

public class mainClass {

	public static void main(String[] args) {
/*
		singleton Pattern
			중심이 되는 데이터관리 template(list, map)을 중심으로
			어디서나 접근이 용이하게 하기 위한 패턴이다. 
			instance는 한개. 
			
		Factory pattern : 공장
			원하는 클래스의 형태를 생성하기 용이하다. 
			
		interface, class 동물
		
		class 고양이, 멍멍이, 황소
		
		Animal a = 


 */
		
		List<Animal> list = new ArrayList<Animal>();
		
		
		Animal ani1 = AnimalFactory.create("멍멍이");
//		ani1.printDescript();
		list.add(ani1);
		ani1 = AnimalFactory.create("야옹이");
//		ani1.printDescript();
		list.add(ani1);
		ani1 = AnimalFactory.create("황소");
//		ani1.printDescript();
		list.add(ani1);
		
		for (int i = 0; i < list.size(); i++) {
			Animal a = list.get(i);
			a.printDescript();
		
			if(a instanceof Cat) {
				((Cat)a).catMethod();
			}else if(a instanceof dog) {
				((dog)a).dogMethod();
			}else if(a instanceof Cow) {
				((Cow)a).cowMethod();
			}
			System.out.println();
		}
		

	}//end main 

}//end calss
