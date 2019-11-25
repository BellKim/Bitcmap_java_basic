package chap07Function.Exercise;

public class exercise04 {

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까 ?" + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까 ?" + isNumber(str));
		str = "";
		System.out.println(str + "는 숫자입니까 ?" + isNumber(str));
		

	}// end main

	static boolean isNumber(String str) {
		int stringCount=0;
		for (int i = 0; i < str.length(); i++) {
			System.out.print("isNumber : "+str.charAt(i) + " ");
			if (str.charAt(i) > 47 && str.charAt(i) < 57) {// 48~57 숫자일경우
				stringCount++;
			}
		}
		
		if((stringCount == str.length()) && str.length()!=0 ) {
			return true;
		}else {
			return false;
		}
		
		
		
	}// end isNumber

}// end class
