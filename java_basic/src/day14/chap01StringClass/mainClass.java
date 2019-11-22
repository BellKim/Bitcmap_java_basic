package day14.chap01StringClass;

public class mainClass {

	public static void main(String[] args) {

		// String
		// 문자열 저장,편집,정보
		String str; // String == class -> 설계
		// str == Object(객체), instance(주체)
		// [선언방법]
		str = new String(); // case1
		// str : 메모리상 stack영역 속함
		// new String : 메모리상 Heap영역 속함
		str = "hello";
		// str = "hello" == char cArr[] = {'h','e','l','l','o',};
		char cArr[] = { 'h', 'e', 'l', 'l', 'o' };
		String str1 = new String(cArr); // case2
		String str2 = new String("hahahoho");
		System.out.println("str = " + str);
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		// operator +
		String str3 = str1 + str2;
		String str4 = str3 + "java";
		System.out.println("str3 = " + str3);
		System.out.println("str4 = " + str4);
		// 비교함수
		// equals()
		// 문자열 비교시 사용하는 함수
		String str5 = null;
		String str6 = "";
		System.out.println(str5);
		System.out.println(str6);
		str5 = "world";
		str6 = "worl";
		str6 = str6 + "d";
		// (==)
		if (str5 == str6) { // 다른 문자열로 출력됨
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}
		// (equals)
		if (str5.equals(str6) == true) { // 같은 문자열로 출력됨
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}
		// indexOf()
		// 문자열에서 특정 문자가 몇번째 위치에 존재하는지 수치(index값(0부터시작))로 리턴하는 함수
		// 앞에서부터의 순서 (indexOf)
		String str7 = "welcome";
		int n = str7.indexOf("c");
		System.out.println("n = " + n);
		// 뒤에서부터의 순서 (lastIndexOf)
		n = str7.lastIndexOf("c");
		System.out.println("n = " + n);
		// length()
		// 문자열의 총길이 리턴하는 함수
		System.out.println("str7 = " + str7.length());
		// replace()
		// 문자열 수정하는 함수
		String str8 = "A*B*C*D*E*F";
		String repStr = str8.replace("*", " ");
		System.out.println("Str8 = " + str8);
		System.out.println("repStr = " + repStr);

		// substring-> substr
		// 원하는 부분의 문자열만을 산출.
		// substring("시작위치의 index 0~", "지정위치의 전까지") abcde (1,4)

		String str9 = "홍길동-24-17/12/13-서울시";
		String subStr = str9.substring(4, 6);// 4~6가지 불러와라.
		System.out.println(subStr);

		str9 = "abcDEF";

		// toUpperCase
		// toLowCase
		String upStr = str9.toUpperCase();
		String lowStr = str9.toLowerCase();
		System.out.println(upStr + " " + lowStr);

		// trim
		// 공백을 없애주는 함수()
		String str10 = "         java     java     java3	";
		System.out.println(str10);
		System.out.println(str10.trim());
		// 검색을 할때 처음부터 공백을 입력하고 단어를 치는것과, 공백없이 입력하는것과는 전혀 다른단어가된다.
		// trim() 메소드는 이런 상황을 피해주기 위해서 첫 입력공간에 공백을 없애주는 역할을 한다.

		// valueOf
		// 숫자 => 문자열로 변경.
		// 123 -> "123"
		// 123.4567 -> "123.4567"

		int num = 123;
		long lo = 12345L;// 롱 형태에서는 L 을 붙혀야 오류가 안난다.
		double d = 123.4567;

		String iStr = String.valueOf(num);
		String lStr = String.valueOf(lo);
		String dStr = String.valueOf(d);
		System.out.println(" " + iStr + " " + lStr + " " + dStr);

		String _str = num + "";
		System.out.println(_str);

		// contains
		// 탐색
		// 알고리즘 : 정렬, 셔플, 트리, 탐색 => 탐색이 제일 많이 사용하는 알고리즘이다.(검색이라고도한다.)
		String str11 = "서울시 강남구";
		String findstr = "강남";

		boolean b1 = str11.contains(findstr); // contains의 출력값은 블린형.

		System.out.println();
		if (b1) {
			System.out.println("검색한 문자열이 있습니다. ");
		} else {
			System.out.println("검색한 문자열이 없습습니다. ");
		}

		// charAt
		// string 을 배열과 같이 사용할 수 있는 함수.

		char ch = str11.charAt(5);
		System.out.println("ch = " + ch);

		// concat
		String str12 = "안녕하세요";
		String str13 = "반갑습니다.";

		String conStr = str12.concat(str13); // 잘 사용 안한다.
		System.out.println("conStr = " + conStr);//

		String ss = str12 + str13; // 더 편한 방법이 있기때문에.
		System.out.println("ss = " + ss);

	}// end main

}
