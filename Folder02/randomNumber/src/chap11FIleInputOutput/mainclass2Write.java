package chap11FIleInputOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class mainclass2Write {
	public static void main(String[] args) throws Exception {
		
		//파일쓰기
		File file = new File("d:\\tmp\\newfile.txt");
		/*
		//쓰기
		FileWriter fw = new FileWriter(file);
		fw.write("하이하이" + "\n");
		fw.close();//반드시 close 가 되어야 최종적으로 파일에 반영이 된다. 
		//이후에 파일읽기를 했을때 한글이 깨지지 않는다. (UTF-8 방식으로 저장되어있기 때문에)
		
		//추가쓰기
		FileWriter fappend = new FileWriter(file, true);
		fappend.write("건강하세요"+"\n");//개행을 해줘야 다음에 글 작성할때 그 다음라인부터 반영이 된다. 
		fappend.close();
		*/
		
		//문장으로 기입하기
		if(checkBeforeWriteFile(file)) {
			FileWriter fwriter = new FileWriter(file);		//파일 포인터 설정
			BufferedWriter bw = new BufferedWriter(fwriter);//문장으로 
			PrintWriter pw = new PrintWriter(bw);
			
			pw.print("안녕하세요"+"\n");
			pw.println("하이");
			pw.println("건강 하세욤");
			pw.close();
		}
		else {
			System.out.println("파일이 없가나 쓰기를 할 수 없습니다.");
		}

	}//end main
	
	static boolean checkBeforeWriteFile(File f) {
		if(f.exists()) {
			if(f.isFile()) {
				if(f.isFile() && f.canWrite()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}//end class
