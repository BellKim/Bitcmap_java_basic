package controller;

import java.util.ArrayList;

import dto.MemberDTO;

public class MemberController {
	ArrayList<MemberDTO> list;
	public void MemerController() {
		list = new ArrayList<MemberDTO>();
		MemberDTO m1 = new MemberDTO();
		m1.setId(1);
		m1.setUserId("admin");
		m1.setPassword("111");
		m1.setName("관리지");
		
		MemberDTO m2 = new MemberDTO();
		m2.setId(1);
		m2.setUserId("admin");
		m2.setPassword("111");
		m2.setName("관리지");
		
		MemberDTO m3 = new MemberDTO();
		m3.setId(1);
		m3.setUserId("admin");
		m3.setPassword("111");
		m3.setName("관리지");

		list.add(m1);
		list.add(m2);
		list.add(m3);

	}//MemberController()
	
	public MemberDTO selectOne(String userId, String password) {
		for (MemberDTO m : list) {
			if (m.getUserId().equals(userId) && m.getPassword().equals(password)) {
				//입력받은 비번과 아이디가 저장된 아이디비번과 같을때
				return m;

			}
		}
		
		
		
		return null;
	}
	

}// end of class
