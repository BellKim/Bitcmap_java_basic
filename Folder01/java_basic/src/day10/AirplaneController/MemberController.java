package day10.AirplaneController;

import java.util.ArrayList;

import day10.AirplaneDTO.MemberDTO;

public class MemberController {
	ArrayList<MemberDTO> list;
	public MemberController() {
		list = new ArrayList<MemberDTO>();
		
		MemberDTO m1 = new MemberDTO();
		m1.setId(1);
		m1.setName("김철수");
		
		list.add(m1);
		
		
		
	}

}
