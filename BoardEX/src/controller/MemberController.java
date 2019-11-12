package controller;

import java.util.ArrayList;
import java.util.Calendar;

import dto.BoardDTO;
import dto.MemberDTO;

public class MemberController {
	ArrayList<MemberDTO> list;

	public MemberController() {//void 붙히면 안된다.
		list = new ArrayList<MemberDTO>();
		MemberDTO m1 = new MemberDTO();
		m1.setId(1);
		m1.setUserId("admin");
		m1.setPassword("111");
		m1.setName("관리지1");

		MemberDTO m2 = new MemberDTO();
		m2.setId(2);
		m2.setUserId("admin2");
		m2.setPassword("111");
		m2.setName("관리지2");

		MemberDTO m3 = new MemberDTO();
		m3.setId(3);
		m3.setUserId("admin3");
		m3.setPassword("111");
		m3.setName("관리자3");
		
		MemberDTO m4 = new MemberDTO();
		m3.setId(4);
		m3.setUserId("admin4");
		m3.setPassword("111");
		m3.setName("관리자4");
		

		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);

	}// MemberController()

	public MemberDTO selectOne(String userId, String password) {
		for (MemberDTO m : list) {
			if (m.getUserId().equals(userId) && m.getPassword().equals(password)) {
				// 입력받은 비번과 아이디가 저장된 아이디비번과 같을때
				return m;

			}
		}

		return null;
	}
	
	//중복확인하기.
	public void insert (MemberDTO memberDTO) {
		boolean isAlready = false;
		for(MemberDTO m : list) {
			if(m.getUserId().equals(memberDTO.getUserId())) {
				isAlready = true;
			}//이미 같은 아이디가 있으면, insert 자체를 실행안하도록 한다.
		}
		if(!isAlready) {
			int id = list.get(list.size()-1).getId() +1;
			memberDTO.setId(id);
			list.add(memberDTO);
		}else {
			System.out.println("이미 존재하는 아이디 입니다. ");
		}
	}
	public String getWriterName(int id) {
		for(MemberDTO m : list) {
			if(m.getId() == id) {
				return m.getName();
			}
		}
		return null;
	}
	
	public void update(MemberDTO m) {//equals 메소드 생성해야함. (memberDTO)
		list.set(list.indexOf(m), m);
	}
	
	public void delete (MemberDTO m) {
		list.remove(m);
	}
	


	

}// end of class
