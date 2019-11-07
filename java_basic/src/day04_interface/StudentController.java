package day04_interface;

import java.sql.Connection;
import java.util.ArrayList;

public class StudentController {
	private Connection conn;//DB와 연결하는 객체
	StudentController(ConnectionMaker m){
		conn=m.makeConnection();
	}	//커넥션 메이커에 ㄷ정의되어있는 데이터를 받아올것입니다.
	
	
	
//	이후코드에서는 conn객체를 사용하여 DB에 query를 보내고
//	결고를 ResultSet 객체에 담거나
//	입력, 수정, 삭제를 실행한다.
	
	//conn이 없으면


}//end of class
