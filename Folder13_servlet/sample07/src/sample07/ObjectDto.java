package sample07;

import java.io.Serializable;
import java.util.Arrays;

public class ObjectDto implements Serializable{ //시리얼라이즈어블 직렬화 라고 한다. 
	private String name;
	private int age;
	private String fruits[];
	
	public ObjectDto() {
	
	}

	public ObjectDto(String name, int age, String[] fruits) {
		super();
		this.name = name;
		this.age = age;
		this.fruits = fruits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getFruits() {
		return fruits;
	}

	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "ObjectDto [name=" + name + ", age=" + age + ", fruits=" + Arrays.toString(fruits) + "]";
	}
	
	

}
