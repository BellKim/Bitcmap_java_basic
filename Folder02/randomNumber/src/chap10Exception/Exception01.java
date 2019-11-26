package chap10Exception;

public class Exception01 {
	/*
	Exception : 예외 != 에러
				개발자용(유지보수)
				
 	baseball에서 1,2,3 숫자로 입력 받아야하는데....
 	문자를 입력하는 경우, 즉, 예상못한 예외값이 입력되 됬을때를 대비한 프로그래밍.
 number(숫자) => 1,2,3 -> A (문자) 로 입력 포맷이 달라졌을때 예외처리해서 멈춤이없도록하는것. 
 array -> index number int arr[] = new int[3]
 class => Scanner 를 import 하지 않았을경우, Exception 발생한다. 
 file -> 없다면, exception 발생. 
 int num[] = new int[2];
  	num[2] = 'a';
  	
  	
  	try{
  	
  		num[2] = 'a'; 	//exception 발생 가능성 있는 코드.
  	
  	}catch(예외클레스1 e){
  		메시지
  	}catch(예외클레스2 e2){
  		메시지
  	}catch(예외클레스3 e3){
  		메시지
  	}catch(예외클레스4 e4){
  		메시지
  	}finally{	// 이 예외케이스에는 무조건 이부분이 실행되서 복구한다.
  		//무조건 실행
  		//뒤처리
  			파일 close
  			DB 원상복구 ->rollback
  			*DB에 의도되지 않은 이상한 문자가 입력되는경우에 해당됨.		
  	}
 
 */

	public static void main(String[] args) {
		int num[] = {11, 22, 33};
		
		try {
			System.out.println("프로그램 시작 ");
			for(int i =0; i < 4; i++) {
				System.out.println(num[i]);
			}
			System.out.println("배열출력 완료 ");

		}catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("배열 범위 초과");
//			e.printStackTrace();
			System.out.println(e.getMessage());
//			return;	//문제 발생시 하위 예외처리는 안거치도록 만듬.  
					//그러나 finally는 이 구문을 나가서 실행됨. 
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally 로서 무조건 실행됨.");
		}
		
		System.out.println("프로그램 끝. ");
		
		funcExcp();
		

	}//end main
	
	static void funcExcp() throws ArrayIndexOutOfBoundsException{
		int n[] = {1,2,3};
//		try {
			
			for (int i = 0; i < 4; i++) {
				System.out.println(n[i]);
			}
			
//		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		
	}

}//end class

