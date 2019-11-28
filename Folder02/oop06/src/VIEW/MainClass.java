package VIEW;

import DAO.MemberDAO;
import DTO.fileClass;

public class MainClass {
	public static void main(String[] args) {
		MemberDAO memCont = new MemberDAO();
		memCont.init();
		memCont.loop();
		
//		fileClass fc = new fileClass();
		
		

		
	}//end main
}//end class
