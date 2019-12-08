package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import DAO.Human;

public class DataClass {
	private File file;

	public DataClass(String filename) {
		file = new File("d:\\tmp\\" + filename + ".txt");
	}

	public void createfile() {
		try {
			if (file.createNewFile()) {
				System.out.println("파일 생성 성공");
			} else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end method

	public void writeFile(String data[]) {

		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < data.length; i++) {
				pw.print(data[i]);
			}
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("성공적으로 작성되었습ㅁ니다.");

	}// writeFile

	public HashMap<String, Human> readFile(){
		HashMap<String, Human> map = new HashMap<String, Human>();
		try {
			if(checkBeforeReadFile(file)) {
				PrintWriter br = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		}else {
			System.out.println("파일을 읽거나 찾을 수 없습니다.");
		}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// end readFile
		return null;
	}

	private boolean checkBeforeReadFile(File f) {
		if (f.exists()) {
			if (f.isFile() && f.canRead()) {
				return true;
			}
		}
		return false;
	}// end checkBeforeReadFile

}// end class
