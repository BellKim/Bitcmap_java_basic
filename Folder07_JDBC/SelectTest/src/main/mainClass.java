package main;

import DB.DBCONNECTON;
import dto.UserDTO;
import jdbc.SelectTest;

public class MainClass {
	public static void main(String[] args) {
		DBCONNECTON.initConnection();
		
		SelectTest st = new SelectTest();
		String id = "bbb";
		UserDTO dto =st.search(id);
		if(dto != null) {
			System.out.println(dto.toString());
			
		}else {
			System.out.println("id를 찾을수 없습니다. ");
		}
		
		
		id = "fff";
		dto = st.select(id);
		if(dto != null) {
			System.out.println(dto.toString());
			
		}else {
			System.out.println("id를 찾을수 없습니다. ");
		}
		
		
		
		List<UserDTO> list = st.getUserList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		
		

	}//end main

}
