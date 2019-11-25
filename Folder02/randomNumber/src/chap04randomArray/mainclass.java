package chap04randomArray;

public class mainclass {
	public static void main(String[] args) {
		
		/*
		//셔플 첫번째방법. (생각보다 반복문이 많이들어가서 효율이 좋은편은아니다)
		int number[] = new int[10]; //1~10
		
		//전체초기화
		for (int i = 0; i < number.length; i++) {
			number[i] = i+1;
		}
		
		//swap으로 셔플
		int temp; //swap 을 위한 대기변수.
		for (int i = 0; i < 1000; i++) {
			int a = (int)(Math.random()*10);//0~9까지 나옴
			int b = (int)(Math.random()*10);//0~9까지 나옴
			
			temp = number[a];
			number[a] = number[b];
			number[b] = temp;
		}
		
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + "  ");
		}
//		System.out.println();
	*/
		
		
		//2번째방법
		final int NUM= 10;
		int number[] = new int[NUM];//입력을 받아서 갯수가 정해져 있을때만 사용한다.
		boolean _switch[] = new boolean[NUM];
		int w, r;
		
		for (int i = 0; i < _switch.length; i++) {//같은 반복문을 돌려도 자료형이 작은 반복문을 돌리는게 더 효율적이다.
			_switch[i] = false;
		}//스위치 전부 false 로 초기화 한다.
		
		w=0;//초기화 하는경우에는 필요한곳에 그때그때 초기화 해주는 것이 중요하다.
		while(w<NUM) {
			r= (int)(Math.random()*NUM);//0~9
			if(_switch[r] == false) {
				_switch[r] = true;
				number[w] = r+1; //0~9 숫자를 +1 해서 1~10까지의 숫자를 표현한다.
				w++;
			}
		}
		
		for(int i=0; i<number.length; i++) {
			System.out.println(number[i] + " ");
			
		}
		System.out.println();
		

		
	}//end amin

}//end calss
