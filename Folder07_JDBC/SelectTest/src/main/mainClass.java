package main;

import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;
import DTO.userDTO;
import jdbc.SelectTest;

public class mainClass {

	public static void main(String[] args) {
		
		DBConnection.getConnection();
		
		SelectTest st = new SelectTest();
		String id = "ggg";
		userDTO dto = st.search(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("id를 찾을수 없습니다. ");
		}
		
		
		
		SelectTest st1 = new SelectTest();
		id = "fff";
		dto = st1.select1(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("오류입니다. ");
		}
		
		
		
		SelectTest st2= new SelectTest();
		List<userDTO> list = null;
		list = st2.SelectAll();
		
		if(list != null) {
			System.out.println("c출력");
			for (userDTO userDTO : list) {
				System.out.println(userDTO);
			}	
		}else {
			System.out.println("값없음.");
		}
		
		
		
		
		
		
		
		

	}//end main 

}//end class
