package day01;
//반복문
//for loop
public class Ex06 {

	public static void main(String[] args) {
		//for loop: 명혹하게 끝이 있을때 사용.
		for(int i = 0; i<5; i++) {
			System.out.println("i: " + i);
		}
		
//		배열이나 collection 등 무언가 '모여' 있는 것을
//		출력할 때는 for each (향상된 for loop) 을 사용하게 된다.
		
		int[] arr = new int [5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 8;
		arr[4] = 16;
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr[" + (i+1)+"]: " + arr[i]);
		}//구식방법의 출력방식.
		
		for(int i : arr) {
			System.out.println(i);
		}//요즘방식
		
		
		
		
		
		
		
		
		

	}//end of main

}//end of class
