package Factory;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.dog;

public class AnimalFactory {
	
	public static Animal create(String animalName) {
		//부모 인터페이스가 리턴값으로 나간다. 
		if(animalName.equals("")) {
			System.out.println("생성할 클래스가 없습니다. ");
		}
		if(animalName.equals("야옹이")) {
			return new Cat();
		}else if(animalName.equals("멍멍이")) {
			return new dog();
		}else if(animalName.equals("황소")) {
			return new Cow();
		}
		return null;
		
	}//end create
	
	

}//end class
