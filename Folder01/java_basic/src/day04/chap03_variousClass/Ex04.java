package day04.chap03_variousClass;

public class Ex04 {
	public static void main(String[] args) {
		
//		String이란
//		문자열(문자가 여러개 모여있는것)을 뜻한다.
//		String과 char의 차이
//		String은 char들이 모여서 String이 됩니다.
//		char는 문자 1개를 뜻합니다.
		char a = 'a';
		//이코드는 ERROR가 납니다.
		//char b = "abc";		// abc는 여러글자가 모인 문자'열' 이기 때문에 char에 들어갈 수 없다.
		
		//char는 ascii 테이블 기반의 코드값으로 진행되기 때문에
		//아래코드가 가능해진다.
		System.out.println((char)('A'+32));
		System.out.println((char)('A'));
//		왜? ascii 테이블에서 대문자 알파벳과 소문자 알파벳은 32만큼 차이가 있기 때문에
//		대문자 코드값 +32를 하면 소문자 코드값이 나오고
//		그 코드값을 char로 타입케스팅하면 소문자가 출력딘다.
		
		
		//String 객체를 초기화 하는 방법 3가지
		//1. 기본생성자 호출하고 초기화하기 -> 제일 안쓰는방법
		String str = new String();
		str = "abc";
		
		//2.String 객체에 직접 값을 넣는방법
		String str2 = "abcd";
		
		//3. 생성자의 파라미터를 넘겨서 초기화하기
		String str3 = new String("abc");
		
//		String 클래스의 메소드들
//		1. 비교할떄
//		Stringㅇㄴ 클래스이므로 비교연산자를 사용하면 주소값을 비교하게된다.
//		따라서, 우리가 원하는 값비교를 하려면
//		equals() 메소드를 통해서 비교해야 합니다.
		
		System.out.println(str.equals(str3));//각각의 주소에 위치해있는 값비교
		
		System.out.println(str == str3);//각각의 주소값비교
		//두가지는 전혀다르다.
		
//		2. 포함되었는지 확인할때
//		String의 값이 다른 String을 포함하는지 체크할때는
//		Contains 메소드를 사용한다.
//		아래코드는 abcd 안에 abc 가 있는지 확인하므로 TRUE가 나온다.
		System.out.println(str2.contains(str3));
		
//		3. 대소문자 상관없이 비교할떄
//		예를들어 id캡스락 키고 입력해도 정상적으로 인식되는 코드를 작성할때 가능하다.
//		아래코드는 abcd와 ABCD가 대소문자와 무관하게
//		내용이같은지 체크하므로 true가 나온다.
		 System.out.println(str2.equalsIgnoreCase("abcd"));
		 
//		4. 스트링의 길이를 체크할때
//		abcd의 길이(4)를 보고 싶을때에는
//		length()메소드를 사용한다.
		System.out.println(str2.length());
		
//		5. 특정문자열 패턴을 만족하는지 체크할떄
//		matches() 메소드를 사용한다.
//		패턴은 '정규표현식'(Regular Expression or RegEx)를 사용한다.
//		숙제 : 정규표현식 조사
		System.out.println("5.  "+str2.matches("[a-z]"));
//		정규표현식을 사용하면 이메일이 유효한 형태인지 확인가능하다.
		
//		문자열에서 특정문자열을 다른문자열로 바꿀때
//		replace 메소드를 사용한다.
//		아래코드는 abc를 xyc로 변화해준다.
		System.out.println(str.replace("ab", "xy"));
		
//		7. 문자열을 잘라내서 다른 문자열에 저장할때
//		subString을 사용한다.
//		subString은 2가지 파라미터로 오버로딩되어있는데
//		하나는 시작지점~끝까지        abc -> bc
		String subString = str.substring(1);
		System.out.println(subString);
		
		
//		하나는 시작지점~끝지점을 지정해주는 방식
//		str2: abcd
//		1번자리 이후 ~ 3번까지
//		=a 다음부터 c까지 -> bc
		subString = str2.substring(1,3);
		System.out.println(subString);
		
//		8. 모든글자를 소문자로바꿀때
//		toLowerCase 메소드를 실행해준다.
		System.out.println("AbCdEfG".toLowerCase());//abcdefg 전부 소문자로 출력된다.
		
//		9. 모든글자를 대문자로 바꿀때
//		toUpperCase 메소드를 실행해준다.
//		아래코드는 ABCDEFG가 출력된다.
		System.out.println("AbCdEfG".toUpperCase());//ABCDEF 전부 대문자로 출력된다.
		
//		10. String도 toString()이 있다.
//		물론 자기 자신을 리턴한다.
		System.out.println(str.toString());
		
//		11.앞뒤의 공백들을 짤라줄때에는
//		trim 메소드를 사용한다.
		str = "       abcd      ";
		System.out.println(str);
		System.out.println(str.trim());
		
//		12. 기본형 데이터타입들의 값을 string으로 바꿔줄때는
//		valueOf 메소드를 사용한다.
//		단 valueOf메소드는 static 메소드이기 때문에 
//		아래의 코드처름 쓴다.
		
		str = String.valueOf(1234);//기본형데이터타입 전부다된다.(int byed short 등등....)
		System.out.println(str);
		
//		마지막 으로 문자열은 + 연산이 가능하다.
//		+연산의 결과값은 2개를 연결시킨다.
//		문자열+기본형 데이터타입도 기본형 데이터타입을
//		문자열로 변경하고 연결시켜준다.
		
		System.out.println("a"+123);
		
		//    " "  을 사용한다는건 임시로 String 객체를 생성한다는 의미를 가지고 있다. 
		
		
		
		
		
	}//end of main

}//end of class














