package DAO;

import java.util.HashMap;
import java.util.Scanner;

import DTO.BatterDTO;
import DTO.HumanDTO;
import DTO.PitcherDTO;

public class bbDAO {

	public HashMap<Integer, HumanDTO> list = new HashMap<Integer, HumanDTO>();

	public bbDAO() {
		baseData();
	}

	private void baseData() {
		PitcherDTO pdto = new PitcherDTO();
		pdto.setNumber(1000);
		pdto.setName("김가나");
		pdto.setAge(20);
		pdto.setHeight(180);
		pdto.setWin(3);
		pdto.setLose(3);
		pdto.setRatio(0);

		BatterDTO bdto = new BatterDTO();
		bdto.setNumber(2000);
		bdto.setName("김배터");
		bdto.setAge(22);
		bdto.setHeight(175);
		bdto.setBatCount(10);
		bdto.setHitCount(5);
		bdto.setBatAvg(50.0);

		list.put(1, pdto);
		list.put(2, bdto);
	}

	public void showAll() {
//		System.out.println("listsize "+list.size());
		
		
		
//		((PitcherDTO)(list.get(1))).getAge();
		System.out.println("pitcher 정보 총 ");
		for (int i = 1; i <= list.size(); i++) {
			if(list.get(i) instanceof PitcherDTO) {
				System.out.println("Pitcher정보");
				System.out.println(list.get(i).getNumber()+
						" "+list.get(i).getName()+
						" "+list.get(i).getAge()+
						" "+list.get(i).getHeight());
				System.out.println(list.get(i).toString()+"");
				
				
			}
		}
		System.out.println("\n\n");
		for (int i = 1; i <= list.size(); i++) {
			if(list.get(i) instanceof BatterDTO) {
				System.out.println("Batter정보");
				System.out.println(list.get(i).getNumber()+
						" "+list.get(i).getName()+
						" "+list.get(i).getAge()+
						" "+list.get(i).getHeight());
				System.out.println(list.get(i).toString());
			}
		}
		
		
	}
	public int searchLastHumanNo(int select) {
		//1이면 pitcher, 2면 batter의 선수 번호를 출력한다.
		int pitcherCount=0;
		int batterCount=0;
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) instanceof PitcherDTO) {
				pitcherCount++;
			}else if(list.get(i) instanceof BatterDTO){
				batterCount++;
			}else {
				System.out.println(" error ");
			}
		}
		
		if(select == 1) {
			return pitcherCount+1000;
		}else {
			return batterCount+2000;
		}

	}//end searchLastHumanNo 
	
	
	public void insert(int choice) {
		
		Scanner sc = new Scanner(System.in);
		
		if(choice == 1) {
			int number =searchLastHumanNo(choice);
			System.out.println("number : " + number + "로 등록합니다.");	//1000번대 pitcher 2000번대 batter
			System.out.println("name");
			String name=sc.next();
			System.out.println("age");
			int age = sc.nextInt();
			System.out.println("height");
			int height = sc.nextInt();
			System.out.println("win");
			int win = sc.nextInt();
			System.out.println("lose");
			int lose = sc.nextInt();
			System.out.println("ratio");
			double ratio = sc.nextInt();


			PitcherDTO pdto = new PitcherDTO(number, name, age, height, win, lose, ratio);
			list.put((list.size()+1), pdto);
			
		}else{
			int number =searchLastHumanNo(choice);
			System.out.println("number : " + number + "로 등록합니다.");	//1000번대 pitcher 2000번대 batter
			System.out.println("name");
			String name=sc.next();
			System.out.println("age");
			int age = sc.nextInt();
			System.out.println("height");
			int height = sc.nextInt();
			System.out.println("win");
			int batCount = sc.nextInt();
			System.out.println("lose");
			int hitCount = sc.nextInt();
			System.out.println("ratio");
			double batAvg = sc.nextInt();


			BatterDTO pbto = new BatterDTO(number, name, age, height, batCount, 
																	hitCount, batAvg);
			list.put((list.size()+1), pbto);

			
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// end of class
