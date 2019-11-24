package day04.chap04_loginSystemExample;
//로그인 시스템 만들기
//사용자로부터 id와 비밀번호를 받아서
//회원 가입 -> 로그인
//id: 4글자 이상 13글자 미만
//pw: 6글자 이상
//로그인 시에는 id와 비밀번호 둘중 하나만 틀려도
//정확히 뭐가 틀렸는지는 말하지 않고
//"id 혹은 pw"가 틀렸습니다.
//라고 출력이 되고
//둘다 맞을 시에는 "로그인 성공!" 이란 메시지가 출력되게 만드세요.

import java.util.Scanner;

public class Ex04{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가입할 ID를 입력하세요");
		String id = scanner.nextLine();
		System.out.println("사용할 PW 를 입력하세요");
		String pw = scanner.nextLine();
		
		
		if(id.length() >= 4 && id.length() < 13 && pw.length() >=6) {
			System.out.println("성공.\n 입력정보");
			System.out.println("id = " + id + "\n");
			System.out.println("pw = " + pw + "\n");
		}else {
			System.out.println("잘못 입력하셧습니다.");
		}
		
		

		int i=1;
		while(true) {
			
			System.out.println("\n\n 로그인을 시도합니다. \n\n");
			System.out.println("id입력 = ");
			String username = scanner.nextLine();
			System.out.println("pw입력 = ");
			String userpw = scanner.nextLine();
			
			if(id.equals(username) && pw.equals(userpw)) {
				System.out.println("로그인 성공");
				break;
			}else {
				System.out.println("로그인실패. 재시도 하세요  [ " + i + " ]");
			}
			i++;
		}
		
		
		
		
		
	}//end of main 
	
}//end of class 
