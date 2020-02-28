package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;

public class MainClass {
	
	public static void main(String[] args) {
		
		//Java에서 XML 실행시 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");
		
		Cat mycat = ctx.getBean("myCat", Cat.class);//bean.xml 의 인스턴스값을 넣는다. 
		mycat.catInfo();
		
		System.out.println("1 : "+mycat.getName());
		
		Cat youcat = new Cat("고양이", 2, "검정");
		
		youcat.catInfo();
		
		
		
	}
	
}//end of MainClass
