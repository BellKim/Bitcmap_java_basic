package DAO;

import java.util.HashMap;
import java.util.Scanner;

import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;
import SingleTon.singleTonClass;


public class Insert {
	
	
	
	public Insert() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert() {
		HashMap<String, Human> insertHMap;
		Scanner sc = new Scanner(System.in);
		//기존데이터 불러오기
		singleTonClass singlet = singleTonClass.getInstance();
		int MemNumber = singlet.MemNumber;
		
		
		System.out.println(">> 선수등록");
		System.out.println("투수(1)/타자(2) 등록하고 싶은 포지션을 입력해 주십시오.");
		System.out.print(">>>>> ");
		int choice = sc.nextInt();
		
		Human human = null;
		// human
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("나이:");
		int age = sc.nextInt();
		
		System.out.print("신장:");
		double height = sc.nextDouble();
		
		if(choice == 1) {			// pitcher
			System.out.print("승:");
			int win = sc.nextInt();
			
			System.out.print("패:");
			int lose = sc.nextInt();
			
			System.out.print("방어율:");
			double defence = sc.nextDouble();
			
			human = new Pitcher(MemNumber, name, age, height, 
								win, lose, defence);			
		}
		else {						// batter
			System.out.print("타수:");
			int batcount = sc.nextInt();
			
			System.out.print("안타수:");
			int hit = sc.nextInt();
			
			System.out.print("타율:");
			double hitAvg = sc.nextDouble();
			
			human = new Batter(MemNumber + 1000, name, age, height, 
					batcount, hit, hitAvg);
		}
		
//		insertHMap.put(human.getName(), human);
		
		//데이터 singleton 으로 전송하기.
		singlet.hMap.put(human.getName(), human);
		//= insertHMap;
		singlet.MemNumber = MemNumber;
		
		
	}//insert
	

}//end insert class
