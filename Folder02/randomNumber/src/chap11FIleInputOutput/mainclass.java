package chap11FIleInputOutput;

import java.io.File;
import java.io.IOException;

public class mainclass {

	/*
		기능부 : file, upload, 
		로직부 : 직접 구현 dao, DTO, model
		windows -> 파일(file)로 구성되어있음
	 *.lib *.dll
	 *라이브러리, dynamic link library
					
					java 에서
	 *.jar파일.
		저장매체 -> 데이터 -> file, database(DB) DB=file입출력.
					이름	나이	주소
				       홍길동	나이	서울시  -> 홍길동의 이름 나이 주소만 뽑아내는것 : 파싱(parsing)
				       							parser:파싱하는프로그램을 칭함.
	 *.txt 모든 파일의 조상격이자, 2진형태로 바꿔둘 수 있으며, 외부에서 볼 수 없도록 할수도 있다.
		 파일 (Database) 목적 : data 관리목적, 저장, 유지목적이며 항목관리가 주된요인이다.
		 
		 				 목적 :  CRUD    Create(생성), Read(읽기), Update(갱신), Delete(삭제)를 묶어서 일컫는 말이다.				 
		 				   추가(insert), 삭제(delete), 읽기(read), 쓰기(write)
		 				 검색(search, select), 수정(update)
	 */
	public static void main(String[] args) { 
		
		//파일목록
		File fdir = new File("C:\\");
		/*
		 * String filelist[] = fdir.list(); for (int i = 0; i < filelist.length; i++) {
		 * System.out.println(filelist[i]); }
		 */
		File filelist[] = fdir.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {		//.isFile파일 인지 아닌지
				System.out.println("/t [파일] " + filelist[i].getName());
				
			}
			else if(filelist[i].isDirectory()) {
				System.out.println("[폴더] " + filelist[i].getName());
			}
			else {
				System.out.println("\t\t [?] " + filelist[i].getName());
			}
		}
		
		//파일생성.
		String fileStr = "d:\\tmp\\newFile.txt"; 
		File newFile = new File(fileStr);//여기까지는 파일 생성이 된것이 아니라 파일 포인터만 생성이 된것이다. 
//		newFile.createNewFile();//오류 Exception 생성된다. 무조건 exception 생성해 봐야한다.
		
		//방법1
//		try {
//			if(newFile.createNewFile()) {
//				System.out.println("Create file success.");
//			}else {
//				System.out.println("file create fail.");
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//방법2
//		newFile.createNewFile(); //작성후 마우스 올려서 surround try chatch 로 생성\
		
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//폴더생성(작업공간생성)
		String dirStr = "d:/tmp1/sub";
		File newDir = new File(dirStr);
		
//		if(newDir.mkdir()) {
		if(newDir.mkdirs()) {
			System.out.println("폴더생성 성공 !");
		}else {
			System.out.println("폴더 생성 실패 ");
		}
		
		String filename = "newfile1" + ".txt";
		File myfile = new File(dirStr + "\\" + filename);
		
		try {
			if(myfile.createNewFile()) {
				System.out.println(dirStr + "파일 생성 성공 ");
			}else {
				
			}
		} catch (Exception e) {
			
		}
		
		//파일 존재 여부 확인
		if(myfile.exists()) {
			System.out.println("파일이 존재 합니다.");
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		//파일 삭제
		/*
		if(myfile.delete()) {
			System.out.println("파일을 삭제했습니다..");
		}else {
			System.out.println("팡리 삭제하지 못했습니다. ");
		}
		*/
		
		//읽기 가능여부.
		
		if(myfile.canRead()) {
			System.out.println("파일 읽기가 가능합니다. ");
		}else {
			System.out.println("파일 읽기가 불불불가능합니다. ");
		}
		
		if(myfile.canWrite()) {
			System.out.println("파일 쓰 기 가 가능합니다. ");
		}else {
			System.out.println("파일 쓰 기가 불불불가능합니다. ");
		}
		
		
		
		
		
		
		
	}// end main

}//end class
