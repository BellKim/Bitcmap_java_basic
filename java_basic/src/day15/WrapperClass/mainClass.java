package day15.WrapperClass;

public class mainClass {
	public static void main(String[] args) {
		/*
		   Wrapper Class
		   일반 자료형을 클래스화 해 놓은 것이다. 
		   
		   일반자료형			Wrapper class
		  boolean			Boolean
		  char				Character
		  
		  byte				Byte
		  short				Short
		  int				Integer		===================중요==========================
		  long				Long
		  
		  float				Float
		  double			Double		================중요==========================
		  
		  char[]			String
		  		length			length()  <- 함수이다.
		  						toString()  <-함수
		  						valueOf()

		  Stromg str = "hello";
		  Stsrem.outt.println(str);
		  Stsrem.outt.println(str.toString);
		  
		  number -> String
		  
		  valueOf('a') -> 'a' 		a\0
		  valueOf( 1 ) -> "1" 
		  valueOf(123.456) -> "123.456"
		  float f = 12.34f;
		  str = f + "";  
		        
		 */
		
		Character ch1; //클래스의 인스턴스
//		ch1 = new Character('A');	//character는 하나의 문자열만 입력 가능하다.
		ch1 = 'B';
		System.out.println("ch1 = "+ch1);
		
		Character ch2 = new Character('B');
		
//		String str = ch1 + ch2 + "";// 아스키코드의 합
		//아스키코드로 처리된 후에 문자열로 바뀌느냐
		String str = "" + ch1 + ch2;// 문자열의합
		//""로 문자열 처리를 한 뒤에 ch1, ch2 가 처리가되느냐 차이.
//		온전히 그냥 출력을 하고싶다면
//		String str = ch1.toString() + ch2.toString();//
		//으로 작성할것. 
		
		System.out.println("str = " + str + "ㅇㅇㅇㅇㅇㅇㅇㅇㅇ" );
		
//		if(ch1 == ch2) {//문자열 비교는 == 가 아닌 .equals()해야한다.
		if(ch1.equals(ch2)) {//문자열 비교는 == 가 아닌 .equals()해야한다.
			System.out.println("ch1과 ch2 는 같은 문자입니다. ");
		}else {
			System.out.println("ch1과 ch2 는 다른 문자입니다.");
		}
		
		//Integer == int 
		int i  = 25;
		Integer iObj; 
//		iObj =  new Integer(i);
		iObj =  36;
		System.out.println("integer 의 iobj = "+iObj);
		//숫자 -> 문자열 		String.valueOf(i)
		String is = iObj.toString();//무조건 String 으로 넘어간다. 
						// is의 데이터 36은 숫자가 아닌 문자열로 바뀐다.
		System.out.println("toString 적용한 is  = " + is);
		
		
		//문자열 -> 숫자
		String str1 = "123";
		int num = Integer.parseInt(str1);
		System.out.println("string -> parse int num : " + num);
		
		String str2 = "234.5678";
		double d1 = Double.parseDouble(str2);
		System.out.println("d1 = " +   d1);
		
		//10진수 -> 2진수
		//int 		String
		int number = 12;
		String num2str = Integer.toBinaryString(number);
		System.out.println("change number to binary = " + num2str);
		
		//2진수 -> 10진수
		int binary2decemal = Integer.parseInt(num2str,2);
		System.out.println("binary to decemal = "+ binary2decemal);
		
		//10진수 -> 16진수
		//int		String
		String decemaltohex = Integer.toHexString(number);
		System.out.println("decemal to hex value = " + decemaltohex);
		
		//16진수 -> 10진수
//		Integer.parseInt(num2str,16);
		System.out.println("Hex to decemal = " + Integer.parseInt(num2str,16));
		
		

	}//end main
}//end class






