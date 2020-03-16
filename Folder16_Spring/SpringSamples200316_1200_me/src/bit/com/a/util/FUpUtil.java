package bit.com.a.util;

import java.util.Date;

public class FUpUtil {
	//myfile.txt -> f.indexOf('.') -> 6 으로 출력됨. 
	//파일명, 확장자명
	//f.substring(6) -> .txt
	//f.substring(0, 6) -> myfile
	// myfile.txt -> 23423423.txt    로 바꾼다. 
	//
	
	//파일명은 충돌이 일어나기 때문에 이름을 바꿔준다. 
	//랜덤으로 파일명을 생성하는데 중복이 절대 없는경우는 time으로 랜덤값을 출력하는것이다. 
	public static String getNewFileName(String f) {
		String filename="";
		String fpost="";
		
		if(f.indexOf('.') >= 0) {//확장자 명이 존재함. 
			fpost = f.substring(f.indexOf('.'));
			filename=new Date().getTime() + fpost;
			} 
			else {	//확장자 명이 없음. 
			filename= new Date().getTime() + ".back";
			
		}
		
		return filename;
	}
	
	

}//end of class
