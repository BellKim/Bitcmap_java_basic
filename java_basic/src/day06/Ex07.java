package day06;

public class Ex07 {
		/*
		 * printf는 다양한 %문자를 써서
		 * 해당 데이터타입의 변수를 형식(format)에 맞추어서 출력한다.
		 * 
		 * %d: 10진법 정수
		 * %x: 16진법 정수
		 * %f: 실수
		 * %s: 문자열
		 */
		public static void main(String[] args) {
			int a= 234;
			//1.  정수 출력
			
			//\n: 줄바꿈 \t: 탭공백
			System.out.printf("%d\n", a);
			
			//2. 정수를 자릿수에 맞춰서 출력
			//예시 : 5자리 맞춰서 출력 : %5d
			System.out.printf("%5d\n",a);
			
			//3. 정수를 자릿수에 맞추고 왼쪽 빈 공간을 0으로 채워서 출력.
			System.out.printf("%05d\n",a);
			
			//정수를 자릿수를 맞추고 왼쪽 정렬
			//단 왼쪽정렬은 0을 부혀서 정렬하기 때문에 기능이 불가느아다.
			//외? 외른쪽에 0이 붙으면 자릿수 표시인지 실제값이 0이 붙는건지 알수 없기 때문이다.
			System.out.printf("%-5d\n",a);
			
			//5. 정수를 16진법으로 표기하기
			//%x -> a~f를 소문자로
			//%X -> a~f를 대문자로
			
			//%x 에는 %d의 옵션값(0, -, 자릿수)가 동일하게 들어갈 수 있다.
			System.out.printf("%x\n", a);
			System.out.printf("%X\n", a);
			
			//%f: 실수
			double d = 3.141592;
			System.out.printf("%f\n", d);
			
			//%.2f: 소숫점 2자리까지 출력
			System.out.printf("%.2f\n", d);
			
			//%s: 스트링 변수의 값을 출력
			System.out.printf("%s\n", "Hello, WORLD!!!");
			
			//printf는 다양한 %문자를 섞어서 쓸 수 잇습니다.
			System.out.println("번호 이름 총점 평균");
			System.out.printf("%d %s %05d %.3f", 1, "조재영", 487, 487/5.0);
			
			
			
			

	}

}
