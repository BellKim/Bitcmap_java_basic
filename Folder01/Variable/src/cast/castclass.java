package cast;

public class castclass {
	public static void main(String[] args) {
		
		System.out.println("hello");
		
		/*
		 	boolean		1byte
		 	
		 	byte		2byte
		 	short		4byte
		 	int			4byte
		 	long		8byte
		 	
		 	float		4byte
		 	double		8byte
		 	
		 	char		2byte
		 	String		?
		 	
		 	자료형변환 (자동, 강제)
		 	
		 	 
		 * */
		
		short sh = 123;		//2byte
		int i;				//4byte
		
		i=sh;				//자동 형변환
		
		sh =  (short) i;	//강제(cast)  형 변환. 
		System.out.println("sh = " + sh);
		
		long l = 12312312312L;
		float f=l;
		
		System.out.println(l);	//12312312312
		System.out.println(f);	//1.23123118E10         E는 승수를 의미한다. 10^10 의미. 
		
		int number;
		double dNumber = 123000.456;//소수점이 남는다. 금액계산시 딱 떨어트려야 할때 double을 int 로 형변환한다. 
		
		number = (int)dNumber;
		System.out.println("number" + number);
		System.out.println("dnumber" + dNumber);
		
		int num1, num2;
		double result;
		num1 = 5;
		num2 = 2;
		
		result = (double)(num1/ num2);	//2.0	5/2해서 2 나온값을 double 해줌.
		result = (double)num1/ num2;	//2.5	double형 5와 int형 2를 나눔.
		
		System.out.println("result = " + result);
		
		//	1.2345e3
		double f1 = 1.2345e3;	// * 10 * 10 * 10
		System.out.println("f1 = " + f1);
		
		f1 = 123.4567e-2; 		// * 0.1 * 0.1
		System.out.println("f1 = " + f1);
		
		
		

		
		
	}//end main

}//end class
