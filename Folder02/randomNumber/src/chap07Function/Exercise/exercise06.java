package chap07Function.Exercise;

public class exercise06 {
	// abcdefghijklmnopqrstuvwxyz			//a-z 26개, //97이상-122이하	--> 암호문자 입력시(인코드) 해당문자 - 97 = abcCode의 배열번호
	static char[] abcCode =											//			abc문자열 입력시 (디코드) 해당문자 +97의 계산값이 배열번호
	{ '`','~','!','@','#','$','%','^','&','*',
	'(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/'};	
	
	// 0 1 2 3 4 5 6 7 8 9					//10개 48이상 57이하			--> qwer암호문자 입력시 해당문자 배열번호 -48 한 아스키코드값 문자 저장하기
	static char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};		//	--> 01234입력시  아스키코드 +48한 값의 numcode 배열번호 문자 저장. 


	public static void main(String[] args) {
////		System.out.println("문자인코딩");
//		for(char a:encodeString("abcdefghijklmnopqrstuvwxyz")) {
//			System.out.print(a + "");
//		}
//		System.out.println();
////		System.out.println("숫자인코딩 ");
//		for(char a:encodeString("0123456789")) {
//			System.out.print(a + "");
//		}
		
		
		for(char a:decodeString("`~!@#$%^&*()-_+=|[]{};:,./")) {
			System.out.print(a + "");
		}
		
		System.out.println();
		
		for(char a:decodeString("qwertyuiop")) {
			System.out.print(a + "");
		}
		
		

	}
	

	
	static char[] decodeString(String a) {
	char []res = new char[a.length()];
	for (int i = 0; i < a.length(); i++) {
		
		if(abcCode[i] == (char)(a.charAt(i))) {
			res[i] += (char)(i+97);
		} else if(numCode[i] == (char)(a.charAt(i))) {
			res[i] += (char)(i+48);
		}
	}
	
		
		return res;
	}
	
	static char[] encodeString(String a) {
	char []res= new char[a.length()];	
	for (int i = 0; i < a.length(); i++) {
		if(a.charAt(i)>=97 && a.charAt(i)<=122) {
 
//			System.out.println("함수값 : "+ (a.charAt(i)-97));
			res[i]= abcCode[(int)(a.charAt(i)-97)];
		}
		if(a.charAt(i)>=48 && a.charAt(i)<=57) {

			res[i]= numCode[(int)(a.charAt(i)-48)];
		}
	}
		
		return res;
	}
	
	

}
