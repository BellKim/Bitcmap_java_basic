

class Accumulator{
	static int num1=0;
	
	static void add(int i) {
		num1 += i;
		
	}
	
	static void showResult() {
		if(num1 >=45)
		System.out.println(""+ num1);
		
	}
	
	
	
	
	
}//end accumulator


public class day16 {
	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Accumulator.add(i);
			Accumulator.showResult();
		}
		
		
		
		
	}//end main

}//end class
