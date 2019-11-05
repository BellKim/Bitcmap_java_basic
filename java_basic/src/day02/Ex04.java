package day02;

import java.util.ArrayList;

//배열
//배열이란 같은 데이터 타입이 모여있는것.

public class Ex04 {

	public static void main(String[] args) {
//		배열 선언하기
//		데이터타입[] 배열이름 = new 데이터타입[크기]
		int[] arr = new int[5];
		
//		배열의 각요소를 접근할때에는
//		배열이름[인덱스번호]로 접근한다.
//		인덱스번호는 0~크기 -1까지이다.
		
		arr[0] = 5;
		arr[1] = 10;
		arr[2] = 15;
		arr[3] = 20;
		arr[4] = 25;
//		arr[5] = 30;
		
		for(int i=0; i<5;i++)System.out.println(arr[i]);
		
		for(int i : arr) System.out.println(i);
		
//		배열의 단점 1번
//		안의 요소가 어떻게 있는지 확인하기 어렵다
//		예를들어 arr중 어디가 값이 안들어가있는지 찾으려면 모든 요소를 다 봐야한다.
		System.out.println(arr.length);
//		arr.length를 찍어보면 내가 무슨값을 넣어도 
//		항상 배열의 총 크기인 5만 나오게된다.
		
//		배열의단점 2번
//		크기가 고정이다
//		배열의 크기보다 작은 용량을 쓰면 큰 문제가 없어보이지만
//		배열의크기보다 더큰 용량을 쓰려고 하면?
		int[] temp = new int [5];
		for(int i=0; i<5; i++) {
			temp[i] = arr[i];
		}
		arr = new int [10];
		for(int i=0; i<temp.length; i++) {
			arr[i] = temp[i];
		}
		
//		배열의 단점 3번
//		정렬이 어렵다
//		정렬도 위의 단계를 거쳐서 하나씩 정렬해줘야한다.
		
//		배열의 단점 4번 
//		내가 원하는 값을 찾기도 어렵다.
		
//		그런 단점들을 해결한것이
//		List인터페이스를 상속받는 클래스들이다.
//		가장대표적인 클래스로는 ArrayList가 있다.
		System.out.println("==========================");
//		arraylist는!
//		template를 통해 어떤 클래스만 들어올수 있기 때문에 
//		기본형 데이터타입들은 wrapper class로 감싸서 넣어주게 된다.(Integer 클래스)
		ArrayList<Integer> list = new ArrayList<>();
		
//		ArratLIst에 값을 추가할때: 
//		add method 를 사용한다.
		Integer i = 5;
		list.add(i);
		Integer i2 = 10;
		list.add(i2);
		Integer i3 = 100;
		//특정위치에 객체를 추가해줄때는 add(위치의 인덱스번호, 객체) 로 추가해준다.
		list.add(1,i3);
		list.remove(0);//5사라짐.
		list.remove(i3);//10사라짐. 
		for(Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("==========================");		
//		indexof 메소드는 
//		모든 요소에 대해 equals()메소드를 실행해서
//		첫번째로 true가 나오는 index 번호를 리턴한다.
		System.out.println(list.indexOf(10));//맨 앞에 있다는 뜻이다.
		//만약 없는 객체를 indexOf 에 넣으면?
		System.out.println(list.indexOf(i3)); //-1이 나오게된다:오류
		
//		해당리스트에 객체가 있는지 확일할 때에는
//		contains메소드를 실행한다.
//		만약 있으면 true가 나오고 없으면 false가 나온다.
		System.out.println("i3 입력시"+list.contains(i3));
		System.out.println("10 입력시 "+list.contains(10));
		
//		리스트의 모든 내용을 삭제할 때에는 clear()를 사용한다.
		list.clear();
		
		
		for(Integer integer : list) {
			System.out.println(integer);
		}
	
	
	}//end of main

}//end of class
