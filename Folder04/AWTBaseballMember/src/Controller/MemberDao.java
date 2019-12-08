package Controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;
import file.DataClass;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	private HashMap<String, Human> map;
	
	private int MemNumber;	// sequence number 관리 변수
	
	DataClass dataCls;
	
	public MemberDao() {
		
		dataCls = new DataClass("baseball");
		dataCls.createfile();
		
		map = dataCls.readFile();		
		MemNumber = 1000;
		
		// sequence number 산출
	//	if(!map.isEmpty()) {
		if(map.size() > 0) {
			
			Iterator<String> it = map.keySet().iterator();
			
			int lastNum = 0;
			while(it.hasNext()) {
				String key = it.next();
				Human h = map.get(key);
				
				int lastMemNum = h.getNumber();
				
				if(lastMemNum >= 2000) {	// 2000이상의 경우 -1000을 해준다
					lastMemNum = lastMemNum - 1000;
				}
				
				if(lastNum < lastMemNum) {
					lastNum = lastMemNum;
				}
			}
			MemNumber = lastNum + 1;			
		}
		
	}
	
	public void insert() {
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
		
		// map에 추가
		map.put(human.getName(), human);
		
		MemNumber++;
	}
	
	public void delete() {
		System.out.println("방출하고 싶은 선수명을 입력해 주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		
		Human h = null;
		h = map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		h = map.remove(name);
		System.out.println(h.getName() + "선수의 데이터가 삭제되었습니다");		
	}
	
	public void select() {
		System.out.println("검색하고 싶은 선수명을 입력해 주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		
		Human h = null;
		h = map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.println("검색된 선수입니다.");
		h.infomation();
	}
	
	public void update() {
		System.out.println("수정하고 싶은 선수명을 입력해 주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		
		Human h = null;
		h = map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.println("수정할 데이터를 입력해 주십시오.");
		if(h.getNumber() < 2000) {	// 투수
			Pitcher p = (Pitcher)h;
			System.out.print("승:");
			int win = sc.nextInt();
			
			System.out.print("패:");
			int lose = sc.nextInt();
			
			System.out.print("방어율:");
			int defence = sc.nextInt();
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);			
			
		}else {						// 타자
			Batter b = (Batter)h;
			
			System.out.print("타수:");
			int batcount = sc.nextInt();
			
			System.out.print("안타:");
			int hit = sc.nextInt();
			
			System.out.print("타율:");
			int hitAvg = sc.nextInt();
			
			b.setBatcount(batcount);
			b.setHit(hit);
			b.setHitAvg(hitAvg);			
		}		
		System.out.println("데이터를 수정하였습니다");
	}
	
	public void allprint() {
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Human h = map.get(key);
			System.out.println(h.toString());
		}
	}
	
	public void memberSort() {
		HashMap<String, Human> hashMap = new HashMap<String, Human>();
		
		Iterator<String> it = map.keySet().iterator();
		int w = 0;	// 같은 키 값이 들어 가지 않도록 할 변수
		while(it.hasNext()) {			
			String key = it.next();
			Human h = map.get(key);
			if(h instanceof Pitcher) {
				Pitcher p = (Pitcher)h;
				hashMap.put(p.getDefence() + "" + w, p);
				w++;
			}
		}
		
		TreeMap<String, Human> tMap = new TreeMap<String, Human>(hashMap);
		
		Iterator<String> updownIt = tMap.keySet().iterator();
		while (updownIt.hasNext()) {
			String key = updownIt.next();
			System.out.print("key:" + key + " ");
			Human h = tMap.get(key);
			System.out.println(h.toString());
		}
		
		
	}
	
	public void saveData() {
		String arrStr[] = new String[map.size()];		
		int w = 0;
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Human h = map.get(key);
			arrStr[w] = h.toString();
			w++;
		}
		
		dataCls.writeFile(arrStr);		
	}
	
}






