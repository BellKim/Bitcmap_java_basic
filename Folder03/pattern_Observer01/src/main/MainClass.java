package main;

import cls.MyClass;
import observer.ObserverA;
import observer.ObserverB;

public class MainClass {

	public static void main(String[] args) {
		/*
			Observer : 정찰 -> 감시
			
		*/
		
		MyClass cls = new MyClass();
		
		
		//감시자 A와 B 를 추가한다.
		cls.addObserver(new ObserverA());
		cls.addObserver(new ObserverB());
		
		cls.notifyObservers("password : abc123");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//end main

}//end class
