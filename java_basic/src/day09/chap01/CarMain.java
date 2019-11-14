package day09.chap01;

import java.util.ArrayList;

import com.google.gson.Gson;



public class CarMain {
	public static void main(String[] args) {
		
		Car c = new Car();
		/*
		c.setId(0);
		c.setPlateNumber("00가 0000" );
		c.setType("모닝");
		c.setColor("금색");
		
		Car c2 = new Car();
		c2.setId(1);
		c2.setPlateNumber("22가 2222" );
		c2.setType("스파크");
		c2.setColor("은색");
		
		ArrayList<Car> list = new ArrayList<Car>();
		
		list.add(c);
		list.add(c2);
		
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(list);
		*/
		Gson g = new Gson();
		String json = "{\"id\":0,\"plateNumber\":\"00가 0000\",\"type\":\"모닝\",\"color\":\"금색\"}";
		c = g.fromJson(json,  Car.class);
		
		System.out.println(c.getType());
		
		
		
		
		
		
		
	}//end main

}//end class
