package day01;

public class Ex04 {
	public static void main(String[] args) {
		// switch는 한
//		해당 값이 있는 케이스문부터
//		break가 나오는 케이스까지 실행하게 된다.
//		break란 만나는 즉시 해당 코드의 block을 탈출한다.
		int myNumber = 1;
		switch (myNumber) {
		case 1:
			System.out.println("1입니다.");
//			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		case 4:
			System.out.println("4입니다.");
			break;
		}
		
//		switch문의 가장 흔한 예제
		int httpStatusCode = 200;
//		String response = " ";
		switch(httpStatusCode) {
		case 200:
			System.out.println("ok");
			//response = "원래 가야할 페이지 주소";
			break;
		case 404:
			System.out.println("404 page not found");
			//response = "redirect://error/404";
			break;
		case 400:
			System.out.println("400 bed Request");
			//response = "redirect://error/400";
			break;
		case 403:
			System.out.println("403 forbidden");
			//response = "redirect://error/403";
			break;
			
		}//end switch
		
		

	}//end of main

}//end of class
