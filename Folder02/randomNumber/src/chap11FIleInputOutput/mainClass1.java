package chap11FIleInputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class mainClass1 {

	public static void main(String[] args) throws Exception{
		//file read 
		File file = new File("d:\\tmp\\newfile1.txt");//파일을 가져옴.
		
		FileReader fr = new FileReader(file);//throws Exception 시행하지 않는다면 try-catch해줘야한다.
		
		/*
		//한문자씩 읽어 들인다.
		int c = fr.read();//한글자씩 읽어들이며, int형이다.
		while(c != -1) {	//-1은 파일의 끝을 의미한다.// 문자는 아스키코드로 변환해서 읽어옴. 그러므로 아스키코드번호를 문자열로 바꿀 필요성이 있다. 
			System.out.println((char)c);
			c = fr.read();
		}
		*/
		
		/*
		int c;
		while((c=fr.read()) != -1) {	//-1은 파일의 끝을 의미한다.// 문자는 아스키코드로 변환해서 읽어옴. 그러므로 아스키코드번호를 문자열로 바꿀 필요성이 있다. 
			System.out.println((char)c);
			c = fr.read();
		}//이 방법은 사용해도 되지만 사용상에 약간의 문제가있다. 
		*/
		/*
		//Buffer == 저장공간
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str != null){
			System.out.println( str + " " );
			
		}
		br.close();//끝나면 close 해줘야 한다. 
		//reader 에서 문제가 별로 없지만 write 에서는 문제가 생길수 있다. 
		*/
		
		String str;
		BufferedReader br = new BufferedReader(fr);
		while((str = br.readLine()) != null){
			System.out.println( str + " " );
			
		}
		br.close();//끝나면 close 해줘야 한다.

	}//end class

}//end main
