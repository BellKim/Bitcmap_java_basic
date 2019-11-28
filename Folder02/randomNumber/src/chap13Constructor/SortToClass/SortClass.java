package chap13Constructor.SortToClass;

import java.util.Scanner;

public class SortClass {
	// 변수선언
	String strNum[];
	int number[];
	
	
	public SortClass() {
		strNum = null;
		number = null;
	}
	
	
	
	
	//입력(갯수입력, 반복하여 갯수까지 입력하기)
	public void input(String[] strNum) {
		Scanner sc = new Scanner(System.in);
		int count;
//		input 입력부
		System.out.println("몇개의 숫자를 입력하시겟습니까 ");
		count = sc.nextInt();
		//allocation(할당)
		strNum = new String[count];
		//정렬할 숫자들을 입력
		boolean ok = true;
		int w = 0;
		while (w<strNum.length) {
			ok = true;
//			몇개를 정렬하시겠습니까
//			동적할당
//			숫자를 갯수에 맞게 입력받느다
			System.out.println((w+1)+" 번째 수 = ");
			strNum[w] = sc.next();  // 123
			//정상적으로 숫자를 입력했는지 확인 1, 2, 3, .....
//			여기서의 for문은 사실 함수로 빼야되는부분이다.
			for (int i = 0; i < strNum[w].length(); i++) {
//				strNum.length 은 하나의 문자?
				int n = strNum[w].charAt(i);
				if(n<48 || n>57) {//숫자범위가 아닌것을 체크한다.
					System.out.println("n 값 : ");
					ok=false;
					break;
				}
			}
			if(ok == false) {	//문자가 있을 시에
				System.out.println("잘못입력하셧습니다. 다시입력하세요.");
				continue;
			}
			w++;
		
		}
		this.strNum=strNum;
		
		
	}//end input()
	
	public int[] sortData(String[] strNum) {
		Scanner sc = new Scanner(System.in);
		boolean updown;
//		올림(1)/내림(2)
		
		for(String n : strNum) {
			System.out.println(n);
		}
		
		
		System.out.println("올림(1) // 내림(2)");
		int ud = sc.nextInt();
		if(ud == 1) updown = true;
		else		updown = false;
		/////////////////////////////////////
		//sorting
		//숫자로 변환해 줄 배열
		
		int number[] = new int[strNum.length];
		
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);
		}
		for(int n : number) {
			System.out.println("소트데이터 넘버값 "+n);
		}
		
		int temp;
		for (int i = 0; i < number.length-1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(updown == true) {
					if(number[i] < number[j]) {//오름차순
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}else if(number[i] > number[j]) {//내림차순
							temp = number[i];
							number[i] = number[j];
							number[j] = temp;
						}
					}
				}
			}
		
		for(int a : number) {
			System.out.println("데이터 출력 직전 number ; "+a);
		}
		return number;
		
	}//end sortData();
	
	
	public void loop() {
		while(true) {
			
			input(strNum);
			
			number = sortData(strNum);
			
			ResultAll(number);
			
			
		}//end while()
	}//end loop()




	public void afterSortingData(int[] number2) {
		for(int n : number2) {
			System.out.println("소팅후 데이터  "+n + " ");
		}
	}//end afterSortingData




	public void ResultAll(int[] number2) {
		System.out.println("넘버길이" + number2.length);
		for(int n : number2) {
			System.out.println("리절트 넘버값 "+n);
		}
		
		
		
		for (int i = 0; i < number2.length; i++) {
			System.out.println("number2"+ i+1 + ": " + number2[i]);
		}
		
	}




	
	
	
	

}//end of class
