package work4;

public class homework05 {
	public static void main(String[] args) {
		//1단에서 9단까지 출력하는 프로그램을 작성하여라 
		int i=1;
		while(i<10) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i +" * " + j + " = " + i*j + " " );
			}
		i++;
		if(i==9) break;
		}
		
	}//end main
}//end class
