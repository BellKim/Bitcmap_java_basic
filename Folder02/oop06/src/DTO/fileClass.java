package DTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class fileClass {
	File f;
	File file = new File("d:\\tmp\\MemberList.txt");

	
	
	public fileClass() {
		if(checkBeforeWriteFile(file)) {
			System.out.println("기존 파일을 찾았습니다.");
		}else {
		System.out.println("파일이 없가나 쓰기를 할 수 없습니다. 파일을 생성합니다.");
		String fileStr = "d:\\tmp\\MemberList.txt"; 
		File newFile = new File(fileStr);//여기까지는 파일 생성이 된것이 아니라 파일 포인터만 생성이 된것이다.
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}//end fileCLass
	
	public void createFile(MemberDTO[] memberDTO){
		
		if(checkBeforeWriteFile(file)) {
			
			
			FileWriter fwriter;
			try {
				
				fwriter = new FileWriter(file);//파일 포인터 설정
				BufferedWriter bw = new BufferedWriter(fwriter);//문장으로 
				PrintWriter pw = new PrintWriter(bw);
				
				
				
				
				pw.print("안녕하세요"+"\n");
				pw.println("하이");
				pw.println("건강 하세욤");
				for (int i = 0; i < memberDTO.length; i++) {
					pw.println(memberDTO[i].getNumber()+","
							+memberDTO[i].getName()+","
							+memberDTO[i].getAge()+","
							+memberDTO[i].getAddress()+" ");
					
//					pw.println(memberDTO[i].toString());
				}
				
				
				
				
				pw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else {
			System.out.println("파일이 없가나 쓰기를 할 수 없습니다. ");
		}
		
	}
	
	public void readFile() {
		
	}
	
	public void writeFile() {
		
	}
	
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
	
	
	
}//end of class

	