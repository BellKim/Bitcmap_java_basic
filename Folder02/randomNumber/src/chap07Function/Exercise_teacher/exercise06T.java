package chap07Function.Exercise_teacher;

public class exercise06T {
	// abcdefghijklmnopqrstuvwxyz //a-z 26개, //97이상-122이하 --> 암호문자 입력시(인코드) 해당문자 -
	// 97 = abcCode의 배열번호
	static char[] abcCode = // abc문자열 입력시 (디코드) 해당문자 +97의 계산값이 배열번호
			{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']', '{', '}',
					';', ':', ',', '.', '/' };

	// 0 1 2 3 4 5 6 7 8 9 //10개 48이상 57이하 --> qwer암호문자 입력시 해당문자 배열번호 -48 한 아스키코드값
	// 문자 저장하기
	static char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' }; // --> 01234입력시 아스키코드 +48한 값의 numcode
																					// 배열번호 문자 저장.

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

//		for (char a : deciphering("`~!@#$%^&*()-_+=|[]{};:,./")) {
//			System.out.print(a + "");
//		}
//
//		System.out.println();
//
//		for (char a : deciphering("qwertyuiop")) {
//			System.out.print(a + "");
//		}
		
		String src = "abc0012";
		String setCode = " ";
//		 = encodeString(src);
		

	}

	/**
	 * method encodeString
	 * 
	 * @param a, String
	 * @return char[] content : 일반 문자를 안호화하여 리턴함.
	 */

	static String encodeString(String src) {
		String resultCode = "";
		// 처움부터 포문 돌리지 말고 한글자씩 알아보고 하자 제발.
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(0);
			int n = (int) ch;
			// case1 알파벳일경우
			if (n >= 97 && n <= 122) {
				n = n - 97;
				resultCode = resultCode + abcCode[n];
			
			}
			// case2 숫자인경우
			// if(n>=48 && n<=57) {
			else {// else로 가능.
				n = n - 48;
				resultCode = resultCode + abcCode[n];
			}

		}

		return resultCode;
	}

	static String deciphering(String src) {
		String oriStr = " ";
		
		for (int j = 0; j < abcCode.length; j++) {
			
		
		char c = src.charAt(j);
		int n = (int)c;
		int index = 0;
		if(n >= 97 && n<= 122) {//숫자
			for (int i = 0; i < numCode.length; i++) {
				if(c == numCode[i]) {
					index = i;
					break;
				}
			}
			index = index + 48;
			oriStr = oriStr + index;
			
		}else { //알파벳
			
			for (int i = 0; i < abcCode.length; i++) {
				if(c == abcCode[i]) {
					index = i;
					break;
				}
			}
			index = index + 97;
			oriStr = oriStr + index;
		}
		
		}
		return oriStr;
		
		
		
		
		
		
		
	}

}
